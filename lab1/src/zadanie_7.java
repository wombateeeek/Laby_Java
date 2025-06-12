import java.util.Random;

public class zadanie_7 {
    public boolean czy_trojkat(int a, int b){
        Random r = new Random();
        int n = r.nextInt(a,b);
        int m = r.nextInt(a,b);
        int k = r.nextInt(a,b);
        System.out.println(n+" "+m+" "+k);
        return Math.pow(n, 2) + Math.pow(m, 2) == Math.pow(k, 2);
    }
}
