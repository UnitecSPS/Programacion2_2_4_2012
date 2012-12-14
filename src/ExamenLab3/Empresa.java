/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab3;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Empresa {
    static ListaEmpleados lista;
    static Scanner lea;
    
    public static void main(String[] args) {
        lista = new ListaEmpleados();
        lea = new Scanner(System.in);
        
        int op = 0;
        
        do{
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Despedir Empleado");
            System.out.println("3- Listar Antes De");
            System.out.println("4- Pagar a Empleado");
            System.out.println("5- Listar Todo");
            System.out.println("6- Salir");
            System.out.print("\nEscooja Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        agregarEmpleado();
                        break;
                    case 2:
                        despedir();
                        break;
                    case 3:
                        listarAntes();
                        break;
                    case 4:
                        pagar();
                        break;
                    case 5:
                        lista.listar();
                        break;
                }
            }
            catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
            
            
        }while( op != 6);
    }

    private static void agregarEmpleado()throws IOException{
        System.out.print("Codigo: ");
        int cod = lea.nextInt();
        System.out.print("Nombre: ");
        String n = lea.next();
        System.out.print("Salario: ");
        double sal = lea.nextDouble();
        
        if( lista.agregar(cod, n, sal) )
            System.out.println("SE AGREGO EXITOSAMENTE");
        else
            System.out.println("NO SE PUDO AGREGAR, QUIZA COD REPETIDO");
    }

    private static void despedir() throws IOException {
        System.out.print("Codigo a Despedir: ");
        int cod = lea.nextInt();
        
        if( lista.despedir(cod) ){
            System.out.println("SE DESPIDIO EXITOSAMENTE");
        }
        else{
            System.out.println("NO SE ENCUENTRA EMPLEADO");
        }
    }

    private static void listarAntes()throws IOException {
        System.out.print("Codigo: ");
        int cod = lea.nextInt();
        
        lista.antesDe(cod);
        System.out.println("\n");
    }

    private static void pagar()throws IOException {
        System.out.print("Codigo: ");
        int cod = lea.nextInt();
        
        double sal = lista.pagar(cod);
        
        if( sal > 0 )
            System.out.println("Pagar L. " + sal);
        else
            System.out.println("NO SE ENCUENTRA EMPLEADO");
    }
}
