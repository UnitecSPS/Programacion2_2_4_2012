/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Dealer {
    private RandomAccessFile rCli;
    private RandomAccessFile rRev;
    
    public Dealer(){
        try{
            rCli = new RandomAccessFile("clientes.rev", "rw");
            rRev = new RandomAccessFile("revisiones.rev", "rw");
        }
        catch(IOException e){
            
        }
        
    }
    
    public boolean buscar(int cod)throws IOException{
        rCli.seek(0);
        
        while(rCli.getFilePointer() < rCli.length() ){
            if( rCli.readInt() == cod )
                return true;
            rCli.readUTF();
            rCli.readInt();
        }
        
        return false;
    }
    
    public boolean agregar(int cod, String nom)throws IOException{
        if( buscar(cod) )
            return false;
        
        rCli.seek( rCli.length() );
        rCli.writeInt(cod);
        rCli.writeUTF(nom);
        rCli.writeInt(5000);
        return true;
    }
    
    public boolean generarRevision(int cod, double monto)throws IOException{
        if( buscar(cod) ){
            String nom = rCli.readUTF();
            int kms = rCli.readInt();
            
            //generar
            rRev.seek(rRev.length());
            rRev.writeInt(kms);
            rRev.writeInt(cod);
            rRev.writeLong(new Date().getTime());
            rRev.writeDouble(monto);
            
            //actualizar el cliente
            System.out.println("Actualizado " + nom);
            rCli.seek(rCli.getFilePointer()-4);
            rCli.writeInt(kms + 5000);
            return true;
        }
        System.out.println("CLIENTE NO EXISTE");
        return false;
    }
    
    public void historico(int cod)throws IOException{
        double total = 0;
        
        if( buscar(cod)){
            rRev.seek(0);
            
            while(rRev.getFilePointer() < rRev.length() ){
                int codrev = rRev.readInt();
                int codcli = rRev.readInt();
                Date fecha = new Date(rRev.readLong());
                double monto = rRev.readDouble();
                
                if( cod == codcli ){
                    System.out.println(codrev + "-" + fecha +
                            " Lps. " + monto);
                    total += monto;
                }
            }
            
            System.out.println("Total pagado: " + total);
        }
        else{
            System.out.println("CLIENTE NO EXISTE");
        }
    }
    
    public void backup(String txtFile)throws IOException{
        FileWriter fw = new FileWriter(txtFile);
        
        rCli.seek(0);
        while(rCli.getFilePointer() < rCli.length()){
            int cod = rCli.readInt();
            String nom = rCli.readUTF();
            int kms = rCli.readInt();
            fw.write(cod + " " + nom + " " + kms +" ");
        }
        
        rRev.seek(0);
        while(rRev.getFilePointer() < rRev.length() ){
            int kms = rRev.readInt();
            int codcli = rRev.readInt();
            long fecha = rRev.readLong();
            double monto = rRev.readDouble();
            fw.write(kms + " " + codcli + " " + fecha +
                    " " + monto + " ");
        }
        fw.close();
    } 
    
    public void clienteEstrella()throws IOException{
        int mayor = 0;
        int cod = 0;
        String nom = "";
        
        rCli.seek(0);
        while(rCli.getFilePointer() < rCli.length()){
            int codcli = rCli.readInt();
            String n = rCli.readUTF();
            int kms = rCli.readInt();
            
            if( kms > mayor ){
                mayor = kms;
                cod = codcli;
                nom = n;
            }
        }
        
        if( cod != 0 )
            System.out.println("Cliente Estrella: " +
                    cod + "-" + nom);
    }
}
