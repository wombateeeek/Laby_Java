package GUI;
import Baza_danych.Zapytania_sql;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AktualizacjaPersonel extends JFrame {
    private JPanel panel1;
    private JButton Wykonaj;
    private JButton cofnijButton;
    private JTextField email;
    private JTextField nr_tel;
    private JComboBox comboBox1;
    private JTextField id;
    private JTextField pensja;
    private Zapytania_sql zpql = new Zapytania_sql();

    public AktualizacjaPersonel(){
        setTitle("Aktualizacja personelu");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setContentPane(panel1); //wybranie panelu
        setVisible(true); //staje sie widoczny

        Wykonaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = id.getText().trim();
                String nowyEmail = email.getText().trim();
                String nowyTel = nr_tel.getText().trim();
                String nowaRola = (String) comboBox1.getSelectedItem();
                String pensjaText = pensja.getText().trim();

                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Proszę wpisać ID pracownika do aktualizacji.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    //zmienne pomocnicze
                    int idPersonelu = Integer.parseInt(idText);
                    boolean zmiana = false;
                    //sprawdzenie emaila
                    if (!nowyEmail.isEmpty()) {
                        if (!nowyEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                            JOptionPane.showMessageDialog(null, "Nieprawidłowy adres e-mail!", "Błąd", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        zpql.zmianaEmailaPersonelu(idPersonelu, nowyEmail);
                        zmiana = true;
                    }
                    //sprawdzenie telefonu
                    if (!nowyTel.isEmpty()) {
                        if (!nowyTel.matches("\\d{9}")) {
                            JOptionPane.showMessageDialog(null, "Numer telefonu musi zawierać 9 cyfr.", "Błąd", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        zpql.zmianaTelefonuPersonelu(idPersonelu, nowyTel);
                        zmiana = true;
                    }
                    //rola
                    if (nowaRola != null && !nowaRola.trim().isEmpty()) {
                        zpql.zmianaRoliPersonelu(idPersonelu, nowaRola);
                        zmiana = true;
                    }
                    //sprawdzenie pensji
                    if (!pensjaText.isEmpty()) {
                        try {
                            double nowaPensja = Double.parseDouble(pensjaText);
                            zpql.zmianaPensji(idPersonelu, nowaPensja);
                            zmiana = true;
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Pensja musi być liczbą!", "Błąd", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    if (!zmiana) {
                        JOptionPane.showMessageDialog(null, "Nie podano żadnych danych do aktualizacji.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Zaktualizowano dane pracownika.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Id musi być liczbą całkowitą.", "Błąd", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Błąd: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //ustawia pole id na puste po kliknieciu
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id.setText("");
                email.setText("");
                nr_tel.setText("");
                comboBox1.setSelectedIndex(-1);
            }
        });
    }
}
