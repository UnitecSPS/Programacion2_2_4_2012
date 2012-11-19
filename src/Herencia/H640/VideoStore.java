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
public class VideoStore {
    public static void main(String args[])throws InvalidDaysException{
        //downcasting
        ArrayList<Item> lista = new ArrayList<Item>();
        
        lista.add( new Item(1,"Item General",2) {

            @Override
            public double renta(int cd) {
                return 0;
            }
        } );
        lista.add( new DVD(2,"Batman", 5, 3) );
        lista.add( new VideoGame(3,"FIFA 13",3,TipoConsola.PS3) );
        
        for(Item it : lista){
            System.out.println(it);
            System.out.println("Renta: " + it.renta(1));
            
            if( it instanceof VideoGame ){
                System.out.println("VIDEO GAME");
            }
            else if( it instanceof DVD){
                System.out.println("DVD");
            }
            else{
                System.out.println("ITEM");
            }
        }
        
        //----------------------
        //upcasting
        Item ite = new DVD(4,"Piratas del Caribe",3,3.2);
        //downcasting indirect
        DVD dvd = (DVD)ite;
        System.out.println("Duracion: " + dvd.getDuracion());
        //dowcasting directo
        System.out.println("Duracion: " + 
                ((DVD)ite).getDuracion() );
        
        
    }
}
