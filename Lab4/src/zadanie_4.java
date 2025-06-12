import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class zadanie_4 {
    public void tablice4(){
        Input input = new Input();
        System.out.println("Podaj ile liczb chcesz wprowadzic: ");
        int n = input.InputInt();
        int[] tab = new int[n];
        int liczba;
            for (int i = 0; i < n; i++){
                System.out.println("Podaj liczbę: ");
                liczba = input.InputInt();
                tab[i] = liczba;
            }
            for (int i = 0; i < n - 1;i++){
                for (int j = 0; j < n - i -1; j++){
                    if (tab[j] > tab[j +1]){
                        int temp;
                        temp = tab[j];
                        tab[j] = tab[j+1];
                        tab[j+1] = temp;
                    }
                }
            }
            
        System.out.println("Wypisanie: ");
           for (int  i = 0; i < n; i++){
               System.out.println(tab[i]);
            }
    }
}

