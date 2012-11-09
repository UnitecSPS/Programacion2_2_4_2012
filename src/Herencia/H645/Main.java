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
    
    private static ITrabajadorManagement empresa;
    private static Scanner lea;
    private static Calendar cal = Calendar.getInstance();
    
    public static void main(String args[]){
        empresa = new Empresa("BAC");
        lea = new Scanner(System.in);
        int op;
        
        do{
            System.out.println("1- Agregar Empleado");
            System.out.println("2- (TODO)Pagar Empleado");
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
                case 5:
                    System.out.println("Codigo: ");
                    cod = lea.nextInt();
                    if( empresa.buscarTrabajador(cod) )
                        System.out.println("SE ENCONTRO");
                    else
                        System.out.println("NO SE ENCONTRO");
                    
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
        /*
         * Aqui mandar a llamar la funcion que me
         * retorna el pagar de un empleado
         */
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void submenu() {
        /*
         * Este sub menu tiene las opciones de:
         * 1- Registrar Horas Trabajadas
         * 2- Registrar Venta
         * 3- Actualizar Fecha de Nacimiento
         * 4- Actualizar Numero de IHSS
         * 5- Actualizar Tipo Jerarquia
         * 6- Regresar Menu Principal
         * 
         * Y luego segun cada opcion se pide el codigo del
         * trabajador y su dato extra segun la opcion.
         * Una vez que se completa la accion se regresa a 
         * este sub menu. SOLO se regresa a este menu si
         * se selecciona la opcion 5.
         */
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
}
