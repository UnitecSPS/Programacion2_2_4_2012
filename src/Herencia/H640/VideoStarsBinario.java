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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean devolver(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
