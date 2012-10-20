/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;

/**
 *
 * @author Gotcha
 */
public class Recursiones {

    private int array[] = { 3,5,6,8,1 };
    
    //Tarea
    public static boolean palindromo(String cad){
        return palindromo(cad,0,cad.length()-1);
    }
    
    private static boolean palindromo(String cad,int inicio,int fin){
        if( inicio < fin ){
            if( cad.charAt(inicio) != cad.charAt(fin) )
                return false;
            return palindromo(cad, inicio + 1, fin - 1);
        }
        return true;
    }
    
    //Prueba para las 6:40 y ejercicio de TG1 para 6:45
    public static boolean buscarEnCadena(String cad,char carac){
        return buscarEnCadena(cad, carac, 0);
    }
    
    private static boolean buscarEnCadena(String cad, char carac, int pos) {
        if( pos < cad.length() ){
            if( cad.charAt(pos) == carac )
                return true;
            return buscarEnCadena(cad, carac, pos +1 );
        }
        return false;
    }
    
    public void imprimir(){
        imprimir(0);
        System.out.println("");
    }
    
    private void imprimir(int pos){
        if( pos < array.length ){
            System.out.print( array[pos] + " ");
            imprimir(pos+1);
        }
    }
    
    public int suma(){
        return suma(0);
    }

    private int suma(int pos) {
        if( pos < array.length )
            return array[pos] + suma(pos+1);
        return 0;
    }
    
    public int mayor(){
        return mayor(0, array[0]);
    }

    private int mayor(int pos, int grande) {
        if(pos < array.length){
            if( array[pos] >  grande )
                grande = array[pos];
            return mayor(pos+1, grande);
        }
        return grande;
    }
    
    public int divisibles(int divi){
        return divisibles(divi,0);
    }

    private int divisibles(int divi, int pos) {
        if( pos < array.length ){
            if( array[pos] % divi == 0 )
                return 1 + divisibles(divi,pos+1);
            return divisibles(divi,pos+1);
        }
        return 0;
    }
}
