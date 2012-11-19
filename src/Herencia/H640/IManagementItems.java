/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public interface IManagementItems {
    public void agregarItem(TipoItem tipo);
    public Item buscar(int codigo);
    public double rentar(int codigo, int dias)throws InvalidDaysException;
    public void imprimir();
    public void CambiarEstadoPelicula(int cod, boolean isKid);
}
