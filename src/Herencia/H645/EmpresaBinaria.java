/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.io.File;
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
            new File("ventas").mkdir();
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
                rTrab.seek(rTrab.getFilePointer()+20);
                double salohora = rTrab.readDouble();
                double tasa = rTrab.readDouble();
                double rap = salohora * 0.035;
                
                switch(tipo){
                    case PORSALARIO:
                        return salohora - rap;
                    case PORCOMISION:
                        return (salohora - rap) + comisionPendiente(cod, tasa);
                    case PORHORA:
                        return pagoPorHoras(salohora);
                        
                }
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void setHorasTrabajadas(int cod, int horast) throws NotValidValueException {
        /*
         * TODO:
         * Buscar el trabajador con ese codigo, asegurense que el trabajador
         * sea de tipo PORHORA para luego actualizar sus horas trabajadas
         */
        if( horast < 0 || horast > 500)
            throw new NotValidValueException(horast);
        
        try{
            if( buscarTrabajador(cod) ){
                TipoEmpleado tipo = TipoEmpleado.valueOf(rTrab.readUTF());
                
                if( tipo == TipoEmpleado.PORHORA ){
                    String n = rTrab.readUTF();
                    rTrab.seek(rTrab.getFilePointer()+20);
                    //actualizar las horas
                    System.out.println("Actualizando horas a " + n + "...");
                    rTrab.writeDouble(horast);
                }
                else{
                    System.out.println("Empleado NO es por hora");
                }
            }
            else
                System.out.println("No se encontro empleado");
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void setVentas(int cod, double vent) {
        /*
         * TODO:
         * Recuerden que cada empleado por venta tiene su propio archivo de
         * ventas, por lo que esta funcion simplemente agregara un nuevo
         * registro de venta a ese archivo ventas_cod.tbr. Formato:
         * 
         * -double venta
         * -long fecha en el momento de registro
         * -boolean si ya esta pagado (por default va en false)
         */
        try{
            RandomAccessFile rVenta;
            
            if( buscarTrabajador(cod) ){
                TipoEmpleado tipo = TipoEmpleado.valueOf(rTrab.readUTF());
                String n = rTrab.readUTF();
                
                if( tipo == TipoEmpleado.PORCOMISION ){
                    //agregar el registro
                    rVenta = new RandomAccessFile("ventas/venta_"+cod+".tbr","rw");
                    rVenta.seek(rVenta.length());
                    
                    System.out.printf("Actualizando venta a %s...\n\n",n);
                    //venta
                    rVenta.writeDouble(vent);
                    //la hora
                    rVenta.writeLong(new Date().getTime());
                    //pagado o no
                    rVenta.writeBoolean(false);
                }
                else
                    System.out.println("No es de Tipo Comision");
            }
            else
                System.out.println("No existe empleado");
            
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void setFechaNacimiento(int cod, Date fecha) {
        /*
         * TODO:
         * Buscar el empleado con ese codigo y actualizar la fecha
         * de nacimiento con ese dato
         */
        try{
            if( buscarTrabajador(cod) ){
                rTrab.readUTF();//tipo
                String n = rTrab.readUTF();
                rTrab.readInt(); //ihss
                
                System.out.printf("Actualizando Fecha nacimiento a %s...\n",n);
                rTrab.writeLong(fecha.getTime());
            }
            else
                System.out.println("No existe empleado");
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void setIhss(int cod, int codIhss) {
        /**
         * TODO:
         * Buscar el empleado con ese codigo y actualizar su dato
         * de IHSS
         */
        try{
            if( buscarTrabajador(cod) ){
                rTrab.readUTF();//tipo
                String n = rTrab.readUTF();
                
                System.out.printf("Actualizando IHSS a %s...\n",n);
                rTrab.writeInt(codIhss); //ihss
            }
            else
                System.out.println("No existe empleado");
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void longevo() {
        /**
         * Evaluar todo los empleados, e imprimir el empleado con mayor
         * edad dentro de la empresa. Los empleados que tengan como -1
         * en su dato de fecha de nacimiento no seran utilizados.
         */
        try{
            rTrab.seek(0);
            
            int codOld = -1;
            String nOld = "";
            Date edad = new Date();
            
            while(rTrab.getFilePointer() < rTrab.length() ){
                int cod = rTrab.readInt();
                rTrab.readUTF(); //tipo
                String n = rTrab.readUTF();
                rTrab.readInt(); //ihss
                Date fechanac = new Date( rTrab.readLong() ); //fecha nac
                
                if( fechanac.before(edad) ){
                    codOld = cod;
                    nOld = n;
                    edad = fechanac;
                }
                
                //movernos hasta el final del registro
                rTrab.seek(rTrab.getFilePointer()+ 24);
            }
            
            if( codOld != -1 ){
                System.out.printf("El empleado mas viejito es %d-%s que nacio en %s\n\n",
                        codOld, nOld, edad);
            }
            else
                System.out.println("No se tiene empleados con fechas de nacimiento");
            
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void mayorVendedor(){
        /*
         * TODO:
         * Imprime los datos del empleado por comision con el mayor
         * registro de ventas en la historia de la empresa.
         */
        try{
            rTrab.seek(0);
            double venta = 0;
            String nMayor = "";
            int codMayor = -1;
            
            while(rTrab.getFilePointer() < rTrab.length()){
                int cod = rTrab.readInt();
                TipoEmpleado tipo = TipoEmpleado.valueOf(rTrab.readUTF()); //tipo
                String n = rTrab.readUTF();//nombre
                //avanzar hasta el final
                rTrab.seek(rTrab.getFilePointer() + 36);
                
                if( tipo == TipoEmpleado.PORCOMISION ){
                    double total = ventasPorEmpleado(cod);
                    
                    if( total > venta ){
                        codMayor = cod;
                        nMayor = n;
                        venta = total;
                    }
                }
            }
            
            if( codMayor != -1 ){
                System.out.printf("El Mayor vendedor es %d-%s con %f\n\n",
                        codMayor, nMayor, venta);
            }
            else
                System.out.println("No hay empleados por venta o no se ha vendido nada\n\n");
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private double pagoPorHoras(double horasT) {
        double hn = 40, he = 0;
        
        if( horasT < 40 )
            hn = horasT;
        else
            he = (horasT - 40 );
        
        double phn = hn * EmpleadoPorHora.PAGO_HORA_NORMAL;
        double phe = he * EmpleadoPorHora.PAGO_HORA_EXTRA;
        
        return phn + phe;
    }

    private double comisionPendiente(int cod, double tasa)throws IOException {
        /*
         * TODO:
         * 1- Abrir el archivo de ventas para ese empleado
         *    recordar que es ventas_cod.tbr
         * 
         *   double ventas
         *   long fecha registro
         *   boolean pagada o no
         * 
         * 2- Recorren el archivo y van acumulando el total
         *   de ventas que no han sido pagadas aun
         * 3-Retornan ese total de ventas * la tasa
         */
        RandomAccessFile rVenta = new RandomAccessFile("ventas/venta_" + cod + ".tbr" , "rw");
        double total = 0;
        
        while(rVenta.getFilePointer() < rVenta.length() ){
            double v = rVenta.readDouble();
            rVenta.readLong();
            if( !rVenta.readBoolean() )
                total += v;
        }
        
        return total * tasa;
    }

    private double ventasPorEmpleado(int cod)throws IOException {
        RandomAccessFile rVenta = new RandomAccessFile("ventas/venta_" + cod + ".tbr" , "rw");
        double total = 0;
        
        while(rVenta.getFilePointer() < rVenta.length() ){
            total += rVenta.readDouble();
            rVenta.readLong();
            rVenta.readBoolean();
        }
        return total;
    }
    
}
