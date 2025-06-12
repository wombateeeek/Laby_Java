import java.util.Scanner;

public class Input {

    Scanner sc = new Scanner(System.in);

    public int InputInt(){
        return sc.nextInt();
    }

    public boolean InputBoolean(){
        return sc.nextBoolean();
    }

    public String InputString(){
        return sc.nextLine();
    }

    public double InputDouble(){
        return sc.nextDouble();
    }
}
