/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class Carro extends MedioTransporte{
    
    public Carro(){
        super("Terrestre");
    }
    
    @Override
    public void movete(){
        System.out.println("LO PRENDO CON LA LLAVE Y ME MUEVO CON LAS LLANTAS");
    }

    @Override
    public String tipoGasolina() {
        return "DIESEL";
    }
}
