/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public final class DVD extends Item {
    public DVD(int c, String n){
        super(c,n);
    }

    @Override
    public double renta(int dias) {
        if( dias <= 3 ) {
            return 50;
        }
        return 50 + (40 * (dias - 3) );
    }
}
