/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class SmartPhone extends Cellphone {
    private boolean tieneInternet;
    
    public SmartPhone(int n, String no, String se, boolean ti){
        super(n, no, se);
        tieneInternet = ti;
    }
}
