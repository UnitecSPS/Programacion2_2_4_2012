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
public class CuentaBancaria {
    int arr[] = {1,2,3};
    Scanner lea = new Scanner(System.in);    
    
    public void depositar(){
        int x;
        do{
            try{
                System.out.print("Ingrese valor: ");
                x = lea.nextInt();
                System.out.println("x: " + x);
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese bien");
                lea.next();
            }
        }while(true);
        
    }
    
    public void A(){
        int op;
        do{
            System.out.println("1- Depositar");
            System.out.println("2- Retirar");
            op  = lea.nextInt();
            
            switch(op){
                case 1:
                    B(lea.nextInt());
            }
        }while(op!=3);
    }
    
    public void B(int pos){
        System.out.println(arr[pos]);
    }
    
    
}
