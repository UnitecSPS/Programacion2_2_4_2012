
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gotcha
 */
public class Plan {
    protected int numero;
    protected String nombre;
    protected Date fecha;
    
    public Plan(int n, String no){
        numero = n;
        nombre = no;
        fecha = new Date();
    }
    
    public double pagoMensual(int cm, int cmsg){
        return 0;
    }

    @Override
    public String toString() {
        return "Plan{" + "numero=" + numero + ", nombre=" + nombre + '}';
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }
    
    
}
