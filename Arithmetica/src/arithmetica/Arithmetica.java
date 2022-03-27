package arithmetica;
public class Arithmetica {
    public static void main(String[] args) {
        System.out.println(square(5));
        System.out.println(quadruple(5));
        System.out.println(divisionWithR(10,4));
        System.out.println(stofeetandinches(254));
    }
    private static double square(double a){
        return a*a;
    }
    private static double quadruple(double a){
        return a*4;
    }
    private static String divisionWithR(int a,int b){
        return a/b+" R"+a%b;
    }
    private static String stofeetandinches(double a){
        return a/31.75+"ft "+a/63.5+"in";
    }
}
