/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab3;

/**
 *
 * @author Gotcha
 */
public class Nodo {
    public int cod;
    public String nomb;
    public long bytes;
    public Nodo siguiente = null;
    public Nodo anterior = null;
    
    public Nodo(int c, String n, long b){
        cod = c;
        nomb = n;
        bytes = b;
    }
}
