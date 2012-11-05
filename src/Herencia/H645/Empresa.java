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
    private ArrayList<Trabajador> empleados;
    private String nombre;
    
    public Empresa(String n){
        nombre = n;
        empleados = new ArrayList<Trabajador>();
    }
    
    public void agregarEmpleado(Trabajador t){
        empleados.add(t);
    }
    
    public void imprimirPlanilla(){
        System.out.println("LISTA EMPLEADOS\n-----------");
        
        for(Trabajador tra : empleados){
            System.out.println(tra);
        }
    }
    
    public boolean buscar(int cod){
        return empleados.contains(cod);
    }
}
