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
public class TestFile {
    public static void main(String[] args) {
        File fil = new File("cana/pelo/oreja");
        
        if( fil.exists() ){
            System.out.println(fil.getAbsolutePath() + " EXISTE");
            
            if( fil.isFile() )
                System.out.println("Es un Archivo");
            if( fil.isDirectory()) 
                System.out.println("Es un folder o directorio");
            if( fil.isHidden())
                System.out.println("Esta escondido");
            System.out.println("Bytes: " + fil.length());
            System.out.println("Name: "+ fil.getName());
            System.out.println("Path: " + fil.getPath());
            System.out.println("Parent: " + fil.getAbsoluteFile().getParent());
        }
        else{
            System.out.println("LO QUE MANEJO NO EXISTE");
            try{
                if( fil.mkdirs() )
                    System.out.println("SE CREO BIEN");
            }
            catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
