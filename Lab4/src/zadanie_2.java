import java.util.Random;

public class zadanie_2 {
    public void tablice2(){
        Random rand = new Random();
        int[] tablica1 = new int[5];
        int[] tablica2 = new int[5];
        int liczba;
        for (int i = 0; i < 5; i++){
            liczba = rand.nextInt(30)-10; //tutaj liczba ma przypisana losowa wartosc do iteracji i
            tablica1[i] = liczba; // po kazdej iteracji i tab dla 1 elementu ma losowa wartosc itd dla kazdego i <5
        }
        System.out.print("Wszystkie elementy tablicy1:");
        for (int p: tablica1){ //to jes iteracja do wyswietlenia kazdego elementu tablicy
            System.out.print(" "+p+" ");
        }
        System.out.println();
        System.out.print("Indeksy nieparzyste");
        for (int i = 0; i < tablica1.length; i+=2){
                System.out.print(" "+tablica1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++){
            liczba = rand.nextInt(30)-10; //tutaj liczba ma przypisana losowa wartosc do iteracji i
            tablica2[i] = liczba; // po kazdej iteracji i tab dla 1 elementu ma losowa wartosc itd dla kazdego i <5
        }
        System.out.print("Wszystkie elementy tablicy2:");
        for (int p: tablica2){ //to jes iteracja do wyswietlenia kazdego elementu tablicy
            System.out.print(" "+p+" ");
        }
        System.out.println();
        System.out.print("Indeksy parzyste");
        for (int i = 1; i< tablica2.length; i+=2){
            System.out.print(" "+tablica2[i]+ " ");
        }
    }
}
