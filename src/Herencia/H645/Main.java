/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Main {
    
    private static Empresa empresa;
    private static Scanner lea;
    private static Calendar cal = Calendar.getInstance();
    
    public static void main(String args[]){
        Random r;
        
        int op;
        
        do{
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Pagar Empleado");
            System.out.println("3- Imprimir Planilla");
            System.out.println("4- Modificar datos Empleado");
            System.out.println("5- Buscar Empleado");
            System.out.println("6- Salir");
            System.out.println("\nEscoja opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    System.out.println("Codigo: ");
                    int cod = lea.nextInt();
                    pagarEmpleado(cod);
                    break;
                case 3:
                    empresa.imprimirPlanilla();
                    break;
                case 4:
                    submenu();
                    break;
                    
            }
        }while( op != 6);
        
    }

    private static void crearEmpleado() {
        System.out.print("Codigo: ");
        int cod = lea.nextInt();
        System.out.print("Nombre: ");
        String n = lea.next();
        
        System.out.println("Tipo? (PORSALARIO, PORHORA o PORCOMISION: ");
        String tipo = lea.next();
        
        TipoEmpleado te = TipoEmpleado.valueOf(tipo);
        
        if( te == TipoEmpleado.PORSALARIO ){
            System.out.print("Salario: ");
            double sal = lea.nextDouble();
            
            empresa.agregarEmpleado( new Empleado(cod,n, sal) );
        }
        else if( te == TipoEmpleado.PORHORA ){
            
            empresa.agregarEmpleado( new EmpleadoPorHora(cod, n));
        }
        else{
            System.out.print("Salario Base: ");
            double sal = lea.nextDouble();
            System.out.print("Tasa: ");
            double t = lea.nextDouble();
            
            empresa.agregarEmpleado( new EmpleadoPorVenta(cod,n,sal,t));
        }
        
            
    }

    private static void pagarEmpleado(int cod) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void submenu() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
}
