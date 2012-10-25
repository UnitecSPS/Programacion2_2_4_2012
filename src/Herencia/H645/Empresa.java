/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
            //t.calcularPago();
            Object te = new Empresa();
            
            System.out.println("Test: " + 
                    ((Empresa)te));
            
            if( t instanceof Empleado ){
                System.out.println("Salario: " +
                        ((Empleado)t).getSalario() );
            }
            else if( t instanceof EmpleadoPorHora){
                System.out.println("Horas Trabajadas: " +
                        ((EmpleadoPorHora)t).getHorasTrabajadas());
            }
            else{
                System.out.println("SOY TRABAJADOR");
            }
        }
        
        //downcasting
        Trabajador it = new Empleado(4,"Juan Carlos",8000);
        //upcasting indirecto
        Empleado em = (Empleado)it;
        System.out.println("Salario: " + em.getSalario());
        //upcasting directo
        System.out.println("Salario: " + ((Empleado)it).getSalario());
        
    }
}
