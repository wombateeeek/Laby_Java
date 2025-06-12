public class zadanie_5 {
    public String znizka(){
        Input input = new Input();
        System.out.println("Tak jak w zadaniu poprzednim, podaj zdarzenia (1 - tak, 0 - nie)");
        System.out.println("Masz zniżkę?");
            int z = input.InputInt();
        System.out.println("Otrzymałeś premię?");
            int p = input.InputInt();
        if (z > 2 || z < 0 && p > 2 || p < 0){
            return "Nieprawidłowe dane";
        }
        else{
            if (z == 1 && p == 1){
                return "Możesz Kupić samochód!";
            } else if (z == 0 && p == 0) {
                return "Zakup trzeba odłożyć na później... Zniżki na samochód nie ma";
            }
            else if (z == 1 || p == 1) {
                return "Mozesz kupić samochód , znizki nie ma";
            }
        }
        return "";
    }
}
