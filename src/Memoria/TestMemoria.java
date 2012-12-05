     /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TestMemoria {
    public static void main(String[] args) {
        Nodo a = new Nodo(1,"Carlos");
        Nodo b = a;
        b.nombre = "Edward";
        
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        //b = new Nodo(1,"Edward");
        if(b.equals(a))
            System.out.println("trueee");
        
        Scanner lea = new Scanner(System.in);
        String x = "hola";
        String z = "hola";
        
        if( x == z)
            System.out.println("CADENA TRUE PAPA");
    }
}
