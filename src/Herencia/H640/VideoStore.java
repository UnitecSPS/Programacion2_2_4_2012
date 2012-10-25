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
public class VideoStore {
    public static void main(String args[]){
        //downcasting
        ArrayList<Item> lista = new ArrayList<Item>();
        
        lista.add( new Item(1,"Item General",2) );
        lista.add( new DVD(2,"Batman", 5, 3) );
        lista.add( new VideoGame(3,"FIFA 13",3) );
        
        for(Item it : lista){
            System.out.println(it);
            System.out.println("Renta: " + it.renta(1));
        }
        
    }
}
