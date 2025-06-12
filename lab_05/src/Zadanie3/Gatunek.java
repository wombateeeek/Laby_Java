package Zadanie3;

public abstract class Gatunek {
    public String nazwa_rodzaju;
    public String nazwa_gatunku;
    public int liczba_chromosomow;
    public int chromosomy_x;
    public String opis;

    public void setChromosomy_x(int chromosomy_x) {
        this.chromosomy_x = chromosomy_x;
    }

    public int getChromosomy_x() {
        return chromosomy_x;
    }

    public void setLiczba_chromosomow(int liczba_chromosomow) {
        this.liczba_chromosomow = liczba_chromosomow;
    }

    public int getLiczba_chromosomow() {
        return liczba_chromosomow;
    }

    public void setNazwa_gatunku(String nazwa_gatunku) {
        this.nazwa_gatunku = nazwa_gatunku;
    }

    public String getNazwa_gatunku() {
        return nazwa_gatunku;
    }

    public void setNazwa_rodzaju(String nazwa_rodzaju) {
        this.nazwa_rodzaju = nazwa_rodzaju;
    }

    public String getNazwa_rodzaju() {
        return nazwa_rodzaju;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public void WysInformacje(){
        System.out.println("Chromosomy X: "+chromosomy_x);
        System.out.println("Liczba chromosomow: "+liczba_chromosomow);
        System.out.println("Nazwa gatunku: "+nazwa_gatunku);
        System.out.println("Nazwa rodzaju: "+nazwa_rodzaju);
        System.out.println("Opis: "+opis);
    }
}
