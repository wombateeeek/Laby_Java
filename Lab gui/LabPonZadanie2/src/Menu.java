import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel MainPanel;
    private JButton wyjscieButton;
    private JButton wyświetlStudentówButton;
    private JButton dodajNowegoStudentaButton;

    public Menu() {
        setTitle("Menu");
        setContentPane(MainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);

            }
        });
        wyświetlStudentówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        dodajNowegoStudentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddStudent addStudent = new AddStudent();
                addStudent.setVisible(true);
            }
        });
    }
}
