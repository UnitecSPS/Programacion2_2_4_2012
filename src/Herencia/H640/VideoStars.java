/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class VideoStars implements IManagementItems{
    private ArrayList<Item> items;
    private Scanner lea;
    
    public VideoStars(){
        items = new ArrayList<Item>();
        lea = new Scanner(System.in);
    }
    
    public void agregarItem(TipoItem tipo){
        //pido lo comun
        int cod;
        do{
            System.out.print("Codigo: ");
            cod = lea.nextInt();
        }while( buscar(cod) != null );
                
        System.out.print("Nombre: ");
        String n = lea.next();
        System.out.print("Copias: ");
        int co = lea.nextInt();
        
        if( tipo == TipoItem.DVD ){
            System.out.print("Duracion: ");
            double dur = lea.nextDouble();
            
            items.add( new DVD(cod, n, co, dur) );
        }
        else{
            //es game!
            System.out.println("Tipo Consola: ");
            TipoConsola tipoc = TipoConsola.valueOf(lea.next());
            
            items.add( new VideoGame(cod,n, co, tipoc) );
        }
    }
    
    @Override
    public Item buscar(int codigo){
        for(Item it : items){
            if( it.getId() == codigo )
                return it;
        }
        return null;
    }
    
    @Override
    public double rentar(int codigo, int dias)throws InvalidDaysException{
        Item it = buscar(codigo);
        
        if( it != null ){
            //se encontro!
            return it.renta(dias);
        }
        
        return 0;
    }
    
    @Override
    public void imprimir(){
        int cdvd = 0, cgame = 0;
        
        for(Item it : items){
            System.out.println(it); // <-- llama a toString()
            
            if( it instanceof DVD )
                cdvd++;
            else
                cgame++;
        }
        
        System.out.println(cdvd + " DVD(s)");
        System.out.println(cgame + " GAME(s)");
    }
    
    //probar con algo propio de la hija!
    public void CambiarEstadoPelicula(int cod, boolean isKid){
        //primero buscamor el objeto
        Item it = buscar(cod);
        
        //luego si lo encuentra no deberia ser nulo
        if( it != null ){
            //deberia ser de tipo DVD!
            if( it  instanceof DVD ){
                //cambiamos el estado haciendo Downcasting
                TipoEstadoDVD tipo; 
                tipo = isKid ? TipoEstadoDVD.KIDS : TipoEstadoDVD.NORMAL;
                
                ((DVD)it).setEstado(tipo);
            }
            else
                System.out.println("SE ENCONTRO! PERO NO ES DVD!");
        }
        else
            System.out.println("ITEM NO EXISTE");
    }

    @Override
    public boolean devolver(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
