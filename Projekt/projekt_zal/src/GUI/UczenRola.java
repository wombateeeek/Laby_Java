package GUI;

import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.*;

public class UczenRola extends JFrame {
    private JTable tabelaUczniowZRola;
    private JScrollPane scrollPane;
    private Zapytania_sql zpql = new Zapytania_sql();

    public UczenRola() {
        setTitle("Uczniowie z funkcjami");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //zniknie okno bez zamkniecia aplikacji
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tabelaUczniowZRola = new JTable(zpql.pobierzUczniowZRolami());
        scrollPane = new JScrollPane(tabelaUczniowZRola);
        add(scrollPane, BorderLayout.CENTER); //ulozenie tego na dole na srodku panelu

        setVisible(true);
    }
}
