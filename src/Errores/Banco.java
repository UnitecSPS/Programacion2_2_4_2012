/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 *
 * @author Gotcha
 */
public class Banco {
    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria();
        try{
            cb.depositar();
            cb.A();
            pollito();
        }
        catch(InputMismatchException e){
            System.out.println("ESCRIBA BIEN");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Posicion fuera de rango: "+
                    e.getMessage());
            //throw e;
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("Cerrando Banco");
    }

    private static void pollito() {
        throw new RuntimeException("DENNIS TA DORMIDO");
    }
}
