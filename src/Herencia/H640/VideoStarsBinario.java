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
        try{
            if( buscarBinario(cod) ){
                String tipo = rItems.readUTF();
                String titulo = rItems.readUTF();
                
                //avanzo 16 bytes de la fecha y copias
                rItems.seek(rItems.getFilePointer()+16);
                
                if( tipo.equals("DVD") ){
                    System.out.printf("Cambiando %s a %s..\n", titulo,
                            isKid ? "KIDS" : "NORMAL");
                    //estoy justo antes del estado
                    if( isKid )
                        rItems.writeInt(TipoEstadoDVD.KIDS.ordinal());
                    else
                        rItems.writeInt(TipoEstadoDVD.NORMAL.ordinal());
                }
                else
                    System.out.println("No es de tipo DVD");
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean devolver(int codigo) {
        /*
         * TODO:
         * Busca el item con ese codigo. Se evalua que la copia sea de la
         * tienda. Si lo es ( copias renta debe ser <= que copias originales )
         * Se aumenta +1 las copias renta. 
         */
        try{
            if( buscarBinario(codigo) ){
                rItems.readUTF();//tipo
                String titulo = rItems.readUTF();
                rItems.readLong();//fecha
                int cr = rItems.readInt();
                int co = rItems.readInt();
                
                if( cr + 1 <= co ){
                    //es mia
                    System.out.printf("Devolviendo %s....\n\n", titulo);
                    rItems.seek(rItems.getFilePointer()-8);
                    rItems.writeInt(cr + 1);
                    return true;
                }
                else
                    System.out.println("COPIA NO ES MIA\n");
            }
            else
                System.out.println("NO SE ENCUENTRA");
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public void iItemsTaquilleros(Date desde)throws IOException{
        /*
         * TODO:
         * Imprime el codigo - titulo - y el tipo del ITEM tanto para DVD
         * como para VideoGame que MAS veces se han rentado desde una fecha
         * dada de parametro hasta la actualidad. Solo se toma 
         * en cuenta la cantidad de veces rentados no los dias que se lo
         * llevaron
         */
        rItems.seek(0);
        int cantDVD = 0;
        int codDVD = 0;
        String nDVD="";
        
        int cantGAME = 0;
        int codGAME = 0;
        String nGAME = "";
        
        while(rItems.getFilePointer() < rItems.length()){
            int cod = rItems.readInt();
            int total = rentasHechasPorCodigo(cod, desde);
            String tipo = rItems.readUTF();
            String titulo = rItems.readUTF();
            rItems.readLong();
            
            if( tipo.equals("DVD")){
                if( total > cantDVD ){
                    cantDVD = total;
                    codDVD = cod;
                    nDVD = titulo;
                    
                }
            }
            else{
                if( total > cantGAME ){
                   cantGAME = total;
                   codGAME = cod;
                   nGAME = titulo;
                    
                }
            }
        }
        
        if( cantDVD != 0 )
            System.out.printf("DVD TAQUILLERA %d-%s rentada %d veces.\n\n",
                    codDVD, nDVD, cantDVD);
        
        if( cantGAME != 0 )
            System.out.printf("GAME TAQUILLERO %d-%s rentado %d veces.\n\n",
                    codGAME, nGAME, cantGAME);
    }
    
    public double gananciaGenerada(Date desde)throws IOException{
        
        /*
         * TODO:
         * Retorna el total de monto generado por rentas de cualquier item
         * desde una fecha dada de parametro hasta la actualidad
         * 
         */
        rRentas.seek(0);
        double tot = 0;
        
        while(rRentas.getFilePointer() < rRentas.length()){
            rRentas.readInt(); //cod
            rRentas.readUTF(); //cliente
            Date fecha = new Date( rRentas.readLong() );
            rRentas.readInt();//dias
            double monto = rRentas.readDouble();
            
            if( fecha.getTime() >= desde.getTime() )
                tot += monto;
        }
        
        return tot;
    }

    private void registrarRenta(int codigo, int dias, double monto) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private double MontoGame(int dias, String peliocon) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private double MontoDVD(int dias, int dato) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private int rentasHechasPorCodigo(int cod, Date desde)throws IOException {
        rRentas.seek(0);
        int tot = 0;
        
        while(rRentas.getFilePointer() < rRentas.length()){
            int codigo = rRentas.readInt();
            rRentas.readUTF();
            Date fecha = new Date(rRentas.readLong());
            rRentas.readInt();//dias
            rRentas.readDouble();//pago
            
            if( codigo == cod && fecha.getTime() >= desde.getTime() )
                tot++;
        }
        
        return tot;
    }
    
}
