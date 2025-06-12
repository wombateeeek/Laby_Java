import java.util.Random;

public class zadanie_1 {
    public void tablice(){
        Input input = new Input();
        Random rand =  new Random();
        System.out.printf("Podaj ile chcesz miec wylosowanych elementow: ");
        int n = input.InputInt();
        System.out.printf("Podaj początek przedziału: ");
        int m = input.InputInt();
        System.out.printf("Podaj koniec przedziału: ");
        int k = input.InputInt();
        int i, liczba, suma = 0;
        float srednia = 0f;
        int[] tab = new int[n];
        for (i = 0; i < n; i++ ){
            liczba = rand.nextInt(k - m +1) +m;
            //System.out.printf(" " +String.valueOf(liczba));
            tab[i] = liczba;
        }
        for (int p: tab){
            System.out.println(String.valueOf(p));
        }
        for (int o: tab){
            suma += o;
        }
        System.out.print("Suma tablicy: ");
        System.out.println(suma);

        srednia = (float) (suma /n);
        System.out.print("Srednia: ");
        System.out.println(srednia);
    }
}