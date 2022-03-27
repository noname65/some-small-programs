/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Variables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        DecimalFormat twoDForm = new DecimalFormat("#.00");
        System.out.println("Welcome to the mass calculator, what is your name?\n");
        String a = in.nextLine();
        System.out.println("\nHi "+a+"! How old are you?\n");
        int b = in.nextInt();
        System.out.println("\nMy, you're getting younger and younger! You sure are looking good for your age! \nWould you be so kind as to tell me your weight? (on Earth please!)\n");
        double c;
        c = in.nextDouble();
        System.out.println("\nLet me do a bit of analysis...\n");
        double d = c*0.16;
        double e = c*0.37;
        double f = c*2.364;
        System.out.println("All done! Here are the results:\nEarth:"+twoDForm.format(c)+"\nThe Moon:"+twoDForm.format(d)+"\nMars:"+twoDForm.format(e)+"\nJupiter:"+twoDForm.format(f)+"\n\nPhew! That was a work-out! Please come back again sometime!");
    }
    
}
