import java.util.Arrays;

public class zadanie_3 {
    public void tablice3(){
        String[] tablica3;
        tablica3 = new String[]{"Ala", "Basia", "Kasia", "Kinga", "Darek", "Kacper"};
        System.out.println("Imiona z tablicy: ");
        for (String p: tablica3){
            System.out.print(p.toUpperCase()+" ");
        }
    }
}
