/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class LeerEscribir {
    public static void main(String[] args) {
        
        Scanner lea = new Scanner(System.in);
        String path = lea.nextLine();
        
        FileWriter fw;
        
        try{
            System.out.println("Append? ");
            char op = lea.next().charAt(0);
            
            fw = new FileWriter(path, op == 's' ? true : false);
            
            do{
                System.out.println("Escriba algo: ");
                String dato = lea.nextLine();
                if(!dato.equals("SALIR"))
                    fw.write(dato + "\n");
                else
                    break;
            }while(true);
            fw.close();
            
            ///---------------LEAAAA
            File f = new File(path);
            FileReader fr = new FileReader(f);
            
            char buffer[] = new char[(int)f.length()];
            int bytes = fr.read(buffer);
            
            System.out.println("CONTENIDO\n--------");
            System.out.println(buffer);
            System.out.println("Bytes leidos: " + bytes);
            System.out.println("TOTAL: " + f.length());
            
            
            buffer  = new char[(int)f.length()];
             bytes = fr.read(buffer);
            System.out.println("CONTENIDO\n--------");
            System.out.println(buffer);
            System.out.println("Bytes leidos: " + bytes);
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
