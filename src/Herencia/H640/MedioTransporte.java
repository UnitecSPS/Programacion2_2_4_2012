/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public abstract class MedioTransporte {
    protected String medio;
    
    public MedioTransporte(String m){
        medio = m;
    }
    
    public String getMedio(){
        return medio;
    }
    
    public abstract void movete();
    public abstract String tipoGasolina();
}
