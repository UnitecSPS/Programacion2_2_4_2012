/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Parcial1;

/**
 *
 * @author Gotcha
 */
public class InternetService extends Servicio{
    private AnchoBanda tipoBanda;
    
    public InternetService(int c, String n, AnchoBanda ab){
        super(c,n);
        tipoBanda = ab;
    }
    
    @Override
    public String toString(){
        return super.toString() + tipoBanda;
    }
    
    @Override
    public double getMontoMensual(){
        switch(tipoBanda){
            case AB256:
                monto = 150;
                break;
            case AB512:
                monto = 300;
                break;
            case AB1:
                monto = 600;
                break;
            default:
                monto = 1000;
        }
        
       /* if( tipoBanda == AnchoBanda.AB2){
            
        }*/
        return monto;
    }
}
