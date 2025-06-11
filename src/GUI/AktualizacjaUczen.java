package GUI;

import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AktualizacjaUczen extends JFrame {
    private JPanel panel1;
    private JButton Wykonaj;
    private JButton cofnijButton;
    private JTextField telefon_rodzica;
    private JTextField idUcznia;
    private JComboBox<String> rola_w_klasie;
    private JComboBox<String> klasyWszkole;
    private Zapytania_sql zpql = new Zapytania_sql();

    public AktualizacjaUczen() {
        setTitle("Aktualizuj ucznia");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);

        Wykonaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idUcznia.getText().trim();
                String klasa = (String) klasyWszkole.getSelectedItem();
                String telefon = telefon_rodzica.getText().trim();
                String rola = (String) rola_w_klasie.getSelectedItem();

                //wymusza wpisanie id by zrobic aktualizacje danego ucznia
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Proszę wpisać Id ucznia do aktualizacji.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    //zmienne pomocnicze
                    int idUczen = Integer.parseInt(idText);
                    boolean zmiana = false;
                    //sprawdzenie numeru
                    if (!telefon.isEmpty()) {
                        if (!telefon.matches("\\d{9,12}")) {
                            JOptionPane.showMessageDialog(null, "Numer telefonu musi zawierać od 9 do 12 cyfr.", "Błąd", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        zpql.aktualizujTelefonOpiekuna(idUczen, telefon);
                        zmiana = true;
                    }
                    //sprawdza czy ktores z pol nizej jest poste i eliminuje biale znaki
                    if (klasa != null && !klasa.trim().isEmpty()) {
                        zpql.zmienaKlasy(idUczen, klasa);
                        zmiana = true;
                    }

                    if (rola != null) {
                        zpql.zmianaStatusu(idUczen, rola);
                        zmiana = true;
                    }

                    if (!zmiana) {
                        JOptionPane.showMessageDialog(null, "Nie podano żadnych danych do aktualizacji.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Zaktualizowano dane ucznia.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID musi być liczbą całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Błąd: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //ustawia pole id na puste po kliknieciu
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klasyWszkole.setSelectedIndex(-1);
                telefon_rodzica.setText("");
                rola_w_klasie.setSelectedIndex(-1);
            }
        });
    }
}
