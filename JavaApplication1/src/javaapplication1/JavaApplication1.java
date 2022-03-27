/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class JavaApplication1 {
    public static void main(String[] args) {
        new JavaApplication1();
    }
    /**
     * @param args the command line arguments
     */
    public JavaApplication1() {
        // TODO code application logic here
        /*
        int a = 1;
        System.out.println(a);
        a += 1;
        
        System.out.print("The\f ");
        System.out.print("Gree\n\\n");
        System.out.println("\t\tgrass");
        System.out.print("grue");
        
        Scanner s = new Scanner(System.in);
        int ab = s.nextInt();
        String throw_away = s.nextLine(); //if you don’t know why this line is here ignore it
        int b = s.nextInt();
        
        System.out.println(ab + b);
        String n = Integer.toString(b);
        System.out.println(n + ab);
        System.out.println(n + b);
        
        String i = "start";
        for(int x=0; x<11; x++){
        for(int y=0; y<11; y++){
        i += "(" + x + "," + y + ")";
        System.out.println("(" + x + "," + y + ")");
}
}
        System.out.println(i);
        
        for(int i=0; i<3; i++){
     for(int j=0; j<2; j++){
          System.out.println("j");
}
System.out.println("\n");
}
        
        int a=-20;
        int b=3;
        int i=a-(((a-(a%b))/b-1)*b);
        System.out.println(i);
        
        double a = 1.23456;
        System.out.println(a);
        //1.00 *= a;
        System.out.println(a);
        double x = 1.23456;
        double b = x;
        double c = 0;
        if(x>=0){
        for(int i = 0; i < 9999; i++){b--;c++;
        if(b<0){c--;break;}
        }}else{
        for(int i = 0; i < 9999; i++){b++;c--;
        if(b>0){c++;break;}
        }}
        x-=c;
        System.out.println(x);
        
        DecimalFormat twoDForm = new DecimalFormat("#.00");
        double amount =1.23456;
        System.out.println(twoDForm.format(amount)); 
         */
        //for(int i=0;i<200;i++){
        //System.out.println((int)Math.ceil(Math.random()*2));}
        String asd = "Bear1169453275";
        a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        b = new int[asd.length()];
        for(int i=0;i<asd.length();i++){
            b[asd.length()-i-1]=abc(asd.substring(i, i+1));
        }
        b[4]-=1;
        long c = (long) Math.pow(a.length, asd.length());
        int d=a.length;
        timer=new Timer("asd");
        timer.start();
        for (long i = 0; i < c; i++) {
            e="";
            for(int j=b.length-1;j>=0;j--){
                e+=a[b[j]];
            }
            if(e == null ? asd == null : e.equals(asd)){
                System.out.println(e);
                break;
            }
            b[0]++;
            for(int j=0;j<b.length;j++){
                if(b[j]>=a.length){
                    b[j]-=a.length;
                    if(j+1<b.length){
                        b[j+1]++;
                    }
                }
            }
        }
        System.exit(0);
    }
    int abc(String a1){
        for(int i=0;i<a.length;i++){
            if(a1 == null ? a[i] == null : a1.equals(a[i])){
                return i;
            }
        }
        return -1;
    }
    class Timer implements Runnable {

        public volatile transient Thread t;
        public volatile transient String threadName;

        Timer(String name) {
            threadName = name;
            t = null;
        }

        public void run() {
            while (true) {
                int[] f=b;
                String s="";
                for(int j=f.length-1;j>=0;j--){
                    s+=a[f[j]];
                }
                System.out.println(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        public void start() {
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }
        }
    }
    String e;
    Timer timer;
    int[] b;
    String[] a;
}
