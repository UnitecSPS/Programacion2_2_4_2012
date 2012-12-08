/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

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
            Nodo nclone = v.clone();
            nclone.siguiente = null;
            array[x] = v.clone();
            v = v.siguiente;
        }
        
        return array;
    }
    
    public void clear(){
         raiz = null;
    }
    
    public boolean addAfter(int afterCodigo, Nodo nuevo){
        Nodo ayu = raiz;
        
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
    
    public void export(String binaryPath)throws IOException{
        RandomAccessFile rNodos = new RandomAccessFile(binaryPath, "rw");
        rNodos.seek(rNodos.length());
        
        Nodo v = raiz;
        
        while( v != null ){
            rNodos.writeInt(v.codigo);
            rNodos.writeUTF(v.nombre);
            v = v.siguiente;
        }
        rNodos.close();
    }
    
    public void report(String txtPath)throws IOException{
        FileWriter fw = new FileWriter(txtPath);
        fw.write("Listado de Nodos\n---------------\n");
        
        Nodo ayu = raiz;
        
        while(ayu != null){
            String dato = ayu.codigo + "- " + ayu.nombre + "\n";
            fw.write(dato);
            ayu = ayu.siguiente;
        }
        fw.close();
    }
    
    public void addBatch(Nodo nodos[]){
        for(Nodo n : nodos){
            agregar(n);
        }
    }
    
    public void reloadFrom(String binaryPath){
       /*
        * 1- SE GUARDA UN BACKUP DE LOS NODOS EN UN
        *    ARREGLO.
        * 2- LIMPIO COMPLETAMENTE LA LISTA
        * 3- COMIENZO A LEER DEL ARCHIVO BINARIO Y POR
        *   CADA REGISTRO DE NODO EN EL, FORMO UN NUEVO
        *   NODO Y LO AGREGO A MI LISTA.
        * 4- SI ALGUNA EXCEPCION LLEGA A SUCEDER
        *    LIMPIO LA LISTA POR SI ACASO Y APLICO EL 
        *    BACKUP PARA QUE LA LISTA QUEDE COMO ANTES 
        */
        Nodo backup[] = toArray();
        
        try{
            RandomAccessFile rNodos = new RandomAccessFile(binaryPath,"r");
            clear();
            
            while(rNodos.getFilePointer() < rNodos.length() ){
                agregar(new Nodo(rNodos.readInt(), rNodos.readUTF()));
            }
        }catch(Exception e){
            clear();
            addBatch(backup);
        }
    }
    
    public Lista subList(int fromCodigo){
        Nodo v = raiz;
        Lista nueva = new Lista();
        boolean agregar = false;
        
        while(v != null){
            if( v.codigo == fromCodigo )
                agregar = true;
            
            if(agregar){
                nueva.agregar(v.clone());
            }
            
            v = v.siguiente;
        }
        
        return nueva;
    }
}
