/**
 * Parses quad eq
 *
 * @author Ash
 * @version 20180830
 */

/*
 * 1. Prompt user for expression, store to variable
 * 2. Begin parsing user expression for a,b,c coefficients
 *    a. locate index of first x in expression
 *    b. extract substring from user expressio, from beginning-->position of first x
 *    c. convert substring to number form, store to variable
 */

//search the library or ask stackoverflow
import java.util.Scanner;

public class starter {
    static String exp;
    static double aCoeff;
    static double bCoeff;
    static double cCoeff;
    static double ans1;
    static double ans2;
    static double biM;
    static double biB;
    static double aaCoeff;
    static double bbCoeff;
    static double ccCoeff;

    public static void prompt() {
        System.out.println("Please enter your desired quadratic function");
        // 'new' means constructing new object using the scanner constructor that takes in an InputStream
        //System.in is a reference to that input stream
        Scanner in = new Scanner(System.in); 
        //goal is to take the input of the user to store it to a variable, nextline completes this
        exp = in.nextLine();    
    }

    public static void extract() {
        if ((exp.contains("x+")) || (exp.contains("x-"))){
            //FINDING A
            int xPos = exp.indexOf("x");
            String temp = exp.substring(0, xPos);
            aaCoeff = Double.parseDouble(temp);

            //FINDING B
            exp = exp.substring(xPos+3);
            xPos = exp.indexOf("x");
            temp = exp.substring(0, xPos);
            bbCoeff = Double.parseDouble(temp);

            //FINDING C
            exp = exp.substring(xPos+1);
            ccCoeff = Double.parseDouble(exp);

            System.out.println("a=" + aaCoeff);
            System.out.println("b=" + bbCoeff);
            System.out.println("c=" + ccCoeff);
            
            aCoeff = aaCoeff;
            bCoeff = bbCoeff;
            cCoeff = ccCoeff;
        }
        else{
            //FINDING M
            int biPos = exp.indexOf("x");
            String temp = exp.substring(0,biPos);
            biM = Double.parseDouble(temp);

            //FINDING B
            exp = exp.substring(biPos+3);
            biB = Double.parseDouble(exp);

            System.out.println("first=" + biM);
            System.out.println("second=" + biB);
            
            aCoeff = biM;
            bCoeff = 0;
            cCoeff = biB;
            
        }
    }

    public static void math() {
        ans1 = ((-1.*bCoeff + (Math.sqrt(Math.pow(bCoeff,2.)-4.*aCoeff*cCoeff)))/(2.*aCoeff));
        ans2 = ((-1.*bCoeff - (Math.sqrt((Math.pow(bCoeff,2.))-4.*aCoeff*cCoeff)))/(2.*aCoeff));
    }

    public static void main(String [] args) {   
        prompt();
        extract();
        math();
        System.out.println("x = " + ans1 + " and " + ans2);
    }
}
