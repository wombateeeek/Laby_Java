package zadanie1;

public class Kula implements Figura_przestrzenna{
    double r;
    public Kula(double r){
        this.r = r;
    }
    @Override
    public double ObliczObjetosc() {
        return (4/3)*Math.PI*Math.pow(r,3);
    }
}
