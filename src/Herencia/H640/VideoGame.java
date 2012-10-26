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
    
    private int dennis;
    
    public VideoGame(int i, String n, int c){
        super(i,n, c);
        dennis = 5;
    }
    
    @Override
    public double renta(int d){
        return 60 * d;
    }

    public int getDennis() {
        return dennis;
    }
    
    
}
