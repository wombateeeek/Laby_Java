import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    public int InputInt() {
        return sc.nextInt();
    }
    public double InputDouble() {
        return sc.nextDouble();
    }
    public String InputString() {
        return sc.nextLine();
    }
}
