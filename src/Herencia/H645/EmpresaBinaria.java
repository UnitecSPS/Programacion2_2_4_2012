/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class EmpresaBinaria implements ITrabajadorManagement{

    private String nombre;
    private RandomAccessFile rTrab;
    
    public EmpresaBinaria(String n){
        nombre = n;
        try{
            rTrab = new RandomAccessFile("trabajadores.tbr","rw");
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    public int getCodigo(){
        try{
            RandomAccessFile rCods = new RandomAccessFile("codigos.tbr","rw");
            int codigo;
            
            if( rCods.length() == 0 ){
                codigo = 1;
            }
            else{
                codigo = rCods.readInt();
                rCods.seek(0);
            }
            
            rCods.writeInt(codigo + 1);
            return codigo;
        }
        catch(Exception e){
            System.out.println("Error");
            return -1;
        }
    }  
    
    @Override
    public void agregarEmpleado(Trabajador t) {
        try{
            //me aseguro que estoy al final
            rTrab.seek(rTrab.length());
            
            int codigo = getCodigo();
            
            //codigo
            rTrab.writeInt(codigo);
            
            //tipo y dato
            double dato = 0, tasa = 0;
            if( t instanceof EmpleadoPorVenta ){
                rTrab.writeUTF(TipoEmpleado.PORCOMISION.toString());
                dato = ((Empleado)t).getSalario();
                tasa = ((EmpleadoPorVenta)t).getTasa();
            }else if( t instanceof EmpleadoPorHora ){
                rTrab.writeUTF(TipoEmpleado.PORHORA.toString());
            }else{
                rTrab.writeUTF(TipoEmpleado.PORSALARIO.toString());
                dato = ((EmpleadoPorVenta)t).getSalario();              
            }
            //nombre
            rTrab.writeUTF(t.getNombre());
            //ihss
            rTrab.writeInt(-1);
            //fecha nac
            rTrab.writeLong(-1);
            //fecha inici
            rTrab.writeLong( new Date().getTime() );
            //dato
            rTrab.writeDouble(dato);
            //tasa
            rTrab.writeDouble(tasa);
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void imprimirPlanilla() {
        try{
            rTrab.seek(0);
            
            while(rTrab.getFilePointer() < rTrab.length() ){
                int cod = rTrab.readInt();
                TipoEmpleado tipo = TipoEmpleado.valueOf(rTrab.readUTF());
                String n = rTrab.readUTF();
                int ihss = rTrab.readInt();
                long fechanac = rTrab.readLong();
                Date fechai = new Date(rTrab.readLong());
                double dato = rTrab.readDouble();
                double tasa = rTrab.readDouble();
                
                System.out.print(cod + " - " + n + 
                        " IHSS: " + ihss);
                
                if( fechanac != -1 )
                    System.out.print(" fecha nac: " + new Date(fechanac));
                
                System.out.print(" Fecha Inicio: " + fechai);
                
                switch(tipo){
                    case PORSALARIO:
                        System.out.print(" Salario: " + dato);
                        break;
                    case PORCOMISION:
                        System.out.print(" Salario: " + dato +
                                " tasa de comision: " + tasa);
                        break;
                    default:
                        System.out.print(" Horas trabajadas: " + dato);
                }
                
                System.out.println(" TIPO: " + tipo);
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean buscarTrabajador(int cod) {
        try{
            rTrab.seek(0);
            while(rTrab.getFilePointer() < rTrab.length()){
                if( rTrab.readInt() == cod )
                    return true;
                rTrab.readUTF();
                rTrab.readUTF();
                rTrab.seek(rTrab.getFilePointer()+ 36);
            }
            
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public double pagarATrabajador(int cod) {
        try{
            if( buscarTrabajador(cod) ){
               //donde estaria el puntero de rTrab
                TipoEmpleado tipo = TipoEmpleado.valueOf(rTrab.readUTF());
                String nom = rTrab.readUTF();
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void setHorasTrabajadas(int cod, int horast) throws NotValidValueException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setVentas(int cod, double vent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFechaNacimiento(int cod, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
