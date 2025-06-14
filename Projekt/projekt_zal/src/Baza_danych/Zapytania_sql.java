package Baza_danych;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Zapytania_sql{

        // sprawdzanie uzytkownika
        public boolean sprawdzUzytkownika(String typ_uzytkownika, String nazwa, String haslo) throws SQLException {
            String sql = "SELECT * FROM uzytkownicy WHERE typ_uzytkownika = ? AND nazwa = ? AND haslo = ?";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, typ_uzytkownika);
                stmt.setString(2, nazwa);
                stmt.setString(3, haslo);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }

        //Usuwanie personelu
        public void usunPersonel(int idPersonelu) {
            try (Connection con = Polaczenie.getConnection()) {
                String sql = "DELETE FROM personel WHERE id_personelu = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idPersonelu);

                int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Usunięto pracownika o Id: " + idPersonelu);
                } else {
                    System.out.println("Nie znaleziono pracownika o Id: " + idPersonelu);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Wyswietlanie uczniow
        public void wyswietlUczniow() {
            String sql = "SELECT id_ucznia, imie, nazwisko, nr_telefonu_opiekuna FROM uczniowie";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                System.out.println("Lista uczniów:");
                while (rs.next()) {
                    int id = rs.getInt("id_ucznia");
                    String imie = rs.getString("imie");
                    String nazwisko = rs.getString("nazwisko");
                    String telefon = rs.getString("nr_telefonu_opiekuna");

                    System.out.printf("Id: %d, Imię: %s, Nazwisko: %s, Telefon opiekuna: %s%n",
                            id, imie, nazwisko, telefon);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Błąd przy pobieraniu danych uczniów.");
            }
        }

        //zamiana na tabele
        public DefaultTableModel pobierzUczn() {
            String[] kol = {"Id", "Imię", "Nazwisko", "Telefon opiekuna", "ID klasy", "Numer w dzienniku"};
            DefaultTableModel model = new DefaultTableModel(kol, 0);

            String sql = "SELECT u.id_ucznia, u.imie, u.nazwisko, u.nr_telefonu_opiekuna, " +
                    "uk.id_klasy, uk.numer_w_dzienniku " +
                    "FROM uczniowie u " +
                    "INNER JOIN uczniowie_klasy uk ON u.id_ucznia = uk.id_ucznia";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    Object[] wiersz = {
                            rs.getInt("id_ucznia"),
                            rs.getString("imie"),
                            rs.getString("nazwisko"),
                            rs.getString("nr_telefonu_opiekuna"),
                            rs.getInt("id_klasy"),
                            rs.getInt("numer_w_dzienniku") // nowa kolumna
                    };
                    model.addRow(wiersz);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return model;
        }



    //dodawanie uczniow
    public int dodajUcznia(String imie, String nazwisko, String nrTel) {
        int idUcznia = -1;//dzieki temu bedzie mozna wykryc czy cos jest nie tak, po wpisaniu poprawnego id wartosc zostanie nadpisana i uczen zostanie dodany do bazy
        //wstawianie do bazy
        try (Connection con = Polaczenie.getConnection()) {
            String sql = "INSERT INTO uczniowie (imie, nazwisko, nr_telefonu_opiekuna) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, imie);
            ps.setString(2, nazwisko);
            ps.setString(3, nrTel);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idUcznia = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idUcznia; //zwroci -1 jak sie nie uda dodac, ale z reguły doda jesli dane beda poprawnie wprowadzone inaczej wyskoczy komunikat
    }

    //przypisanie ucznia do klasy
    public boolean przypiszKlase(int idUcznia, String nazwa_Klasy) {
        try (Connection con = Polaczenie.getConnection()) {
            //Pobiera id_klasy by potem przypisać
            String szkola_Klasa = "SELECT id_klasy FROM klasy WHERE nazwa = ?";
            PreparedStatement ps_Klasa = con.prepareStatement(szkola_Klasa );
            ps_Klasa.setString(1, nazwa_Klasy);
            ResultSet rs = ps_Klasa.executeQuery();

            if (!rs.next()) return false;

            int idKlasy = rs.getInt("id_klasy");

            //Ustawia numer w dzienniku
            String Nr_w_dzk = "SELECT COUNT(*) AS liczba FROM uczniowie_klasy WHERE id_klasy = ?";
            PreparedStatement psLiczba = con.prepareStatement(Nr_w_dzk);
            psLiczba.setInt(1, idKlasy);
            ResultSet rs2 = psLiczba.executeQuery();
            int numer = rs2.next() ? rs2.getInt("liczba") + 1 : 1;

            //Wstawianie do tabeli uczniowie_klasy
            String sqlInsert = "INSERT INTO uczniowie_klasy (id_ucznia, id_klasy, numer_w_dzienniku) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(sqlInsert);
            psInsert.setInt(1, idUcznia);
            psInsert.setInt(2, idKlasy);
            psInsert.setInt(3, numer);
            psInsert.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    //usuwanie uczniow
        public int usunUczen(int idUcznia) {
            //zadeklarowanie dwóch komend DELETE FROM by usunac wiazania
            String sqlDeleteFromUczniowieKlasy = "DELETE FROM uczniowie_klasy WHERE id_ucznia = ?";
            String sqlDeleteFromUczniowie = "DELETE FROM uczniowie WHERE id_ucznia = ?";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement stmt1 = con.prepareStatement(sqlDeleteFromUczniowieKlasy);
                 PreparedStatement stmt2 = con.prepareStatement(sqlDeleteFromUczniowie)) {

                //Usuwanie powiązań z klasami
                stmt1.setInt(1, idUcznia);
                stmt1.executeUpdate();

                //Usuwanie ucznia
                stmt2.setInt(1, idUcznia);
                stmt2.executeUpdate();

                System.out.println("Uczeń o Id " + idUcznia + " został usunięty.");

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }

            return 0;
        }

        //Dodanie pracownika
        public boolean dodajPersonel(String imie, String nazwisko, String rola, double pensja, String email, String telefon) {
            String sql = "INSERT INTO personel (imie, nazwisko, rola, pensja, email, nr_telefonu) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setString(1, imie);
                pstmt.setString(2, nazwisko);
                pstmt.setString(3, rola);
                pstmt.setDouble(4, pensja);
                pstmt.setString(5, email);
                pstmt.setString(6, telefon);

                return pstmt.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

}


    // dodanie uzytkownika, gdyby rozwinąć aplikacje o np menu nauczyciela
        public int dodajUzytkownika(String typ, String nazwa, String haslo) {
            String sql = "INSERT INTO uzytkownicy (typ_uzytkownika, nazwa, haslo) VALUES (?, ?, ?)";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setString(1, typ);     // np. "admin" lub "uzytkownik"
                pstmt.setString(2, nazwa);   // np. "Jan"
                pstmt.setString(3, haslo);   // np. "Jan123"

                int inserted = pstmt.executeUpdate();

                if (inserted > 0) {
                    System.out.println("Dodano użytkownika: " + nazwa);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }

            return 0;
        }


        //Zmiana numeru opiekuna
        public void aktualizujTelefonOpiekuna(int idUcznia, String nowyNumer) {
            String sql = "UPDATE uczniowie SET nr_telefonu_opiekuna = ? WHERE id_ucznia = ?";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setString(1, nowyNumer);
                pstmt.setInt(2, idUcznia);
                pstmt.executeUpdate();
                System.out.println("Zaktualizowano numer telefonu opiekuna.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        //wyswietlanie po roli personelu, jakby dorobić wyszukiwanie po roli
        public void wyswietlaniePoRoli(String rola) {
            String sql = "SELECT imie, nazwisko, rola, pensja, email, nr_telefonu FROM personel WHERE rola = ?";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setString(1, rola);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    System.out.printf("%s %s | Rola: %s | Pensja: %.2f | Email: %s | Telefon: %s%n",
                            rs.getString("imie"),
                            rs.getString("nazwisko"),
                            rs.getString("rola"),
                            rs.getDouble("pensja"),
                            rs.getString("email"),
                            rs.getString("nr_telefonu"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    //wyswietlanie personelu
    //zamiana na tabele
    public DefaultTableModel pobierzPer() {
        String[] kolumny = {"Id personelu","Imię", "Nazwisko", "Rola","Pensja","Email","Nr telefonu"};
        DefaultTableModel model = new DefaultTableModel(kolumny, 0);

        String sql = "SELECT id_personelu, imie, nazwisko, rola, pensja, email, nr_telefonu FROM personel";

        try (Connection con = Polaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Object[] wiersz = {
                        rs.getInt("id_personelu"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("rola"),
                        rs.getString("pensja"),
                        rs.getString("email"),
                        rs.getString("nr_telefonu")
                };
                model.addRow(wiersz);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


        //Pokazywanie roli uczniow
        public DefaultTableModel pobierzUczniowZRolami() {
            String[] kolumny = {"Imię", "Nazwisko", "Funkcja", "Klasa"};
            DefaultTableModel model = new DefaultTableModel(kolumny, 0);

            String sql = """
        SELECT DISTINCT u.imie, u.nazwisko, uk.status, k.nazwa AS klasa
        FROM uczniowie u
        JOIN uczniowie_klasy uk ON u.id_ucznia = uk.id_ucznia
        JOIN klasy k ON uk.id_klasy = k.id_klasy
        WHERE uk.status IS NOT NULL AND uk.status <> ''
        ORDER BY k.nazwa
    """;

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    String imie = rs.getString("imie");
                    String nazwisko = rs.getString("nazwisko");
                    String funkcja = rs.getString("status");
                    String klasa = rs.getString("klasa");

                    model.addRow(new Object[]{imie, nazwisko, funkcja, klasa});
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return model;
        }


    //wyswietlenie klas, gdyby było sortowanie po klasach
        public void wyswietlKlasy() {
            String sql = "SELECT id_klasy, nazwa FROM klasy ORDER BY id_klasy";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                System.out.println("Lista klas:");
                while (rs.next()) {
                    System.out.printf("Id: %d | Nazwa: %s%n",
                            rs.getInt("id_klasy"),
                            rs.getString("nazwa"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Błąd podczas pobierania klas.");
            }
        }

        //zmiana pensji
        public void zmianaPensji(int idPersonelu, double nowaPensja) {
            String sql = "UPDATE personel SET pensja = ? WHERE id_personelu = ?";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setDouble(1, nowaPensja);
                pstmt.setInt(2, idPersonelu);

                //zmienna pomocnicza do komendy
                int updated = pstmt.executeUpdate();

                if (updated > 0) {
                    System.out.println("Zaktualizowano pensję pracownika o Id: " + idPersonelu + " na: " + nowaPensja);
                } else {
                    System.out.println("Nie znaleziono pracownika o Id: " + idPersonelu);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Błąd przy aktualizacji pensji personelu", e);
            }
        }


    //zmiana roli dla personelu
        public void zmianaRoliPersonelu(int idPersonelu, String nowaRola) {
            List<String> dozwoloneRole = Arrays.asList("nauczyciel", "kucharz", "sprzątacz");

            if (!dozwoloneRole.contains(nowaRola.toLowerCase())) {
                System.out.println("Nieprawidłowa rola: " + nowaRola);
                return;
            }

            String sql = "UPDATE personel SET rola = ? WHERE id_personelu = ?";

            try (Connection con = Polaczenie.getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setString(1, nowaRola);
                pstmt.setInt(2, idPersonelu);

                int updated = pstmt.executeUpdate();

                if (updated > 0) {
                    System.out.println("Zaktualizowano rolę pracownika o Id: " + idPersonelu + " na: " + nowaRola);
                } else {
                    System.out.println("Nie znaleziono pracownika o Id: " + idPersonelu);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Błąd przy aktualizacji roli personelu", e);
            }
        }


    //aktualizacja emailu personelu
    public void zmianaEmailaPersonelu(int idPersonelu, String nowyEmail) {
        String sql = "UPDATE personel SET email = ? WHERE id_personelu = ?";

        try (Connection con = Polaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nowyEmail);
            pstmt.setInt(2, idPersonelu);

            int updated = pstmt.executeUpdate();

            if (updated > 0) {
                System.out.println("Zaktualizowano email pracownika o Id: " + idPersonelu + " na: " + nowyEmail);
            } else {
                System.out.println("Nie znaleziono pracownika o Id: " + idPersonelu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Błąd przy aktualizacji emaila personelu", e);
        }
    }

    //aktualizacja telefonu personelu
    public void zmianaTelefonuPersonelu(int idPersonelu, String nowyTel) {
        String sql = "UPDATE personel SET nr_telefonu = ? WHERE id_personelu = ?";

        try (Connection con = Polaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nowyTel);
            pstmt.setInt(2, idPersonelu);

            int updated = pstmt.executeUpdate();

            if (updated > 0) {
                System.out.println("Zaktualizowano telefon pracownika o Id: " + idPersonelu + " na: " + nowyTel);
            } else {
                System.out.println("Nie znaleziono pracownika o Id: " + idPersonelu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Błąd przy aktualizacji telefonu personelu", e);
        }
    }


    // Aktualizacja telefonu i emaila personelu
    public void zmianaTeliEmaila(int idPersonelu, String nowyTel, String nowyEmail) {
        String sql = "UPDATE personel SET nr_telefonu = ?, email = ? WHERE id_personelu = ?";

        try (Connection con = Polaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nowyTel);
            pstmt.setString(2, nowyEmail);
            pstmt.setInt(3, idPersonelu);

            int updated = pstmt.executeUpdate();

            if (updated > 0) {
                System.out.println("Zaktualizowano dane pracownika o Id: " + idPersonelu +
                        "\nTelefon: " + nowyTel +
                        "\nEmail: " + nowyEmail);
            } else {
                System.out.println("Nie znaleziono pracownika o Id: " + idPersonelu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Błąd przy aktualizacji danych personelu", e);
        }
    }

    // Aktualizacja telefonu i emaila personelu i roli i pensji
    public void zmianaWszystko(int idPersonelu, String nowyTel, String nowyEmail, String nowaRola, Double nowaPensja) {
        String sql = "UPDATE personel SET nr_telefonu = ?, email = ?, rola = ?, pensja = ? WHERE id_personelu = ?";

        try (Connection con = Polaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nowyTel);
            pstmt.setString(2, nowyEmail);
            pstmt.setString(3, nowaRola);
            pstmt.setDouble(4, nowaPensja);
            pstmt.setInt(5, idPersonelu);

            int updated = pstmt.executeUpdate();

            if (updated > 0) {
                System.out.println("Zaktualizowano dane pracownika o Id: " + idPersonelu +
                        "\nTelefon: " + nowyTel +
                        "\nEmail: " + nowyEmail +
                        "\nRola: " + nowaRola +
                        "\nPensja: " + nowaPensja);
            } else {
                System.out.println("Nie znaleziono pracownika o Id: " + idPersonelu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Błąd przy aktualizacji danych personelu", e);
        }
    }

   //zmiana klasy
    public void zmienaKlasy(int idUcznia, String nazwaKlasy) throws SQLException {
        Connection conn = Polaczenie.getConnection();

        //znajdywanie id klasy po jej nazwie
        PreparedStatement znajdzKlase = conn.prepareStatement(
                "SELECT id_klasy FROM klasy WHERE nazwa = ?"
        );
        znajdzKlase.setString(1, nazwaKlasy);
        ResultSet rs = znajdzKlase.executeQuery();

        if (rs.next()) {
            int idKlasy = rs.getInt("id_klasy");

            //sprawdzanie czy uczen jest przypisany do jakiejś klasy
            PreparedStatement check = conn.prepareStatement(
                    "SELECT * FROM uczniowie_klasy WHERE id_ucznia = ?"
            );
            check.setInt(1, idUcznia);
            ResultSet rs2 = check.executeQuery();

            if (rs2.next()) {
                //"przeniesienie ucznia do innej klasy"
                PreparedStatement update = conn.prepareStatement(
                        "UPDATE uczniowie_klasy SET id_klasy = ? WHERE id_ucznia = ?"
                );
                update.setInt(1, idKlasy);
                update.setInt(2, idUcznia);
                update.executeUpdate();
            } else {
                //dodawnie od ostatniego numeru w dzienniku
                PreparedStatement nrDziennika = conn.prepareStatement(
                        "SELECT COUNT(*) + 1 AS numer FROM uczniowie_klasy WHERE id_klasy = ?"
                );
                nrDziennika.setInt(1, idKlasy);
                ResultSet rs3 = nrDziennika.executeQuery();
                int numerWDzienniku = rs3.next() ? rs3.getInt("numer") : 1;

                PreparedStatement insert = conn.prepareStatement(
                        "INSERT INTO uczniowie_klasy (id_ucznia, id_klasy, numer_w_dzienniku) VALUES (?, ?, ?)"
                );
                insert.setInt(1, idUcznia);
                insert.setInt(2, idKlasy);
                insert.setInt(3, numerWDzienniku);
                insert.executeUpdate();
            }
        } else {
            throw new SQLException("Nie znaleziono klasy: " + nazwaKlasy);
        }
    }

    //Zmiana statusu
    public void zmianaStatusu(int idUcznia, String nowyStatus) throws SQLException {
        try (Connection conn = Polaczenie.getConnection();
             PreparedStatement update = conn.prepareStatement(
                     "UPDATE uczniowie_klasy SET status = ? WHERE id_ucznia = ?"
             )) {

            if (nowyStatus == null || nowyStatus.trim().isEmpty()) {
                update.setNull(1, java.sql.Types.VARCHAR); // jeśli puste, ustaw NULL
            } else {
                update.setString(1, nowyStatus);
            }

            update.setInt(2, idUcznia);

            int affectedRows = update.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Nie znaleziono ucznia o Id: " + idUcznia);
            }
        }
    }


}
