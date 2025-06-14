public class Sprzątacz extends Personel{
    public Sprzątacz(String imie, String nazwisko, int id_personelu, String rola, String nr_telefonu, String email) {
        super(imie, nazwisko, id_personelu, rola, nr_telefonu, email);
    }

    //nadpisana metoda do wyswietlania informacji
    @Override
    public void info() {
        super.info();
        System.out.println("Sprzątacz: "+imie+ " " + nazwisko);
    }
}
