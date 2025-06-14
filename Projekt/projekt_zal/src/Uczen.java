public class Uczen extends Osoba{
    private int id_ucznia;
    private String nr_telefonu_opiekuna;
    private String status;
    private int numer_w_dzienniku;
    private int id_klasy;

    //konstruktor parametrowy
    public Uczen(String imie, String nazwisko, int id_ucznia, String nr_telefonu_opiekuna, String status,int id_klasy, int numer_w_dzienniku){
        super(imie,nazwisko);
        this.nr_telefonu_opiekuna = nr_telefonu_opiekuna;
        this.id_ucznia = id_ucznia;
        this.status = status;
        this.id_klasy = id_klasy;
        this.numer_w_dzienniku = numer_w_dzienniku;
    }

    //gettery i settery
    public int getId_ucznia() {
        return id_ucznia;
    }

    public void setId_ucznia(int id_ucznia) {
        this.id_ucznia = id_ucznia;
    }

    public String getnr_telefonu_opiekuna() {
        return nr_telefonu_opiekuna;
    }

    public void setnr_telefonu_opiekuna(String nr_telefonu_opiekuna) {
        this.nr_telefonu_opiekuna = nr_telefonu_opiekuna;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNr_telefonu_opiekuna() {
        return nr_telefonu_opiekuna;
    }

    public void setNr_telefonu_opiekuna(String nr_telefonu_opiekuna) {
        this.nr_telefonu_opiekuna = nr_telefonu_opiekuna;
    }

    public int getNumer_w_dzienniku() {
        return numer_w_dzienniku;
    }

    public void setNumer_w_dzienniku(int numer_w_dzienniku) {
        this.numer_w_dzienniku = numer_w_dzienniku;
    }

    public int getId_klasy() {
        return id_klasy;
    }

    public void setId_klasy(int id_klasy) {
        this.id_klasy = id_klasy;
    }

    //te metody wypisza czy dane osoby maja jakas funkcje
    public boolean maFunkcje() {
        return status != null && !status.isEmpty();
    }
    public String Opis() {
        return imie + nazwisko + id_klasy + numer_w_dzienniku + (maFunkcje() ? ", " + status : "");
    }

    //metoda do wyswietlania informacji
    public void info(){
        System.out.println("Informacje o uczniu: "+imie+" "+nazwisko+" rola: "+status+ " id ucznia: "+id_ucznia+" klasa: "+id_klasy+" numer w dzienniku: "+numer_w_dzienniku+" numer telefonu do opiekuna: "+nr_telefonu_opiekuna);
    }
}
