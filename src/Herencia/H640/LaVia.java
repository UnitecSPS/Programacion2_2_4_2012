/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

import java.util.ArrayList;
import java.util.Calendar;

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
        java.util.Scanner lea = new java.util.Scanner(System.in);
        
        for(MedioTransporte m : medios){
            m.movete();
            System.out.println("Gasolina: " + m.tipoGasolina());
            System.out.println("Medio: " + m.getMedio());          
        }
        
        Calendar c = Calendar.getInstance();
       // Math
        //funciones bajo demanda
        MedioTransporte mt = new MedioTransporte("Desconocido") {

            @Override
            public void movete() {
                System.out.println("Movete MT");
                nueva();
            }
            
            public void nueva(){
                System.out.println("QUE PINTA");
            }

            @Override
            public String tipoGasolina() {
                return "GAS";
            }
        };
        
        mt.movete();
        System.out.println(mt.tipoGasolina());
              
    }
}
