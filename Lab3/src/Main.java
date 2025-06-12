public class Main {
    public static void main(String[] args) {
        //wprowadzanie
        Input input = new Input();

        zadanie_1 z1= new zadanie_1();
        System.out.println(z1.studenci());

        zadanie_2 z2 = new zadanie_2();
        System.out.println(z2.dodatnie_ujemne());

        zadanie_3 z3 = new zadanie_3();
        System.out.println(z3.ciag_parzyste());

        zadanie_4 z4 = new zadanie_4();
        System.out.println("Suma: "+z4.losowanie());

        zadanie_5 z5 = new zadanie_5();
        System.out.println(z5.czy_palindrom());
    }
}