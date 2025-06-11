package GUI;
import Baza_danych.Zapytania_sql;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajPersonel extends JFrame {
    private JPanel panel1;
    private JButton wykonajButton;
    private JButton cofnijButton;
    private JTextField imie;
    private JTextField nazwisko;
    private JTextField nr_telefonu;
    private JTextField email;
    private JTextField pensja;
    private JComboBox Rola;
    private Zapytania_sql zpql = new Zapytania_sql();

    public DodajPersonel() {
        setTitle("Dodaj personel");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        setVisible(true);

        wykonajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String im = imie.getText().trim();
                String nz = nazwisko.getText().trim();
                String tel = nr_telefonu.getText().trim();
                String em = email.getText().trim();
                String rola = (String) Rola.getSelectedItem();
                String pensjaText = pensja.getText().trim();

                //jesli jakies pole bedzie puste to wyswietli blad
                if (im.isEmpty() || nz.isEmpty() || tel.isEmpty() || em.isEmpty() || pensjaText.isEmpty() || rola == null) {
                    JOptionPane.showMessageDialog(null, "Wszystkie pola muszą być wypełnione!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //sprawdzenie czy przy podawaniu e-maila jest @
                if (!em.contains("@") || !em.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    JOptionPane.showMessageDialog(null, "Nieprawidłowy adres e-mail.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //sprawdzenie czy numeru telefonu jest zapisany za pomoca cyfr
                if (!tel.matches("\\d{9,12}")) {
                    JOptionPane.showMessageDialog(null, "Numer telefonu musi zawierać od 9 do 12 cyfr.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    //zmienne pomocnicze
                    double pensja = Double.parseDouble(pensjaText);
                    boolean wynik = zpql.dodajPersonel(im, nz, rola, pensja, em, tel);

                    if (wynik) {
                        JOptionPane.showMessageDialog(null, "Personel został dodany.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Błąd podczas dodawania personelu.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Pensja musi być liczbą", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    //ustawia pola na puste po kliknieciu
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imie.setText("");
                nazwisko.setText("");
                nr_telefonu.setText("");
                email.setText("");
                pensja.setText("");

            }
        });

    }
}


