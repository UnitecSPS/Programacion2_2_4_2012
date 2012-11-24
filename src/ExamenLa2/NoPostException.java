/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLa2;

public class NoPostException extends Exception{
    public NoPostException(){
        super("Este post no existe");
    }
}
