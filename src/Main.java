import GUI.Logowanie;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*Założeniem programu jest sterowanie szkołą w sposób podstawowy (dodawanie, usuwanie itd. personelu
         czy uczniów) z panelu dyrektora*/
        SwingUtilities.invokeLater(() -> new Logowanie());
    }
}