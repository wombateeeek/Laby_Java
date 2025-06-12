import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    // wpisanie klasy przez ktora bede podawal dane

    public int InputInt(){ //to jest moja metoda do wprowadzania liczb cal
        return sc.nextInt();
    }
    public String InputString(){ // -||- do wprowadzania znakow
        return sc.nextLine();
    }
    public double InputDouble(){
        return sc.nextDouble();
    }
}
