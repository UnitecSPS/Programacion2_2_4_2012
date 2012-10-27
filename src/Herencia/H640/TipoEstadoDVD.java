/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public enum TipoEstadoDVD{
    ESTRENO(1), NORMAL(2), KIDS(3);
    
    private int max;
    TipoEstadoDVD(int d){
        max = d;
    }
    
    int getMaxDias(){
        return max;
    }
}
