public class zadanie_3 {
    public boolean czyParzysta(){
        Input input = new Input();
        System.out.println("Podaj liczbe: ");
        boolean czyParzysta = true;
            int a = input.InputInt();
                if (a%2 == 0){
                    czyParzysta = true;
                }
                else{
                    czyParzysta = false;
                }
            return czyParzysta;
    }
}
