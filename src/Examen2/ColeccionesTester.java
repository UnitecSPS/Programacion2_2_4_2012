/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class ColeccionesTester {
    static MiColeccion micol[] = new MiColeccion[10];
    static int pos = 0;
    
    static boolean agregarColeccion(TipoColeccion tipo){
        try{
            switch(tipo){
                case STRING:
                    micol[pos++] = new ColeccionString();
                    break;
                case INTEGER:
                    micol[pos++] = new ColeccionEntera();
                    break;
                case CHAR:
                    micol[pos++] = new ColeccionCaracter();
                    break;
                case DOUBLE:
                    micol[pos++] = new ColeccionDouble();
            }
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ya no hay espacio");
        }
        return false;
    }
    
    static void agregarElementoEnColeccion(int poscol, Object val)throws ValorMaloException{
        try{
            ((iCollection)micol[poscol]).agregar(val);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Posicion No existe");
        }
    }
    
    static void Estadistica(){
        for(int x=0; x < pos; x++){
            System.out.println("Tipo: " + 
                    ((iCollection)micol[x]).getTipo());
            micol[x].imprimirColeccion();
        }
    }
    
    static boolean buscarEnColeccion(int poscol ){
        Scanner lea = new Scanner(System.in);
        Object val = null;
        
        try{
            if(micol[poscol] instanceof ColeccionCaracter){
                val = lea.next().charAt(0);
            }
            else if(micol[poscol] instanceof ColeccionEntera){
                val = lea.nextInt();
            }
            
            return ((iCollActions)micol[pos]).buscarElemento(val);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
}
