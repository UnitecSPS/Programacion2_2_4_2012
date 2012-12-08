/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class Nodo implements Cloneable{
    public int codigo;
    public String nombre;
    public Nodo siguiente;
    
    public Nodo(int c, String n){
        codigo = c;
        nombre = n;
        siguiente = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    @Override
    public Nodo clone(){
        try{
            Nodo nclone = (Nodo)super.clone();
            nclone.siguiente = null;
            return nclone;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    
    
}
