import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Input InputS = new Input();
        System.out.println("Podaj numer zadania: ");
        int m = input.InputInt();

switch (m){
    case 1:
        zadanie_1 z1 = new zadanie_1();
        System.out.println(z1.imie + " lat " + z1.wiek);
        break;
    case 2:
        zadanie_2 z2 = new zadanie_2();
        System.out.println(z2.liczby());
        break;
    case 3:
        zadanie_3 z3 = new zadanie_3();
        System.out.println(z3.czyParzysta());
        break;
    case 4:
        zadanie_4 z4 = new zadanie_4();
        System.out.println(z4.czyPodzelne());
        break;
    case 5:
        zadanie_5 z5 = new zadanie_5();
        System.out.println(z5.potega());
        break;
    case 6:
        zadanie_6 z6 = new zadanie_6();
        System.out.println(z6.pierwiastek());
        break;
    case 7:
        zadanie_7 z7 = new zadanie_7();
        System.out.println(z7.czy_trojkat(5,8));
        break;
    default:
        System.out.println("Nie ma takiego zadania");
        break;
}







    }
}