public class zadanie_2 {
    public String liczby(){
        Input input = new Input(); // zadeklarowalem metode do wprowadzania przez uzytkownika
        System.out.println("Podaj liczby: ");
        int a = input.InputInt(); //najpierw wprowadzona metoda w klasie a potem z mojej klasy Input
        int b = input.InputInt();
        return "Suma " +(a + b)+ " Odejmowanie "+ (a - b) + " Mnozenie "+(a*b)+" Dzielenie "+(a/b);
    }
}
