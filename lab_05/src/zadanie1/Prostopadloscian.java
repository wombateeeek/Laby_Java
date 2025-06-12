package zadanie1;

public class Prostopadloscian implements Figura_przestrzenna {
    double a,b,c;

    public Prostopadloscian(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double ObliczObjetosc() {
        return a*b*c;
    }
}
