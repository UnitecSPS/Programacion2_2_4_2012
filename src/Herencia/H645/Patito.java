/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class Patito extends Animal{
    public Patito(){
        super(2,false);
    }

    @Override
    public void hablar() {
        System.out.println("CUAC CUAC CUAC");
    }
    
    
}
