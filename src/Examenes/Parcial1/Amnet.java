/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Parcial1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Amnet {
    static ArrayList<Servicio> servicios;
    
    public static void main(String args[]){
        servicios = new ArrayList<Servicio>();
        agregarServicio("TV");
        agregarServicio("TV");
        agregarServicio("INTERNET");
        
        imprimirServicios();
        
        agregarCanalAServicioTV(1,"HBO");
    }

    private static void agregarServicio(String tipo) {
        Scanner lea = new Scanner(System.in);
        
        int c = lea.nextInt();
        String n = lea.next();
        
        if( tipo.equals("TV") ){
            char id = lea.next().charAt(0);
            boolean isD = id == 's' ? true : false;
            
            servicios.add( new TVService(c,n,isD));
        }
        else if( tipo.equals("INTERNET")){
            String ancho = lea.next();
            AnchoBanda abanda = AnchoBanda.valueOf(ancho);
            
            servicios.add( new InternetService(c,n,abanda));
        }
        else
            System.out.println("TIPO INCORRECTO");
    }

    private static void imprimirServicios() {
        int ctv = 0, cinter = 0;
        
        for(Servicio ser : servicios){
            System.out.println(ser);
            
            if( ser instanceof TVService ){
                ctv++;
                ((TVService)ser).imprimir();
            }
            else
                cinter++;
        }
        
        System.out.println(ctv + " - " + cinter);
    }

    private static void agregarCanalAServicioTV(int cod, String canal) {
        Servicio ser = buscar(cod, 0);
        
        if( ser instanceof TVService ){
            ((TVService)ser).agregarCanal(canal);
        }
    }

    private static Servicio buscar(int codigo, int pos) {
        if( pos < servicios.size() ){
            if( servicios.get(pos).getCodigo() == codigo )
                return servicios.get(pos);
            return buscar(codigo, pos+1);
        }
        return null;
    }
    
    public static double cobrar(int cod){
        Servicio ser = buscar(cod,0);
        
        if( ser != null ){
            return ser.getMontoMensual();
        }
        return 0;
    }
}
