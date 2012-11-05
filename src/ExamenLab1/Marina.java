/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Marina {
    
    private static ArrayList<Barco> barcos;
    private static Scanner lea;
    
    public static void main(String[] args) {
        barcos = new ArrayList<Barco>();
        lea = new Scanner(System.in);
        
        int op;
        
        do{
            System.out.println("1- Agregar Barco");
            System.out.println("2- Agregar Elemento a Barco");
            System.out.println("3- Vaciar un Barco");
            System.out.println("4- Listar los Pasajeros");
            System.out.println("5- Listar Barcos");
            System.out.println("6- Salir");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    System.out.print("Tipo? Pesquero (0) Pasajero (1): ");
                    int tipo = lea.nextInt();
                    System.out.print("Nombre?: ");
                    String nombre = lea.next();
                    
                    agregarBarco(tipo,nombre);
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    nombre = lea.next();
                    agregarElemento( nombre );
                    break;
                case 3:
                    System.out.print("Nombre: ");
                    nombre = lea.next();
                    double tot = vaciarBarco(nombre);
                    System.out.println("TOTAL: " + tot);
                    break;
                case 4:
                    listarPasajeros();
                    break;
                case 5:
                    listarBarcos(0);
                    
            }
        }while( op != 6 );
        
        
    }

    private static Barco buscarBarco(String nombre) {
        for(Barco b : barcos){
            if( b.getNombre().equals(nombre) ) {
                return b;
            }
        }
        return null;
    }
        
    private static void agregarBarco(int tipo, String nombre) {
        Barco barc = buscarBarco(nombre);
        
        if( barc == null ){
            if( tipo == 0 ){
                barcos.add( new BarcoPesquero(nombre) );
            }
            else{
                System.out.print("Precio x boleto: ");
                double prec = lea.nextDouble();
                System.out.print("Capacidad Maxima: ");
                int max = lea.nextInt();
                
                barcos.add( new BarcoPasajero(nombre, prec, max));
            }
        }
    }

    private static void agregarElemento(String nombre) {
        Barco barco = buscarBarco(nombre);
        
        if( barco != null ) {
            barco.agregarElemento();
        }
    }

    private static double vaciarBarco(String nombre) {
        return vaciarBarco(nombre, 0);
    }

    private static double vaciarBarco(String nombre, int pos) {
        if( pos < barcos.size() ){
            if( barcos.get(pos).getNombre().equals(nombre) ){
                System.out.println(barcos.get(pos));
                return barcos.get(pos).vaciarCobrar();
            }
            return vaciarBarco(nombre, pos + 1);
        }
        
        System.out.println("No existe barco!");
        return 0;
    }

    private static void listarPasajeros() {
        for(Barco barco : barcos){
            if( barco instanceof BarcoPasajero){
                ((BarcoPasajero)barco).listarPasajeros();
            }
        }
    }

    private static void listarBarcos(int pos) {
        if( pos < barcos.size() ){
            System.out.println(barcos.get(pos));
            listarBarcos(pos + 1);
        }
    }
}
