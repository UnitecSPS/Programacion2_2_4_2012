/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class PS3 extends Consola implements IPsn, iPatito {
    
    public PS3(){
        super(4,"USA");
    }

    @Override
    public void requestHttp(String url) {
        System.out.println("play.com");
    }

    @Override
    public String sendHttp() {
        return "sony.com";
    }

    @Override
    public boolean isConnectionSafe() {
        return true;
    }

    @Override
    public void crearUser() {
        System.out.println("Creating user");
    }

    @Override
    public String getUser() {
        return "gotchahn";
    }

    @Override
    public int nadar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

