/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class CuentaBancaria {
    protected int codigo;
    protected String nombre;
    protected double saldo;
    
    public CuentaBancaria(int c, String n){
        codigo = c;
        nombre = n;
        saldo = 500;
    }
    
    public void imprimir(){
        System.out.println("Codigo: " + codigo +
             " Nombre:" + nombre + " Saldo: " + saldo);
        
    }
}
