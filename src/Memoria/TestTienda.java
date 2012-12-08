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
        
        ItemNodo buscar = new ItemNodo(1,"Pollito",0);
        if( list.contain(buscar)){
            System.out.println("Lo encontramos!");
            ItemNodo found = list.objectOf(buscar);
            System.out.println(found);
            found.precio = 99.99;
            
        }
        System.out.println("\n");
        list.imprimir();
        
        if(list.remove(1))
            System.out.println("Me vole la raiz");
        if(list.remove(3))
            System.out.println("Me vole la vaquita");
        if(list.remove(5))
            System.out.println("Me vole la cola");
        if(!list.remove(1))
            System.out.println("Ya existe el 1");
        System.out.println("\nSIZE: " + list.size());
        list.imprimir();
        
        list.addAfter(2, new ItemNodo(6,"Caballito",1000));
        list.addAfter(6, new ItemNodo(7,"Cabrita",78.9));
        list.addAfter(4, new ItemNodo(8, "Conejito", 124.3));
        System.out.println("\n");
        list.imprimir();
        
        try{
            list.report("items.doc");
        }catch(Exception e){}
        
        System.out.println("\nPRECIO: " + list.costoTotal());
        
        list.clear();
        System.out.println("\nSize: " + list.size());
    }
}
