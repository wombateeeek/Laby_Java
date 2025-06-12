package zadanie1;

public class Kwadrat implements Figura_plaska{
    double a;


public Kwadrat(double a){
    this.a = a;
}

    @Override
    public double ObliczObwod() {
        return 4*a;
    }

    @Override
    public double ObliczPole() {
        return a*a;
    }
}
