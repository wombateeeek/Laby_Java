package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel panel1;
    private JButton wyświetlUczniówButton;
    private JButton wyświetlPersonelButton;
    private JButton wyjdźButton;

    public Menu() {
        setTitle("Menu");
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);
        //po kliknieciu zamknie okno
        wyjdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //po kliknieciu przenosi do panelu lista uczniow
        wyświetlUczniówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListaUczniow Lu = new ListaUczniow();
            }
        });
        //po kliknieciu przenosi do panelu z lista personelu
        wyświetlPersonelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListaPersonel lp = new ListaPersonel(); // tu daje gdzie przenosi
            }
        });
    }
}
