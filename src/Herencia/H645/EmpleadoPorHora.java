/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class EmpleadoPorHora extends Trabajador {
    private int horasT;
    public static double PAGO_HORA_NORMAL = 50;
    public static double PAGO_HORA_EXTRA = 100;
    
    public EmpleadoPorHora(int c, String n, int ht){
        super(c,n);
        horasT = ht;
    }

    @Override
    public String toString() {
        return "EMP POR HORA";
        //return "EmpleadoPorHora{" + "horasT=" + horasT + '}';
    }

    public int getHorasTrabajadas() {
        return horasT;
    }
    
    
    
}
