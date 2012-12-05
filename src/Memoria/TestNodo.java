/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class TestNodo {
    public static void main(String[] args) {
        Lista list = new Lista();
        
        list.agregar(new Nodo(1,"Carlos"));
        list.agregar(new Nodo(2, "Maria"));  
        list.agregar(new Nodo(3,"Kehimer"));
        list.agregar(new Nodo(4,"JC"));
        list.agregar(new Nodo(4,"Edgward"));
        
        list.imprimir();
        System.out.println("\n-----------\n");
        list.salteado();
        System.out.println("\nTOTAL: "+list.size());
    }
}
