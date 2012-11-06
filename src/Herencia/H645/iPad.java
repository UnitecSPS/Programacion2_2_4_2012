/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public class iPad implements InternetConection{

    @Override
    public void requestHttp(String url) {
        System.out.println(url);
    }

    @Override
    public String sendHttp() {
        return "appleStore.com";
    }

    @Override
    public boolean isConnectionSafe() {
        return true;
    }
    
}
