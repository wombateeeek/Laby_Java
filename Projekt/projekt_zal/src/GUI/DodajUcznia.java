package GUI;

import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajUcznia extends JFrame {
    private JPanel panel1;
    private JTextField nazwisko;
    private JTextField nr_telefonu_opiekuna;
    private JButton zapiszButton;
    private JButton cofnijButton;
    private JTextField imie;
    private JTextField numer_w_dzienniku;
    private JComboBox<String> id_klasy;
    private Zapytania_sql zpql = new Zapytania_sql();

    public DodajUcznia() {
        setTitle("Dodaj ucznia");
        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String im = imie.getText().trim();
                String nz = nazwisko.getText().trim();
                String tel = nr_telefonu_opiekuna.getText().trim();
                String wybranaKlasa = (String) id_klasy.getSelectedItem();
                String nrDziennikaText = numer_w_dzienniku.getText().trim();

                //jesli jakies pole jest puste wyswietli blad
                if (im.isEmpty() || nz.isEmpty() || tel.isEmpty() || wybranaKlasa == null || nrDziennikaText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Wszystkie pola muszą być wypełnione!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //sprawdzenie telefonu numeru telefonu
                if (!tel.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(null, "Numer telefonu musi zawierać 9 cyfr.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //sprawdzenie czy numer w dzienniku to liczba
                try {
                    Integer.parseInt(nrDziennikaText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Numer w dzienniku musi być liczbą całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //wprowadzenie przez metode
                int idUcznia = zpql.dodajUcznia(im, nz, tel);
                if (idUcznia > 0) {
                    boolean przypisano = zpql.przypiszKlase(idUcznia, wybranaKlasa);
                    if (przypisano) {
                        JOptionPane.showMessageDialog(null, "Uczeń został dodany i przypisany do klasy!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Uczeń dodany, ale błąd przy przypisywaniu do klasy.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nie udało się dodać ucznia.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //ustawienie ze po kliknieciu cofnij pola beda puste
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imie.setText("");
                nazwisko.setText("");
                nr_telefonu_opiekuna.setText("");
                numer_w_dzienniku.setText("");
                id_klasy.setSelectedIndex(-1);
            }
        });
    }
}
