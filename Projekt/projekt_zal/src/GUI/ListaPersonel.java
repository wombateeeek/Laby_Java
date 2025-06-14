package GUI;
import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaPersonel extends JFrame {
        private JTable tabelaPersonelu;
        private JButton wyjdz;
        private JComboBox<String> dzialania;
        private JScrollPane scrollPane;
        Zapytania_sql zpql = new Zapytania_sql();

        public ListaPersonel() {
            setTitle("Lista personelu");
            setSize(600, 400);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            // pobieranie modelu tabeli
            tabelaPersonelu = new JTable(zpql.pobierzPer());
            tabelaPersonelu.setFillsViewportHeight(true);
            scrollPane = new JScrollPane(tabelaPersonelu);
            add(scrollPane, BorderLayout.CENTER);

            // Panel dolny z przyciskiem i rozwijaną listą
            wyjdz = new JButton("Wyjdź");
            dzialania = new JComboBox<>(new String[]{
                    "-- Wybierz działanie --",
                    "Dodaj personel",
                    "Usuń personel",
                    "Aktualizuj personel"
            });

            //panel na dole okienka do obslugi zdarzenia przycisku wyjdz oraz rozwijalnej listy
            JPanel dol = new JPanel(new FlowLayout(FlowLayout.CENTER));
            dol.add(dzialania);
            dol.add(wyjdz);
            add(dol, BorderLayout.SOUTH);

            // Obsługa przycisku Wyjdź ktora cofa do menu
            wyjdz.addActionListener(e -> {
                dispose();
                new Menu();
            });

            // Obsługa wyboru z JComboBox i przeniesienie do danych okienek
            dzialania.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String wybor = (String) dzialania.getSelectedItem();
                    if (wybor == null) return;

                    switch (wybor) {
                        case "Dodaj personel":
                            new DodajPersonel();
                            break;
                        case "Usuń personel":
                            new UsunPersonel();
                            break;
                        case "Aktualizuj personel":
                            new AktualizacjaPersonel();
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
