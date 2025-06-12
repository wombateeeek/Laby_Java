public class zadanie_6 {
    public int dzialania(){
        Input input = new Input();
        System.out.println("Podaj a: ");
            int a = input.InputInt();
        System.out.println("Podaj b: ");
            int b = input.InputInt();
        System.out.println("Jakie działanie chcesz wykonać?");
        System.out.println("1 - dodawanie");
        System.out.println("2 - odejmowanie");
        System.out.println("3 - mnozenie");
        System.out.println("4 - dzielenie");
        int m = input.InputInt();
            switch (m){
                case 1:
                    System.out.println("Wybraleś dodawanie:");
                    return a+b;
                case 2:
                    System.out.println("Wybrales odejmowanie:");
                    return a-b;
                case 3:
                    System.out.println("Wybraleś mnozenie:");
                    return a*b;
                case 4:
                    System.out.println("Wybrales dzielenie");
                    return a/b;
                default:
                    System.out.println("Nie ma takiej wartosci!");
            }
            return 0;
    }
}
