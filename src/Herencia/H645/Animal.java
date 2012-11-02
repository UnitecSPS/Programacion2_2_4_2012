/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.util.Calendar;

/**
 *
 * @author Gotcha
 */
public abstract class Animal {
    protected int patas;
    protected boolean mamifero;
    public final static int TEST = 9;
    
    public Animal(int p, boolean m){
        patas = p;
        mamifero = m;
    }
   
    
    public String getS(){
        //final int d;
        //d = 5; 
        //d = 5;
        return "TEST";
    }
    
    public abstract void hablar();
}
