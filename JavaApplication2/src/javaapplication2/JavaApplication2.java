package javaapplication2;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication2 {

    public static void main(String[] args) {
        /*
            char left,right;
            String str="murder";
            for(int i=0;i<str.length()/2;i++){
            left=str.charAt(i);
            right=str.charAt(str.length()-1-i);
            System.out.println(left+"|"+right+"|"+str);
            str=str.substring(0, i)+right+str.substring(i+1);
            str=str.substring(0, str.length()-1-i)+left+str.substring(str.length()-i);
            System.out.println(left+"|"+right+"|"+str);
            }
            System.out.println(str);
            int n=-1749;
            int l=(int)(Math.log10(Math.abs(n))+1);
            int q,r;
            for(int i=l;i>0;i--){
            q=n/10;
            r=n%10;
            n=q;
            System.out.println(n+"|"+q+"|"+r);
            }
            System.out.println("\t\tgrass");
            System.out.print("grue");
            
            Scanner in = new Scanner(System.in);
            int a;
            int b;
            int c;
            System.out.print("a=");
            a=in.nextInt();
            System.out.print("b=");
            b=in.nextInt();
            System.out.println("\na="+a+"\nb="+b);
            c=a;
            a=b;
            b=c;
            System.out.println("\na="+a+"\nb="+b);
            
            Scanner in = new Scanner(System.in);
            int a,b,c;
            a=in.nextInt();
            b=in.nextInt();
            if(a>b){
            c=b;
            }else{
            c=a;
            }
            for(int i=0;i<c;i++){
            System.out.print("*");
            }
            
            for(int i=1;i<4097;i++){
            System.out.print(i);
            }
            
            int a=1;
            int b=2;
            int c=3;
            int[] d={0,0,0};
            if(a>b){
            if(b>c){
            d[0]=a;
            d[1]=b;
            d[2]=c;
            }else if(a>c){
            d[0]=a;
            d[1]=c;
            d[2]=b;
            }else{
            d[0]=c;
            d[1]=a;
            d[2]=b;
            }
            }else{
            if(a>c){
            d[0]=b;
            d[1]=a;
            d[2]=c;
            }else if(b>c){
            d[0]=b;
            d[1]=c;
            d[2]=a;
            }else{
            d[0]=c;
            d[1]=b;
            d[2]=a;
            }
            }
            
            java.util.Scanner s=new java.util.Scanner(System.in);
            int[] a=new int[9999];
            String b;
            int i;
            char c;
            for(i=0;i<9999;i++){
            System.out.println("Please enter an integer");
            b=s.nextLine();
            if("done".equals(b.trim().toLowerCase())){
            break;
            }else{
            a[i]=Integer.parseInt(b);
            }
            }
            for(int e=0;e<i;e++){
            c='\u0000';
            if(a[e]%2==0){
            c+=a[e];
            System.out.print(c);
            }
            }
            
            char a='\u0021',b='\u0022';
            a+=b;
            System.out.println(a);
            String c=String.valueOf(new char[]{'\u0048','\u0049','\u0050','\u0051','\u0052','\u0053','\u0054'});
            System.out.println(c);
            
        try {
            File asd=new File(System.getProperty("user.home")+"/desktop/Save1.csv");
            asd.createNewFile();
            PrintWriter x = new PrintWriter(asd);
            x.println(new String[][][]{{{"9","7","4"},{"1","2","3"}},{{"2","5","9"},{"7","1","8"}}});
            x.close();
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String c="";
        while(!"exit".equals(c)){
            System.out.println("1.求两直线交点\n2.一般式转斜截式");
            c=new java.util.Scanner(System.in).nextLine();
            if("1".equals(c)){
                while(true){
                    if("exit".equals(new java.util.Scanner(System.in).nextLine())){
                        break;
                    }else{
                        a();
                    }
                }
            }else if("2".equals(c)){
                while(true){
                    if("exit".equals(new java.util.Scanner(System.in).nextLine())){
                        break;
                    }else{
                        b();
                    }
                }
            }
        }
    }
    private static void a(){
        int a1,a2,b1,b2,c1,c2;
        java.util.Scanner s=new java.util.Scanner(System.in);
        System.out.print("a1=");
        a1=s.nextInt();
        System.out.print("b1=");
        b1=s.nextInt();
        System.out.print("c1=");
        c1=s.nextInt();
        System.out.print("a2=");
        a2=s.nextInt();
        System.out.print("b2=");
        b2=s.nextInt();
        System.out.print("c2=");
        c2=s.nextInt();
        System.out.println("x="+((b1*c2-b2*c1)/(a1*b2-a2*b1))+"\ny="+((-1)*a1*((b1*c2-b2*c1)/(a1*b2-a2*b1))-c1)/b1);
    }
    private static void b(){
        double a,b,c;
        java.util.Scanner s=new java.util.Scanner(System.in);
        System.out.print("a=");
        a=s.nextDouble();
        System.out.print("b=");
        b=s.nextDouble();
        System.out.print("c=");
        c=s.nextDouble();
        System.out.println("y="+new java.text.DecimalFormat("#.00").format(-1*a/b)+"x"+((c*(-1)/b)>=0?"+":"-")+new java.text.DecimalFormat("#.00").format(c*(-1)/b));
        */
        System.out.println(Math.pow(3, 2));
    }
}
