/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class LaGranja {
    public static void main(String[] args) {
        
        Patito pat = new Patito();
        try{
            pat.test();
            pollito();
            pat.nadar(90);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Se ingreso mal la POS");
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        
        //--------------------
        Scanner lea = new Scanner(System.in);
        //lea.useDelimiter(System.getProperty("lineseparator"));
        int x;
        
        do{
            try{
                x = lea.nextInt();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Ingresar de Nuevo");
                lea.next();
            }
        }while(true);
       
        //----------------------
        System.out.println("Y ese fue el main");
    }

    private static void pollito() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
