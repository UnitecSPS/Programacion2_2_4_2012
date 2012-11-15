/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class NotValidValueException extends Exception {
    public NotValidValueException(Object obj){
        super("Valor " + obj + " no es valido.");
    }
}
