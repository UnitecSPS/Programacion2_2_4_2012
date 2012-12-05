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
public class CopyPaste {
    public static void main(String[] args) {
        try{
            Scanner lea = new Scanner(System.in);
            String path = lea.nextLine();
            File f = new File(path);
            FileReader fleer = new FileReader(f);
            //char buffer[] = new char[(int)f.length()];
            //fleer.read(buffer);
            
            Scanner leer = new Scanner(fleer);
            leer.useDelimiter(System.getProperty("line.separator"));
            
            while(leer.hasNext()){
                System.out.println(leer.next());
            }
            
            //FileWriter fw = new FileWriter("fotoprueba.jpg");
            //fw.write(buffer);
            //fw.close();
        }
        catch(IOException e){
            
        }
    }
}
