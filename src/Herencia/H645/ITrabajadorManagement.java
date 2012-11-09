/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

/**
 *
 * @author Gotcha
 */
public interface ITrabajadorManagement {
    void agregarEmpleado(Trabajador t);
    void imprimirPlanilla();
    boolean buscarTrabajador(int cod);
    double pagarATrabajador(int cod);
    void setHorasTrabajadas(int cod, int horast);
    void setVentas(int cod, double vent);
    void setFechaNacimiento(int cod, java.util.Date fecha);
    /*
     * TODO:
     * Agregar :
     * - Funcion para asignar el IHSS segun un codigo, y un valor
     * entero
     * - Funcion para asignar el Tipo de Jerarquia a un empleado segun
     * su codigo
     * - Trabajador longevo() = Funcion que me debera retornar
     *  un objeto trabajador el cual es el empleado con mas
     * edad dentro de la empresa (OJO NO QUIEN TIENE MAS TIEMPO
     * TRABAJANDO)
     * 
     * Actualizar la clase Empresa para que las llame a estas 2
     * y tambien el Main.java para llamarlas dentro del menu. Lo 
     * de IHSS, Tipo Jerarquia iria dentro de la opcion 4 (submenu) y la del
     * longevo creen una nueva opcion en el menu principal.
     * Impriman los datos del longevo!.
     */
}
