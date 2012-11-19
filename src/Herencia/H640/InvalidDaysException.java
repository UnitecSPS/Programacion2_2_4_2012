/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class InvalidDaysException extends Exception{
    public InvalidDaysException(int d){
        super(d + " son dias incorrectos.");
    }
}
