/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public abstract class Item {
    protected int cod;
    protected String nom;
    public static final int VERSION_ITEM = 45;
    
    public Item(int cod, String nom) {
        this.cod = cod;
        this.nom = nom;
    }

    public final int getCod() {
        return cod;
    }

    public final String getNom() {
        return nom;
    }
    
    public abstract double renta(int dias);
    
}
