/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import Pruebas.SmartPhone;

/**
 *
 * @author Gotcha
 */
public class TestInter {
    public static void main(String[] args) {
        InternetConection ic = new SmartPhone(222,"Carlos", "333",true);
        InternetConection icp = new PS3();
        InternetConection ici = new iPad();
        
        ic.requestHttp(null);
        icp.requestHttp(null);
        ici.requestHttp("apple.com");
        
        
        Object ps3 = new PS3();
        
        if( ps3 instanceof InternetConection ){
            System.out.println("Sacar Down");
            ((InternetConection)ps3).requestHttp(null);
        }
        
        
        
    }
}
