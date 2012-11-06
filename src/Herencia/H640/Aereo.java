/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public abstract class Aereo extends MedioTransporte{
    public Aereo(){
        super("aereo");
    }
    
    @Override
    public String tipoGasolina(){
        return "NAPALM";
    }
    
    public abstract String tipo();
}
