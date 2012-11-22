/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class MiColeccion {
    ArrayList elementos;
    
    public MiColeccion(){
        elementos = new ArrayList();
    }
    
    public void imprimirColeccion(){
        for(Object o : elementos){
            System.out.println(o);
        }
    }
}
