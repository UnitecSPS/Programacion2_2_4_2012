/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Gotcha
 */
public class Patito {
    public void test(){
        int arr[] = { 1,2,3 };
        System.out.println(arr[1]);
        System.out.println("CUAC CUAC");
    }
    
    public void nadar(int x){
        if( x > 10 )
            throw new RuntimeException("ERROR SE PASO DE 10");
    }
}
