import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStudent extends JFrame{
    private JButton usunButton;
    private JButton wsteczButton;
    private JButton edytujButton;
    private JButton szukajButton;
    private JTable table1;
    private JTextField textField1;
    private JPanel MainPanel;
    private JButton okButton;

    private String[] columnNames = {"Imię", "Nazwisko", "Kierunek", "Semestr"};
    private Object[][] data = {
            {"Anna", "Kowalska", "Informatyka", "3"},
            {"Jan", "Nowak", "Automatyka", "2"},
            {"Ewa", "Wiśniewska", "Matematyka", "4"}
    };

    public ViewStudent(){
        setTitle("Lista Studentów");
        setContentPane(MainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Tworzenie modelu tabeli
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Obsługa przycisku OK
        okButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < table1.getColumnCount(); i++) {
                    sb.append(columnNames[i]).append(": ")
                            .append(table1.getValueAt(selectedRow, i)).append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString(), "Dane studenta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Nie zaznaczono żadnego wiersza!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Obsługa przycisku Usuń
        usunButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Nie zaznaczono żadnego wiersza!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                System.out.println(text);
            }
        });
    }
}
