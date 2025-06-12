public class zadanie_4 {
    public boolean czyPodzelne(){
        Input input = new Input();
        System.out.println("Wprowadz liczbę: ");
            int a = input.InputInt();
            boolean czyPodzielne = true;
            if(a%3 == 0 && a%5 == 0){
                return czyPodzielne;
            }
            else{
                return czyPodzielne = false;
            }
    }
}
