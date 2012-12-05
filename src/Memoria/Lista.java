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
}
