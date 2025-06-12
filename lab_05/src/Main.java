import Zadanie3.*;
import zadanie1.*;
import zadanie2.Budynek;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
// czym sie rozni class od interface - class i extends gdy cos ma podobne dane a interface gdy maja podobne obowiazki
   /* int n;
        System.out.println("Podaj którą figure chcesz policzyc: ");
            n = input.InputInt();

        Budynek bd = new Budynek("Filcharmonia",2024,13);
        Budynek ba = new Budynek("Szkoła policealna im. XXXY",1932,4);
        Budynek bc = new Budynek("Międzynarodowa smażalnia placków", 2012,43);
            bd.WysInformacje();
        System.out.print(" Wiek budynku: ");
        bd.IleLat();
            ba.WysInformacje();
        System.out.print(" Wiek budynku: ");
        ba.IleLat();
            bc.WysInformacje();
        System.out.print(" Wiek budynku: ");
            bc.IleLat();
*/
        Ssaki ss = new Ssaki();
        Ptaki pt = new Ptaki();
        Gady gd = new Gady();
        Plazy pz = new Plazy();
        Bezkregowce bz = new Bezkregowce();
        System.out.println("\nDLa człowieka");
        ss.WysInformacje();
        System.out.println("\nDla gołębia");
        pt.WysInformacje();
        System.out.println("\nDla jaszczurki");
        gd.WysInformacje();
        System.out.println("\nDla żaby trawnej");
        pz.WysInformacje();
        System.out.println("\nDla muchy domowej");
        bz.WysInformacje();
     /*       switch (n) {
        case 1:
            System.out.println("Podaj a, b, c: ");
        Prostopadloscian pr = new Prostopadloscian(input.InputDouble(), input.InputDouble(), input.InputDouble());
        System.out.println("Objętość: "+pr.ObliczObjetosc());
            break;

        case 2:
            System.out.println("Podaj r: ");
        Kolo ko = new Kolo(input.InputDouble());
        System.out.println("Obwód: "+ko.ObliczObwod() + " Pole " + ko.ObliczPole());
            break;

        case 3:
            System.out.println("Podaj a: ");
        Kwadrat kw = new Kwadrat(input.InputDouble());
        System.out.println("Obwód: "+kw.ObliczObwod() + " Pole " + kw.ObliczPole());
            break;

        case 4:
            System.out.println("Podaj a: ");
        Szescian sz = new Szescian(input.InputDouble());
        System.out.println("Objętość: "+sz.ObliczObjetosc());
            break;

        case 5:
            System.out.println("Podaj a, b: ");
        Prostokat pro = new Prostokat(input.InputDouble(), input.InputDouble());
        System.out.println("Obwód: "+pro.ObliczObwod() + " Pole " + pro.ObliczPole());
            break;

        case 6:
            System.out.println("Podaj r: ");
        Kula kl = new Kula(input.InputDouble());
        System.out.println("Objętość: "+kl.ObliczObjetosc());
            break;

        case 7:
            System.out.println("Podaj r,h: ");
        Stozek st = new Stozek(input.InputDouble(), input.InputDouble());
        System.out.println("Objętość: "+st.ObliczObjetosc());
            break;
        default:
            System.out.println("Nie ma takiego elementu");
    }
*/
    }
}