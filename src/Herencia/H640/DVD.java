/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */

public class DVD extends Item{
    public double duracion;
    
    public DVD(int i, String n, int c, double d){       
        super(i,n,c);
        duracion = d;
        
    }

    public double getDuracion() {
        return duracion;
    }
   
    @Override
    public double renta(int dias){
        return 40 * dias;
    }
    
    @Override
    public String toString(){
        return super.toString() + " duracion = " + duracion;
    }

}
