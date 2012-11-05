/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Barco {
    protected String nombre;
    protected Date fecha;
    
    public Barco(String n){
        nombre = n;
        fecha = new Date();
    }

    @Override
    public String toString() {
        return "Barco{" + "nombre=" + nombre + ", fecha=" + fecha + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public void agregarElemento(){
        System.out.println("SOY PADRE NO HAGO NADA");
    }
    
    public double vaciarCobrar(){
        return 0;
    }
}
