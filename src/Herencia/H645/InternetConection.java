/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public interface InternetConection {
    public int VERSION = 909;
    
    void requestHttp(String url);
    String sendHttp();
    boolean isConnectionSafe();
}
