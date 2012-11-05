/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab1;

/**
 *
 * @author Gotcha
 */
public class BarcoPesquero extends Barco{
    private int pecesCapturados;
    public static double PRECIO_X_PESCADO = 80.99;
    
    public BarcoPesquero(String n){
        super(n);
        pecesCapturados = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " BarcoPesquero{" + 
                "pecesCapturados=" + pecesCapturados + '}';
    }
    
    @Override
    public void agregarElemento(){
        pecesCapturados++;
    }
    
    @Override
    public double vaciarCobrar(){
        double tot = pecesCapturados * PRECIO_X_PESCADO;
        pecesCapturados = 0;
        return tot;
    }
}
