/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
        
public abstract class Trabajador {
    protected int codigo;
    protected String nombre;
    protected int ihss;
    protected Date fechanac;
    protected Date fechainic;
    protected TipoJerarquia tipo;
    
    public Trabajador(int c,String n){
        codigo = c;
        nombre = n;
        fechainic = new Date();
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public void setIhss(int ihss) {
        this.ihss = ihss;
    }

    public void setTipo(TipoJerarquia tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getFechainic() {
        return fechainic;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public int getIhss() {
        return ihss;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoJerarquia getTipo() {
        return tipo;
    }
    
    public abstract double calcularPago();

    @Override
    public String toString() {
        return "Trabajador{" + "codigo=" + codigo + ", nombre=" + nombre + ", ihss=" + ihss + ", fechanac=" + fechanac + ", fechainic=" + fechainic + ", tipo=" + tipo + '}';
    }

    @Override
    public boolean equals(Object trabajador){
        if( trabajador instanceof Trabajador){
            return ((Trabajador)trabajador).getCodigo() == codigo;
        }
        else if( trabajador instanceof Integer ){
            return ((Integer)trabajador) == codigo;
        }
        
        return false;
    }
    
}
