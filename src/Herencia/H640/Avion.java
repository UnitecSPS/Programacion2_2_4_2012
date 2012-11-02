/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class Avion extends Aereo{

    @Override
    public String tipo() {
        return "BOEING";
    }

    @Override
    public void movete() {
        System.out.println("Me muevo por encima de las nubes");
    }
}
