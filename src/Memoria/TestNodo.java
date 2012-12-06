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
        list.agregar(new Nodo(5,"Edgward"));
        
        list.imprimir();
        System.out.println("\n-----------\n");
        list.salteado();
        System.out.println("\nTOTAL: "+list.size());
        
        Nodo buscar = new Nodo(2,"Maria");
        if( list.contain(buscar)){
            Nodo found = list.objectOf(buscar);
            found.nombre = "Maria Petronila";
            System.out.println("\n");
            list.imprimir();
        }
        else
            System.out.println("No se encuentra NODO");
        
        if( list.remove(1))
            System.out.println("Se borro 1");
        if( list.remove(3))
            System.out.println("Se borro 3");
        if( list.remove(5))
            System.out.println("Se borro 5");
        if( !list.remove(1))
            System.out.println("NO ESTA EL 1 YA!");
        System.out.println("\n");
        list.imprimir();
        
        System.out.println("\n");
        Nodo array[] = list.toArray();
        for(Nodo nd : array){
            System.out.println("Nodo: " + nd);
            nd.nombre = nd.nombre + " HACKED!";
        }
        
        list.imprimir();
    }
}
