/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;

/**
 *
 * @author Gotcha
 */
public class TestDennis {
    public static void main(String[] args) {
        File dir = new File("dennis");
        
        if( dir.mkdir() ){
            File ar = new File("dennis/menjivar.doc");
            
            try{
                if( ar.createNewFile() )
                    System.out.println("SE CREO BIEN");
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
