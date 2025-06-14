public class Personel extends Osoba{
    private int id_personelu;
    private String rola;
    private String nr_telefonu;
    private String email;

    //konstrukor parametrony
    public Personel(String imie, String nazwisko, int id_personelu, String rola, String nr_telefonu, String email) {
        super(imie, nazwisko);
        this.id_personelu = id_personelu;
        this.rola = rola;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
    }

    //gettery settery
    public int getId_personelu() {
        return id_personelu;
    }

    public void setId_personelu(int id_personelu) {
        this.id_personelu = id_personelu;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void info(){
        System.out.println("Informacje o personelu: "+imie+" "+nazwisko+" rola: "+rola+" numer telefonu: "+nr_telefonu);
    }

}
