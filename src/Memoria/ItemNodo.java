/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class ItemNodo {
    public int codigo;
    public String titulo;
    public double precio;
    public ItemNodo siguiente;

    public ItemNodo(int codigo, String titulo, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
        siguiente = null;
    }

    @Override
    public String toString() {
        return "ItemNodo{" + "codigo=" + codigo + ", titulo=" + titulo + ", precio=" + precio + '}';
    }
 
    
}
