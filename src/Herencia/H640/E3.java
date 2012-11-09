/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class E3 {
    public static void main(String[] args) {
        ArrayList<IPlaystation> arr = new ArrayList<IPlaystation>();
        arr.add(new FIFA());
        arr.add(new Uncharted());
        arr.add(new FinalFantasy());
        arr.add(new CallOfDuty());
         
        for(IPlaystation ips : arr){
            System.out.println(ips.getGameTitle());
            
            if( ips instanceof IOnline ){
                
                System.out.println("Server: " + 
                        ((IOnline)ips).getServer());
            }
        }
       
        
    }
}
