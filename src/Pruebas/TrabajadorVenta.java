/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class TrabajadorVenta extends Trabajador{
    private double ventas;
    public static final double tasa = 0.1;
    
    public TrabajadorVenta(int c, String n){
        super(c,n);
        ventas = 0;
    }

    @Override
    public double pagar() {
        return ventas * tasa;
    }
}
