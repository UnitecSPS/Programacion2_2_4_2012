/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

/**
 *
 * @author Gotcha
 */
public interface iCollection {
    TipoColeccion getTipo();
    void agregar(Object ob) throws ValorMaloException;
    Object sacarElemento(int indi);
}
