public class zadanie_2 {
    public String dodatnie_ujemne(){
        Input input = new Input();
        System.out.println("Podaj ilość liczb do zsumowania, podaj zarówno dodatnie jak i ujemne(ujemne i dodatnie beda iloczne osobno): ");
        int n = input.InputInt();
        double ujemne = 0.0;
        double dodatnie = 0.0;
        int i = 0;
        while(n > i){
            System.out.println("Podaj liczbę: "+(i+1));
            double liczba = input.InputDouble();
            if (liczba < 0){
                ujemne += liczba;
            }
            else {
                dodatnie += liczba;
            }
            i = i+1;
        }

        return "Suma dla liczb dodatnich: "+dodatnie+" suma dla liczb ujemnych: "+ujemne;
    }
}
