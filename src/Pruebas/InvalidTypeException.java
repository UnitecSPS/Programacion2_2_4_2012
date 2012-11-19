/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class InvalidTypeException extends RuntimeException  {
    public InvalidTypeException(){
        super("Clase no valida.");
    }
}
