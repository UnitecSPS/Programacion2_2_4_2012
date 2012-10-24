/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Empresa {
    public static void main(String args[]){
        ArrayList<Trabajador> emps = new ArrayList<Trabajador>();
        emps.add(new Trabajador(1,"Carlos"));
        emps.add(new Empleado(2,"Edgardo",7000));
        emps.add(new EmpleadoPorHora(3,"Edwin",80));
        
        for(Trabajador t : emps){
            System.out.println(t);
        }
                
    }
}
