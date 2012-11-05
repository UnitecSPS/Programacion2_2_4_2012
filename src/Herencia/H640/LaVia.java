/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class LaVia {
    public static void main(String[] args) {
        ArrayList<MedioTransporte> medios = new ArrayList<MedioTransporte>();
        medios.add(new Carro());
        medios.add(new Barco());
        medios.add(new Avion());
        
        for(MedioTransporte m : medios){
            m.movete();
            System.out.println("Gasolina: " + m.tipoGasolina());
            System.out.println("Medio: " + m.getMedio());
            
        }
                
    }
}
