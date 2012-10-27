/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class EmpleadoPorVenta extends Empleado{
    private double ventas;
    private double tasa;

    public EmpleadoPorVenta(int c, String n, double sal, double tasa) {
        super(c, n, sal);
        this.ventas = 0;
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }

    public double getVentas() {
        return ventas;
    }
    
    public void setVentas(double v){
        ventas = v;
    }

    @Override
    public double calcularPago() {
        double sal = super.calcularPago();
        return sal + (ventas * tasa);
    }

    @Override
    public String toString() {
        return super.toString() + " Ventas= " + ventas;
    }
    
    
    
    
}
