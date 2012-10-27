/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */

public class DVD extends Item{
    private double duracion;
    private TipoEstadoDVD estado;
    private TipoPelicula tipo;
    
    public DVD(int i, String n, int c, double d){       
        super(i,n,c);
        duracion = d;
        estado = TipoEstadoDVD.ESTRENO;
        tipo = TipoPelicula.INDEFINIDA;
    }

    public void setEstado(TipoEstadoDVD estado) {
        this.estado = estado;
    }

    public void setTipo(TipoPelicula tipo) {
        this.tipo = tipo;
    }

    public TipoEstadoDVD getEstado() {
        return estado;
    }

    public TipoPelicula getTipo() {
        return tipo;
    }

    public double getDuracion() {
        return duracion;
    }
   
    @Override
    public double renta(int dias){
        double renta = 50;
        
        if( dias > estado.getMaxDias() ){
            renta += 40 * (dias - estado.getMaxDias());
        }
        
        return renta;
    }
    
    @Override
    public String toString(){
        return super.toString() + " duracion = " + duracion;
    }

}
