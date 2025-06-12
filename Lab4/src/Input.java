import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    int InputInt(){
        return sc.nextInt();
    }
    double InputDouble(){
        return  sc.nextDouble();
    }
    String InputString(){
        return sc.nextLine();
    }
}
