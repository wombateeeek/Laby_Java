package zadanie1;

public class Prostokat implements Figura_plaska{
    double a, b;

    public Prostokat(double a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double ObliczObwod() {
        return 2*a+2*b;
    }

    @Override
    public double ObliczPole() {
        return a*b;
    }
}
