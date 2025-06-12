package zadanie1;

public class Stozek implements Figura_przestrzenna{
    double r,h;
    public Stozek(double r, double h){
        this.r = r;
        this.h = h;
    }

    @Override
    public double ObliczObjetosc() {
        return (Math.PI* Math.pow(r, 2) * h)/3;
    }
}
