/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria {
    private int numChequera;
    
    public CuentaCheques(int c,String n,int nc){
        super(c,n);
        numChequera = nc;
    }
    
    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Num Chequera: " + numChequera);
    }
}
