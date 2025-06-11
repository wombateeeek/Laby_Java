public class Kucharz extends Personel{
    public Kucharz(String imie, String nazwisko, int id_personelu, String rola, String nr_telefonu, String email) {
        super(imie, nazwisko, id_personelu, rola, nr_telefonu, email);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Kucharz: "+imie+ " " + nazwisko);
    }

}
