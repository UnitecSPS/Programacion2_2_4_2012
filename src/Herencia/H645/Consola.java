/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public abstract class Consola implements InternetConection {
    protected int max_controles;
    protected String region;
    
    public Consola(int m,String r){
        max_controles = m;
        region = r;
    }
}
