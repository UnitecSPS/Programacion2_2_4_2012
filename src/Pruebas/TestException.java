/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class TestException {
    ArrayList arr = new ArrayList();
    
    public void agregar(Object val){
        if( val instanceof Integer ||
                val instanceof Double )
            
            throw new InvalidTypeException();
        
        arr.add(val);
    }
    
    public void test(){
        try{
            agregar(1);
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        TestException t = new TestException();
        t.test();
    }
}
