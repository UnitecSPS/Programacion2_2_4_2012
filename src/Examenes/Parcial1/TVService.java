/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Parcial1;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class TVService extends Servicio{
    private ArrayList<String> canales;
    private boolean isDigital;
    
    public TVService(int c, String n, boolean id){
        super(c,n);
        isDigital = id;
        canales = new ArrayList<String>();
    }
    
    public void agregarCanal(String canal){
        for(String c : canales){
            if( c.equals(canal))
                return;
        }
        
        canales.add(canal);
    }
    
    @Override
    public String toString(){
        return super.toString() + isDigital;
    }
    
    @Override
    public double getMontoMensual(){
        if( isDigital )
            return 5 + ( canales.size() * 5);
        return canales.size() * 5;
    }
    
    public void imprimir(){
        imprimir(0);
    }

    private void imprimir(int pos) {
        if( pos < canales.size() ){
            System.out.println("Canal: " + canales.get(pos));
            imprimir(pos+1);
        }
    }
    
    
}
