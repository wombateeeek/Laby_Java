import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame {
    private JTextField nrAlbumu;
    private JTextField imie;
    private JTextField nazwisko;
    private JComboBox comboBoxKierunek;
    private JButton zapiszButton;
    private JButton wyjscieButton;
    private JPanel MainPanel;

    public AddStudent() {
        setTitle("Dodaj studenta");
        setContentPane(MainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  = nrAlbumu.getText();
                String im  = imie.getText();
                String nazw = nazwisko.getText();
                String wyb = " " + comboBoxKierunek.getSelectedItem();
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}


