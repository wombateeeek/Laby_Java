package zadanie1;

public class Szescian implements Figura_przestrzenna{
    double a;

    public Szescian(double a){
        this.a = a;
    }
    @Override
    public double ObliczObjetosc() {
        return a*a*a;
    }
}
