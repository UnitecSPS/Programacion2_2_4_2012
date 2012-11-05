/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public final class Perro extends Animal {
    private int test;
    
    public Perro(){
        super(4,true);
    }

    public void moverCola(){
        System.out.println("Toy Feliz");
    }
    
    @Override
    public void hablar() {
        System.out.println("GUAU GUAU GUAU");
    }
   
}
