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
public class BarcoPasajero extends Barco {
    private ArrayList<String> pasajeros;
    private double precio_ticket;
    private int capacidad_maxima;
    
    public BarcoPasajero(String n, double pt, int cm){
        super(n);
        precio_ticket = pt;
        capacidad_maxima = cm;
        pasajeros = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return super.toString() +
                " BarcoPasajero{" + "pasajeros=" + pasajeros.size() + '}';
    }

    @Override
    public void agregarElemento() {
        Scanner lea = new Scanner(System.in);
        
        if( pasajeros.size() < capacidad_maxima ){
            System.out.print("Nombre: ");
            String n = lea.next();
            
            pasajeros.add( n );
        }
    }

    @Override
    public double vaciarCobrar() {
        double tot = pasajeros.size() * precio_ticket;
        pasajeros.clear();
        return tot;
    }
    
    public void listarPasajeros(){
        System.out.println("PASAJEROS EN " + nombre);
        int cont = 0;
        
        for(String p : pasajeros){
            System.out.printf("%d- %s\n",cont++, p);
        }
    }
    
    
    
}
