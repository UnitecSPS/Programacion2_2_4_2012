/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class Lista {
    Nodo raiz = null;
    
    public boolean isEmpty(){
        return raiz == null;
    }
    
    public void agregar(Nodo obj){
        if(isEmpty())
            raiz = obj;
        else{
            Nodo viajero = raiz;
            
            while(viajero.siguiente != null){
                viajero = viajero.siguiente;
            }
            
            viajero.siguiente = obj;  
        }
    }
    
    public void imprimir(){
        if( isEmpty() ){
            System.out.println("LA LISTA ESTA VACIA");
        }
        else{
            Nodo viajero = raiz;

            while( viajero != null ){
                System.out.println(viajero);
                viajero = viajero.siguiente;
            }
        }
        
    }
    
    public void salteado(){
        try{
            Nodo viajero = raiz;
            
            while( viajero != null ){
                System.out.println(viajero);
                viajero = viajero.siguiente.siguiente;
            }
        }
        catch(Exception e){
           // System.out.println("ERRO");
        }
    }
    
    public int size(){
        Nodo viajero = raiz;
        int cont = 0;
        
        while( viajero != null ){
            cont++;
            viajero = viajero.siguiente;
        }
        
        return cont;
    }
    
    public boolean contain(Nodo obj){
        return objectOf(obj) != null;
    }

    public Nodo objectOf(Nodo obj) {
        if( obj != null ){
            Nodo v = raiz;
            
            while(v != null){
                if(v.codigo == obj.codigo &&
                   v.nombre.equals(obj.nombre) )
                    
                    return v;
                v = v.siguiente;
            }
        }
        
        return null;
    }
    
    public boolean remove(int codigo){
        if( raiz != null && raiz.codigo == codigo ){
            raiz = raiz.siguiente;
            return true;
        }
        else{
            Nodo v = raiz;
            while(v.siguiente != null){
                if( v.siguiente.codigo == codigo ){
                    v.siguiente = v.siguiente.siguiente;
                    return true;
                }
                v = v.siguiente;
            }
            return false;
        }
    }
    
    public Nodo[] toArray(){
        int longitud = size();
        Nodo array[] = new Nodo[longitud];
        Nodo v = raiz;
        
        for(int x = 0; x < longitud; x++){
            array[x] = v.clone();
            v = v.siguiente;
        }
        
        return array;
    }
    
    public void clear(){
        
    }
    
    public boolean addAfter(int afterCodigo, Nodo newNodo){
        return false;
    }
}
