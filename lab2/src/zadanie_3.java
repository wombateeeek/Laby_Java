import java.util.Arrays;

public class zadanie_3 {
    public String sortowanie(){
        Input input = new Input();
        double a, b, c;
        System.out.println("Podaj 1 liczbe: ");
        a = input.InputDouble();
        System.out.println("Podaj 2 liczbe: ");
        b = input.InputDouble();
        System.out.println("Podaj 3 liczbe: ");
        c = input.InputDouble();
        double[] liczby = {a,b,c}; //tworze tablice doubli
        Arrays.sort(liczby); //to sortuje liczby

        // jesli chce w odwrotnej kolejnosci to
        // musze dodac Arrays.sort(liczby,Collections.reversOrder())

        //sposob petli
        // System.out.println("Posortowane liczby rosnąco: ");
        //for (double liczba: liczby){
        //    System.out.print(liczba);
        //}

        return Arrays.toString(liczby);
    }
}
