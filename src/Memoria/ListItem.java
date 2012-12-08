/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gotcha
 */
public class ListItem {
    private ItemNodo raiz = null;
    
    public boolean isEmpty(){
        return raiz == null;
    }
    
    public void agregar(ItemNodo in){
        if( isEmpty() ){
            raiz = in;
        }
        else{
            ItemNodo ayudante = raiz;
            while(ayudante.siguiente != null){
                ayudante = ayudante.siguiente;
            }
            
            ayudante.siguiente = in;    
        }
    }
    
    public void imprimir(){
        ItemNodo ayudante = raiz;
        
        while(ayudante != null ){
            System.out.println(ayudante);
            ayudante = ayudante.siguiente;
        }
    }
    
    public int size(){
        ItemNodo ayudante = raiz;
        int count = 0;
        
        while(ayudante != null ){
            count++;
            ayudante = ayudante.siguiente;
        }  
        
        return count;
    }
    
    public boolean contain(ItemNodo obj){
        return objectOf(obj) != null;
    }

    public ItemNodo objectOf(ItemNodo obj) {
        ItemNodo ayu = raiz;
        
        while( ayu != null ){
            if(ayu.codigo == obj.codigo &&
                    ayu.titulo.equals(obj.titulo))
                return ayu.clone();
            ayu = ayu.siguiente;
        }
        
        return null;
    }
    
    public boolean remove(int codigo){
         if( raiz != null ){
             if( raiz.codigo == codigo ){
                 raiz = raiz.siguiente;
                 return true;
             }
             else{
                 ItemNodo ayu = raiz;
                 
                 while(ayu.siguiente != null){
                     if(ayu.siguiente.codigo == codigo){
                         ayu.siguiente = ayu.siguiente.siguiente;
                         return true;
                     }
                     ayu = ayu.siguiente;
                 }
             }
         }
         return false;
    }
    
    public boolean addAfter(int afterCodigo, ItemNodo nuevo){
        ItemNodo ayu = raiz;
        
        while(ayu != null){
            if(ayu.codigo == afterCodigo){
                nuevo.siguiente = ayu.siguiente;
                ayu.siguiente = nuevo;
                return true;
            }
            ayu = ayu.siguiente;
        }
        return false;
    }
    
    public double costoTotal(){
        ItemNodo ayu = raiz;
        double tot = 0;
        
        while(ayu != null){
            tot += ayu.precio;
            ayu = ayu.siguiente;
        }
        
        return tot;
    }
    
    public void report(String txtPath)throws IOException{
        FileWriter fw = new FileWriter(txtPath);
        fw.write("Listado de Items\n---------------\n");
        
        ItemNodo ayu = raiz;
        
        while(ayu != null){
            String dato = ayu.codigo + "- " + ayu.titulo + " L." +
                    ayu.precio + "\n";
            fw.write(dato);
            ayu = ayu.siguiente;
        }
        fw.close();
    }
    
    public void clear(){
        raiz = null;
    }
}
