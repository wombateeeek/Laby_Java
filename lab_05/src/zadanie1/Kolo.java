package zadanie1;

public class Kolo implements Figura_plaska{
    double r;

    public Kolo(double r){
        this.r = r;
    }
    @Override
    public double ObliczObwod() {
        return 2*Math.PI*r;
    }

    @Override
    public double ObliczPole() {
        return Math.PI*Math.pow(r,2);
    }
}
