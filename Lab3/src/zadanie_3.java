public class zadanie_3 {
    public String ciag_parzyste(){
        Input input = new Input();
        System.out.println("Podaj ile chcesz liczb do zsumowania: ");
        int n = input.InputInt();
        int suma_parzysta = 0;
            for (int i = 0; i < n; i++){
                System.out.println("Podaj liczbę: "+(i+1));
                int liczba = input.InputInt();
                if (liczba %2 == 0){
                    suma_parzysta += liczba;
                }
            }
        return "Suma liczb parzystych: " + suma_parzysta;
    }
}
