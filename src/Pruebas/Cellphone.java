/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class Cellphone {
    protected int numero;
    protected String nombre;
    protected String serie;
    
    public Cellphone(int n, String no, String se){
        numero = n;
        nombre = no;
        serie = se;
    }
    
    @Override
    public String toString(){
        return "Numero=" + numero + " Nombre=" + nombre +
                " Serie=" + serie;
    }
}
