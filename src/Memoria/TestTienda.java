/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class TestTienda {
    public static void main(String[] args) {
        ListItem list = new ListItem();
        
        list.agregar(new ItemNodo(1,"Pollito", 12.5));
        list.agregar(new ItemNodo(2,"Patito", 12.5));
        list.agregar(new ItemNodo(3,"Vaquita", 12.5));
        list.agregar(new ItemNodo(4,"Perrito", 12.5));
        list.agregar(new ItemNodo(5,"Monito", 12.5));
        
        list.imprimir();
        System.out.println("\nTOTAL: " + list.size());
    }
}
