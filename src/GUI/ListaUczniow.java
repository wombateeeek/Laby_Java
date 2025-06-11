package GUI;

import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaUczniow extends JFrame {
    private JTable tabelaUczniow;
    private JButton wyjdz;
    private JComboBox<String> dzialania;
    private JScrollPane scrollPane;
    Zapytania_sql zpql = new Zapytania_sql();

    public ListaUczniow() {
        setTitle("Lista uczniów");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // pobieranie modelu tabeli
        tabelaUczniow = new JTable(zpql.pobierzUczn());
        tabelaUczniow.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabelaUczniow);
        add(scrollPane, BorderLayout.CENTER);

        // Panel dolny z przyciskiem i rozwijaną listą
        wyjdz = new JButton("Wyjdź");
        dzialania = new JComboBox<>(new String[]{
                "-- Wybierz działanie --",
                "Dodaj ucznia",
                "Usuń ucznia",
                "Aktualizuj ucznia",
                "Pokaż uczniów z rolą"
        });

        JPanel dol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dol.add(dzialania);
        dol.add(wyjdz);
        add(dol, BorderLayout.SOUTH);

        //zdarzenie przycisku wyjdz
        wyjdz.addActionListener(e -> {
            dispose();
            new Menu();
        });

        // obsługa wyboru z JComboBox
        dzialania.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wybor = (String) dzialania.getSelectedItem();
                if (wybor == null) return;

                switch (wybor) {
                    case "Dodaj ucznia":
                        new DodajUcznia();
                        break;
                    case "Usuń ucznia":
                        new UsunUczen();
                        break;
                    case "Aktualizuj ucznia":
                        new AktualizacjaUczen();
                        break;
                    case "Pokaż uczniów z rolą":
                        new UczenRola();
                        break;
                    default:
                        break;
                }


                dzialania.setSelectedIndex(0);
            }
        });

        setVisible(true);
    }
}
