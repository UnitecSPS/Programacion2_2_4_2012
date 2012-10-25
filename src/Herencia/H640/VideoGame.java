/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class VideoGame extends Item {
    
    public VideoGame(int i, String n, int c){
        super(i,n, c);
    }
    
    @Override
    public double renta(int d){
        return 60 * d;
    }
}
