/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class Barco extends MedioTransporte{
    public Barco(){
        super("maritimo");
    }
    
    @Override
    public void movete(){
        //super.movete();
        System.out.println("Me muevo al compas de las olas del mar");
    }

    @Override
    public String tipoGasolina() {
        return "Carbon";
    }
}
