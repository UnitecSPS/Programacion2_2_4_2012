/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

/**
 *
 * @author Gotcha
 */
public class ColeccionEntera extends MiColeccion 
            implements iCollection, iCollActions {

    @Override
    public TipoColeccion getTipo() {
        return TipoColeccion.INTEGER;
    }

    @Override
    public void agregar(Object ob) throws ValorMaloException {
        if( ob instanceof Integer )
            elementos.add(ob);
        else
            throw new ValorMaloException();
    }

    @Override
    public Object sacarElemento(int indi) {
        return elementos.get(indi);
    }

    @Override
    public boolean buscarElemento(Object val) {
        try{
            if( val instanceof Integer ){
                for(Object ele : elementos){
                    if(ele == val)
                        return true;
                }
            }
        }catch(Exception e){}
        return false;
    }
    
}
