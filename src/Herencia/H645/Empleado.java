/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class Empleado extends Trabajador{
    protected double salario;
    
    public Empleado(int c,String n,double s){
        super(c,n);
        salario = s;       
    }

    @Override
    public String toString() {
        return super.toString() + " Salario= " + salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public double calcularPago() {
        double rap = salario * 0.035;
        return salario - rap;
    }
}
