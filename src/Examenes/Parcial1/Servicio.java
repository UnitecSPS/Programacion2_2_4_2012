/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Parcial1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Servicio {
    protected int codigo;
    protected String nombre;
    protected Date fecha;
    protected double monto;

    public Servicio(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMontoMensual() {
        return monto;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Servicio{" + "codigo=" + codigo + ", nombre=" + nombre + ", fecha=" + fecha + ", monto=" + monto + '}';
    }
    
}
