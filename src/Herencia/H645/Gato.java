/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class Gato extends Animal{
    public Gato(){
        super(4,true);
    }

    @Override
    public void hablar() {
        System.out.println("MIAU MIAU MIAU");
    }
    
    
}
