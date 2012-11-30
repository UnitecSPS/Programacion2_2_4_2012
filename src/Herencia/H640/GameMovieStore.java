/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class GameMovieStore {
    static IManagementItems store;
    static Scanner lea;
    
    public static void main(String[] args) {
        store = new VideoStarsBinario();
        lea = new Scanner(System.in);
        int op = 0;
        
        do{
            System.out.println("1- Agregar Item");
            System.out.println("2- Rentar");
            System.out.println("3- Imprimir");
            System.out.println("4- Buscar Item");
            System.out.println("5- Cambiar Estado");
            System.out.println("6- Salir");
            System.out.print("Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch( op ){
                    case 1:
                        System.out.print("Tipo? DVD o GAME ");
                        TipoItem ite = TipoItem.valueOf(lea.next().toUpperCase());
                        store.agregarItem(ite);
                        break;
                    case 2:
                        rentarUnItem();
                        break;
                    case 3:
                        store.imprimir();
                        break;

                }
                
            }catch(InputMismatchException e){
                lea.next();
                System.out.println("Escriba bien el dato entero");
            }
            catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }while( op != 6);
        
    }

    private static void rentarUnItem()throws InvalidDaysException {
        System.out.print("Codigo: ");
        int cod = lea.nextInt();
        System.out.print("Dias: ");
        int dias = lea.nextInt();
        
        double t = store.rentar(cod, dias);
        
        System.out.println("Pagar: " + t);
    }
}
