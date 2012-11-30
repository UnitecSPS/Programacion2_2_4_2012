/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Tree {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.print("Ingrese dir: ");
        String path = lea.next();
        tree(new File(path), "") ;
    }

    private static void tree(File dir, String tab) {
        if( dir.isDirectory() ){
            System.out.println(tab + "-" + dir.getName());
            File files[] = dir.listFiles();
            for(File fi : files){
                if( fi.isDirectory() && !fi.isHidden() )
                    tree(fi, tab + "\t");
            }
        }
    }
}
