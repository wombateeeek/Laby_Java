public class zadanie_2 {
    public String funkcje(){
        Input input = new Input(); //odwolanie do klasy input
        System.out.println("Dla funkcji a(x), b(x) oraz c(x) podaj x by wyznaczyć wartość funkcji");
        int a = input.InputInt();
        int b = input.InputInt();
        int c = input.InputInt();
        double wynikA, wynikB, wynikC;
        if(a > 0){
            wynikA = 2*a;
        } else if (a == 0) {
            wynikA = 0;
        }
        else{
            wynikA = (-3)*a;
        }
        if(b >= 1){
            wynikB = Math.pow(b,2);
        }
        else{
            wynikB = b;
        }
        if(c > 2){
            wynikC = 2+c;
        }
        else if(c ==2 ){
            wynikC = 8;
        }
        else{
            wynikC = c - 4;
        }
        return "Wartość a(x) "+wynikA +" Wartość b(x)"+ wynikB +" Wartość c(x)" + wynikC;
    }
}
