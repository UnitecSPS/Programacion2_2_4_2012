/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Herencia.H645.InternetConection;

/**
 *
 * @author Gotcha
 */
public class SmartPhone extends Cellphone implements InternetConection {
    private boolean tieneInternet;
    
    public SmartPhone(int n, String no, String se, boolean ti){
        super(n, no, se);
        tieneInternet = ti;
    }

    @Override
    public void requestHttp(String url) {
        if( tieneInternet )
            System.out.println("Sending www.facebook.com");
    }

    @Override
    public String sendHttp() {
        if( tieneInternet )
            return "WELCOME TO MY MOBILE.COM";
        return "";
    }

    @Override
    public boolean isConnectionSafe() {
        return tieneInternet;
    }
}
