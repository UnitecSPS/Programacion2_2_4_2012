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
public class Tienda {
    public static void main(String[] args) {
        
        int x = 5;
        int y = x;
        y = 10;
        System.out.println(x + " - " + y);
        
        ItemNodo a = new ItemNodo(1,"Harry Potter", 12);
        ItemNodo b = a;
        
        b.titulo = "TITANIC";
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        
        Scanner lea = new Scanner(System.in);
        String cx= "hola";
        String cy= "hola";
        
        if( cx == cy )
            System.out.println("SON LO MISMO");
    }
}
