/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Item {
    protected int id;
    protected String titulo;
    protected Date fecha;
    protected int copiasRenta;
    protected int copiasVenta;

    public Item(int i, String t, int cr){
        id = i;
        titulo = t;
        copiasRenta = cr;
        fecha = new Date();
        copiasVenta = 0;
    }
    
    public void setCopiasRenta(int copiasRenta) {
        this.copiasRenta = copiasRenta;
    }

    public void setCopiasVenta(int copiasVenta) {
        this.copiasVenta = copiasVenta;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCopiasRenta() {
        return copiasRenta;
    }

    public int getCopiasVenta() {
        return copiasVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    
    
}