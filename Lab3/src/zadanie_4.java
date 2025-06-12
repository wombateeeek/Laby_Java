import java.util.Random;

public class zadanie_4 {
    public int losowanie() {
        Input input = new Input();
        Random rand = new Random();
        System.out.println("Podaj liczbe wylosowanych elenemtow: ");
        int n = input.InputInt();
        int suma = 0;
        for (int i = 0; i < n; i++) {
            int liczba = rand.nextInt(55) - 10;
            System.out.println(liczba);
            if (liczba %2 == 0){
                suma += liczba;
            }
        }
        return suma;
    }
}
