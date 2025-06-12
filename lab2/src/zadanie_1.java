public class zadanie_1 {
    public boolean fKwadratowa(){
        Input input  = new Input();
        System.out.println("Podaj a, b, c funkcji kwadratowej");
        double a = input.InputInt();
        double b = input.InputInt();
        double c = input.InputInt();
        double delta;
        boolean fKwadratowa = true;
        delta = Math.pow(b,2) - 4*a*c;
            if(a == 0){
                System.out.println("To nie jest funkcja kwadratowa, podaj nowe a");
                return false;
            }
            if(delta == 0){
                double x1 = -b/(2*a);
                System.out.println("Twoja funkcja kwadratowa ma jedno rozwiazanie x1: ");
                System.out.println(x1);
            }
            else if(delta < 0){
                System.out.println("Twoja funkcja kwadratowa nie ma rozwiazan rzeczywistych");
            }
            else{
                double x2 = (-b - Math.sqrt(delta))/(2*a);
                double x3 = (-b + Math.sqrt(delta))/(2*a);;
                System.out.println("Twoje rozwiazania rozwiazania: ");
                System.out.println(x2+ " " + x3);
            }
            return true;
    }
}
