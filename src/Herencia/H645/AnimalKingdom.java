/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class AnimalKingdom {
    public static void main(String args[]){
        ArrayList<Animal> animales = new ArrayList<Animal>();
        //animales.contains(args);
        
        animales.add( new Perro() );
        animales.add(new Gato());
        animales.add(new Patito());
        animales.add( new Vaca());
        
        for(Animal ani : animales)
            ani.hablar();
        
        Animal anim = new Animal(0,false){
            @Override
            public void hablar(){
                System.out.println("GHRER HEGRHEG REHGR");
            }
            
            public void pollito(){
                System.out.println("Y QUE HAGO AQUI?");
            }
        };
        
        anim.hablar();
        System.out.println("s: " + anim.getS());
        //System.out.println("Test: " + anim.test);
        
        
        Animal an = Animal.getInstance("PERRO");
        an.hablar();
        
        /*mithbuster final FAIL
        Perro perr = new Perro(){
            @Override
          public void moverCola(){
              System.out.println("SOy Perro Mutante");
          }  
        };
        
        //perr.moverCola();*/
    }
    
    
}
