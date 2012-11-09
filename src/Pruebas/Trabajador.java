/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public abstract class Trabajador {
    protected int codigo;
    protected String nombre;
    
    public Trabajador(int c, String n){
        codigo = c;
        nombre = n;
    }
    
    public final int getCodigo(){
        return codigo;
    }
    
    public final String getNombre(){
        return nombre;
    }
    
    public abstract double pagar();
}
