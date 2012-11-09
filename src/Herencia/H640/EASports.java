/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public abstract class EASports implements IPlaystation {
    protected String genero;
    
    public EASports(String g){
        genero = g;
    }
    
    public String getGenero(){
        return genero;
    }
}
