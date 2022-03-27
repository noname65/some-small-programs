package mathtest;
/**
 * @author noname
 */
public class Mathtest {
    public static void main(String[] args) {
        double S=0,i=1;
        for(;;){
            S+=Math.pow(i, 2);
            i+=1;
            if(i<=4)continue;
            System.out.println(S);
            break;
        }
    }
}
