/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab3;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Gotcha
 */
public class ListaEmpleados {
    private Nodo raiz;
    private RandomAccessFile ram;
    
    public ListaEmpleados(){
        try{
            ram = new RandomAccessFile("empleados.tbr", "rw");
            recarga();
        }
        catch(IOException e){
            
        }
    }

    public final void recarga()throws IOException {
        //por si acaso
        ram.seek(0);
        raiz = null;
        
        while(ram.getFilePointer() < ram.length() ){
            long pos = ram.getFilePointer();
            int cod = ram.readInt();
            String n = ram.readUTF();
            ram.readDouble();
            
            if( ram.readBoolean() )
                agregarALista(new Nodo(cod,n,pos));
        }
    }

    private void agregarALista(Nodo nodo) {
        if( raiz == null ){
            raiz = nodo;
        }
        else{
            Nodo v = raiz;
            
            while(v.siguiente != null ){
                v = v.siguiente;
            }
            
            //conectar
            v.siguiente = nodo;
            nodo.anterior = v;
        }
    }
    
    public long busqueda(int cod){
        Nodo v = raiz;
        
        while( v != null ){
            if( v.cod == cod )
                return v.bytes;
            v = v.siguiente;
        }
        
        return -1;
    }
    
    public boolean agregar(int cod, String n, double sal)throws IOException{
        if( busqueda(cod) == -1){
            ram.seek(ram.length());
            
            long pos = ram.getFilePointer();
            ram.writeInt(cod);
            ram.writeUTF(n);
            ram.writeDouble(sal);
            ram.writeBoolean(true);
            
            agregarALista(new Nodo(cod,n,pos));
            return true;
        }
        return false;
    }
    
    public boolean despedir(int cod)throws IOException{
        long pos = busqueda(cod);
        
        if( pos >= 0 ){
            ram.seek(pos);
            
            ram.readInt();//cod
            ram.readUTF();//nomb
            ram.readDouble();//sal
            ram.writeBoolean(false);
            
            removerDeLista(cod);
            return true;
        }
        
        return false;
    }

    private void removerDeLista(int cod) {
        
        if( raiz != null ){
            if( raiz.cod == cod ){
                //la raiz la borrare
                raiz = raiz.siguiente;
                if( raiz != null )
                    raiz.anterior = null;
            }
            else{
                //buscar otro
                Nodo v = raiz;
                
                while(v.siguiente != null ){
                    if(v.siguiente.cod == cod){
                        //enfrente esta el que quiero borrar!
                        v.siguiente = v.siguiente.siguiente;
                        
                        //por si acaso ya queda en la cola
                        if( v.siguiente != null ){
                            v.siguiente.anterior = v;
                        }
                        return;
                    }
                    v = v.siguiente;
                }
            }
        }
    }
    
    public void antesDe(int cod)throws IOException{
        Nodo v = raiz;
        
        while( v != null ){
            if( v.cod == cod ){
                //lo encontramos
                Nodo v2 = v.anterior;
                //vamos para atras
                while(v2 != null){
                    ram.seek(v2.bytes);
                    int c = ram.readInt();
                    String n = ram.readUTF();
                    double sal = ram.readDouble();
                    System.out.printf("%d - %s L.%f\n", c,n,sal);
                    
                    v2 = v2.anterior;
                }
                
                return;
            }
            v = v.siguiente;
        }
    }
    
    public double pagar(int cod)throws IOException{
        long pos = busqueda(cod);
        
        if( pos >= 0){
            ram.seek(pos);
            ram.readInt();
            System.out.println("Pagar a " + ram.readUTF());
            double sal = ram.readDouble();
            
            return sal - (sal * 0.035);
        }
        return 0;
    }
    
    //extra
    public void listar(){
        Nodo v = raiz;
        System.out.println("\nLISTA EMPLEADOS\n-------------");
        while( v != null ){
            System.out.printf("%d- %s\n",v.cod,v.nomb);
            v = v.siguiente;
        }
        System.out.println("\n");
    }
}
