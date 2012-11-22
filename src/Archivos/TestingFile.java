/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TestingFile {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.println("Archivo o dir a manejar: ");
        
        File f = new File(lea.next());
        
        if( f.exists() ){
            System.out.println("EXISTE! WOOO!");
            System.out.println("Nombre: " + f.getName());
            System.out.println("Absoluta: " + f.getAbsolutePath());
            System.out.println("Path: " + f.getPath());
            System.out.println("Bytes: " + f.length());
            System.out.println("Parent: " + f.getAbsoluteFile().getParent());
            
            if(f.isDirectory())
                System.out.println("Es un Directorio");
            
            if(f.isFile())
                System.out.println("Es un Archivo");
            
            if(f.isHidden())
                System.out.println("Ta escondido");
            
            if(f.isAbsolute())
                System.out.println("Fue Creado con Dir Absoluta");
            else
                System.out.println("Fue creado con Dir abstracta");
            
            System.out.print("Lo quiere borrar? s/n: ");
            char resp = lea.next().charAt(0);
            
            if( Character.toLowerCase(resp) == 's' ){
                if( f.delete() )
                    System.out.println("Se borro bien");
                else
                    System.out.println("No se borro");
            }
        }
        else{
            System.out.println("NO EXISTE");
            System.out.println("Lo quiere crear? s/n");
            char resp = lea.next().charAt(0);
            
            if( Character.toLowerCase(resp) == 's'){
                System.out.println("1 Archivo o 2 Directorio");
                int op = lea.nextInt();
                
                if( op == 1){
                    try{
                       System.out.println("CANONICAL: " + f.getAbsolutePath());
                       System.out.println("Creando...");
                       
                       if( f.createNewFile() )
                            System.out.println("Se creo masiso");
                       else
                            System.out.println("No se creo el archivo");
                    }catch(IOException e){
                        System.out.println("ERROR: " + e.getMessage());
                    }
                }
                else{
                   if( f.mkdirs() )
                        System.out.println("Se creo el directorio");
                   else
                        System.out.println("No se pudo crear directorio");
                }
            }
        }
    }
}
