package GUI;

import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Logowanie extends JFrame{
    private JPanel panel1;
    private JButton ZalogujButton;
    private JTextField logowanie;
    private JPasswordField haslo;

    //tworzenie obiektu by sprawdzic logowanie
    private Zapytania_sql zapSql = new Zapytania_sql();
    private String username;

    public Logowanie(){
        setTitle("Logowanie");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);
        //wywola sprawdzenie czy username jest pusty czy nie czy jest taki uzytkownik i czy podał odpowiednie haslo
        ZalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = logowanie.getText().trim();
                String pin = new String(haslo.getPassword()).trim();

                if (username.isEmpty() || pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Wprowadź login i hasło", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    if (zapSql.sprawdzUzytkownika("admin",logowanie.getText(),new String(haslo.getPassword())
                    )) {
                        new Menu();
                        dispose();
                        System.out.println("Zalogowano jako Dyrektor");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nieprawidłowy login lub hasło", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Błąd bazy danych: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }
}
