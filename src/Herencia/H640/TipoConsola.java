/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public enum TipoConsola {
    PS3(60), XBOX(60), WII(45), PSP(40), PSVITA(45);
    int precio;

    private TipoConsola(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
