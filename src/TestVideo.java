
import Herencia.H640.DVD;
import Herencia.H640.TipoPelicula;

/*
     * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gotcha
 */
public class TestVideo {
    public static void main(String args[]){
        DVD dvd = new DVD(2,"Star Wars",3,3);
        
       dvd.setCopiasVenta(4);
    }
}

