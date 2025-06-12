public class zadanie_1 {
    public double studenci(){
        Input input = new Input();
        System.out.println("Podaj liczbę studentów: ");
            int n = input.InputInt();
            int i = 0;
            double suma = 0.0;
            if (n < 0){
                System.out.println("Podałeś nieprawidłowe dane, spróbuj jeszcze raz");
                return 0.0;
            }
            else {
                while (n > i) {
                    System.out.println("Podaj ocene studenta: ");
                    suma += input.InputInt();
                    i = i + 1;
                }
                System.out.print("Srednia jest rowna: ");
            }
        return (suma / n);
    }
}
