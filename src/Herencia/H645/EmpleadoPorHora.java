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
    
    public EmpleadoPorHora(int c, String n){
        super(c,n);
        horasT = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " horasT=" + horasT ;
    }

    public int getHorasTrabajadas() {
        return horasT;
    }
    
    public void setHorasTrabajadas(int ht){
        horasT = ht;
    }

    @Override
    public double calcularPago() {
        int hn = 40, he = 0;
        
        if( horasT < 40 )
            hn = horasT;
        else
            he = (horasT - 40 );
        
        double phn = hn * PAGO_HORA_NORMAL;
        double phe = he * PAGO_HORA_EXTRA;
        
        return phn + phe;
    }
    
    
    
}
