public class zadanie_4 {
    public String pogoda() {
        Input input = new Input();
        System.out.println("Podaj zdarzenie, odpowiedz 1-tak lub 0- nie: ");
        System.out.println("Czy autobus jest na przystanku? ");
        int a = input.InputInt();
        System.out.println("Czy pada? ");
        int p = input.InputInt();
            if(a > 2 || a < 0 && p > 2 || p < 0){
                return("Podano nieprawidlowe dane");
        }
            else{
                if (a == 1 && p == 1){
                    return "Weź parasol, dostaniesz się na uczelnie";
                } else if (a == 0 && p == 1) {
                    return "Nie dostaniesz się na uczelnie";
                }
                else{
                    return "Dostaniesz się na uczelnie, miłego dnia i pięknej pogody";
                }
            }
    }
}
