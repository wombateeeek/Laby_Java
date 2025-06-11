package GUI;

import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsunPersonel extends JFrame {
    private JPanel panel1;
    private JButton wykonajButton;
    private JButton cofnijButton;
    private JTextField id;
    private Zapytania_sql zpql = new Zapytania_sql();

    public UsunPersonel(){
        setTitle("Usuń personel");
        setSize(400, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);

        wykonajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = id.getText().trim();// przez .trim() usuwam białe znaki by nie było problemów podczas usuwania

                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Proszę podać Id personelu do usunięcia.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // inicjowanie zmiennej pomocniczej
                    int idPersonelu = Integer.parseInt(idText);

                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Czy na pewno chcesz usunąć pracownika o Id: " + idPersonelu + "?",
                            "Potwierdzenie usunięcia",
                            JOptionPane.YES_NO_OPTION //okienko z potwierdzeniem operacji
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        zpql.usunPersonel(idPersonelu);
                        JOptionPane.showMessageDialog(null, "Usunięto pracownika.");
                    }
                    //zabezpieczenie przed wpisaniem słów
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Id musi być liczbą całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


//ustawia pole id na puste po kliknieciu
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id.setText("");
            }
        });
    }
}
