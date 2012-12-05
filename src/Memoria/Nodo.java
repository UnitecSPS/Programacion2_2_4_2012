/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class Nodo {
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
    
    
}
