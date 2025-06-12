public class zadanie_5 {
    public boolean czy_palindrom(){
        Input input = new Input();

        System.out.println("Podaj słowo: ");
        String slowo = input.InputString();

        int lewo = 0; // zakladam ze lewo = 0
        int prawo = slowo.length() - 1; //bo sa numerowane od 0;
        while(lewo < prawo){
            if (slowo.charAt(prawo) != slowo.charAt(lewo)){// do zmiennej slowo jest przypisane ze lewo odpowiada za pierwszy znak a prawo za ostatni
               return false;
            }
            lewo++;
            prawo --;
        }
    return true;
    }
}
