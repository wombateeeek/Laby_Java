package GUI;

import Baza_danych.Zapytania_sql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsunUczen extends JFrame {
    private JPanel panel1;
    private JButton wykonajButton;
    private JButton cofnijButton;
    private JTextField id;
    private Zapytania_sql zpql = new Zapytania_sql();

    public UsunUczen(){
        setTitle("Usuń ucznia");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//zamkniecie okna nie aplikacji
        setContentPane(panel1); //odwolanie sie do panlu
        setVisible(true);

        wykonajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = id.getText().trim();//usuwanie białych znakow, by nie przeszkadzały w operacji

                //sprawdzamy czy pobrana wartosc jest pusta jesli tak to wyswietli komunikat
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Proszę podać Id ucznia do usunięcia.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    //deklarujemy zmienne pomocnicze do operacji, dzieki idUcznia bedziemy usuwac a poprzez potwierdz wyskoczy okienko z potwierdzeniem operacji
                    int idUcznia = Integer.parseInt(idText);

                    int potwierdz = JOptionPane.showConfirmDialog(
                            null,
                            "Czy na pewno chcesz usunąć ucznia o Id: " + idUcznia + "?",
                            "Potwierdzenie usunięcia",
                            JOptionPane.YES_NO_OPTION // w tym miejscu wyskoczy komunikat czy chcemy usunac danego ucznia
                    );

                    if (potwierdz == JOptionPane.YES_OPTION) {
                        zpql.usunUczen(idUcznia);
                        JOptionPane.showMessageDialog(null, "Uczeń został usunięty.");
                    }
                    //wylapuje przypadek jesli ktos wpisze np pięć zamiast 5
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
