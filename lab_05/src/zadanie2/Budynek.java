package zadanie2;

import java.time.LocalDate;

public class Budynek {
    private String name;
    private int rok_budowy;
    private int liczba_pieter;
    public Budynek(String name, int rok_budowy, int liczba_pieter){
        this.liczba_pieter = liczba_pieter;
        this.name = name;
        this.rok_budowy = rok_budowy;
    }

    public void WysInformacje(){
        System.out.println("Liczba pięter: "+ liczba_pieter+"\n Nazwa budynku: "+name+"\n Rok budowy: "+rok_budowy);
    }

    public void IleLat(){
        System.out.println(LocalDate.now().getYear() - rok_budowy);
    }
}
