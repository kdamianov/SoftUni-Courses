package lab.mathOperation;

public class MathOperation {

    private MathOperation(){  //Не е ОК да може да е достъпен от външен свят!!!

    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int add(int a, int b, int c){
        return add(add(a, b), c);
    }

    public static int add(int a, int b, int c, int d){
        return add(add(a, b, c), d);
    }

}
