/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class VideoStarsBinario implements IManagementItems {

    private RandomAccessFile rItems;
    private RandomAccessFile rRentas;
    private Scanner lea = new Scanner(System.in);
    
    public VideoStarsBinario(){
        try{
            rItems = new RandomAccessFile("items.gms", "rw");
            rRentas = new RandomAccessFile("rentas.gms","rw");
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }
    
    public int getCodigo(){
        try{
            RandomAccessFile rCod = new RandomAccessFile("codigos.gms","rw");
            int codigo = 1;
            
            if( rCod.length() == 4){
                codigo = rCod.readInt();
                rCod.seek(0);
            }
            
            rCod.writeInt(codigo + 1);
            return codigo;
        }
        catch(IOException e){
            System.out.println("ERROR");
            return -1;
        }
    }
    
    @Override
    public void agregarItem(TipoItem tipo) {
        
        try{
            rItems.seek( rItems.length() );
            
            int codigo = getCodigo();
            
            if( codigo != -1 ){
                //codigo
                rItems.writeInt( codigo );
                //tipo
                rItems.writeUTF(tipo.toString());
                //titulo
                System.out.print("Titulo: ");
                rItems.writeUTF(lea.next());
                //fecha
                rItems.writeLong( new Date().getTime() );
                //cantidades
                System.out.print("Cantidad copias: ");
                int copias = lea.nextInt();
                rItems.writeInt(copias);
                rItems.writeInt(copias);
                
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }

    @Override
    public Item buscar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double rentar(int codigo, int dias) throws InvalidDaysException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CambiarEstadoPelicula(int cod, boolean isKid) {
        /*
         * TODO:
         * Buscar la pelicula con ese codigo, si se encuentra y es
         * de tipo DVD se le cambia el estado. Recordar que lo que 
         * se guarda es el ordinal del tipo. Si isKid es true el estado
         * sera KIDS y si es falo el estado sera NORMAL
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean devolver(int codigo) {
        /*
         * TODO:
         * Busca el item con ese codigo. Se evalua que la copia sea de la
         * tienda. Si lo es ( copias renta debe ser <= que copias originales )
         * Se aumenta +1 las copias renta. 
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void iItemsTaquilleros(Date desde){
        /*
         * TODO:
         * Imprime el codigo - titulo - y el tipo del ITEM tanto para DVD
         * como para VideoGame que MAS veces se han rentado desde una fecha
         * dada de parametro hasta la actualidad. Solo se toma 
         * en cuenta la cantidad de veces rentados no los dias que se lo
         * llevaron
         */
    }
    
    public double gananciaGenerada(Date desde){
        /*
         * TODO:
         * Retorna el total de monto generado por rentas de cualquier item
         * desde una fecha dada de parametro hasta la actualidad
         * 
         */
        return 0;
    }
    
}
