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
                //estado dvd o max players
                int dato;
                String peliocon;
                        
                if( tipo == TipoItem.GAME){
                    System.out.print("Max Players: ");
                    dato= lea.nextInt();
                    System.out.print("Consola: ");
                }
                else{
                    dato = TipoEstadoDVD.ESTRENO.ordinal();
                    System.out.print("Tipo Pelicula: ");
                }
                peliocon = lea.next();
                rItems.writeInt(dato);
                rItems.writeUTF(peliocon);
                
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }

    @Override
    public Item buscar(int codigo) {
        throw new UnsupportedOperationException();
    }
    
    public boolean buscarBinario(int codigo){
        try{
            rItems.seek(0);
            
            while(rItems.getFilePointer() < rItems.length() ){
                if( codigo == rItems.readInt() ){
                    return true;
                }
                
                rItems.readUTF();//tipo
                rItems.readUTF();//titulo
                rItems.seek(rItems.getFilePointer()+20);
                rItems.readUTF();
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
        return false;
    }

    @Override
    public double rentar(int codigo, int dias) throws InvalidDaysException {
        try{
            if( buscarBinario(codigo) ){
                String tipo = rItems.readUTF();
                String titulo = rItems.readUTF();
                rItems.readLong();
                
                long pos = rItems.getFilePointer();
                int copias = rItems.readInt();
                rItems.readInt();
                int dato = rItems.readInt();
                String peliocon = rItems.readUTF();
                
                if( copias > 0 ){
                    double monto;
                    //saco monto
                    if( tipo.equals("DVD"))
                        monto = MontoDVD(dias, dato);
                    else
                        monto = MontoGame(dias, peliocon);
                    
                    //registro renta
                    registrarRenta(codigo,dias, monto);
                    
                    //actualizo copias
                    rItems.seek(pos);
                    rItems.writeInt(copias-1);
                }
                else
                    System.out.println("No hat copias");
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
        return 0;
    }

    @Override
    public void imprimir() {
        try{
            rItems.seek(0);
            
            while(rItems.length() > rItems.getFilePointer() ){
                int cod = rItems.readInt();
                TipoItem tipo = TipoItem.valueOf(rItems.readUTF());
                String titulo = rItems.readUTF();
                rItems.readLong();
                int cr = rItems.readInt();
                int co = rItems.readInt();
                rItems.readInt();
                String peliocon = rItems.readUTF();
                
                System.out.printf("%s %d-%s Copias Renta: %d Copias Totales: %d - %s\n",
                        tipo.toString(), cod, titulo, cr, co, peliocon);
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
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
