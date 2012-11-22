/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

/**
 *
 * @author Gotcha
 */
public final class ColeccionCaracter extends MiColeccion 
            implements iCollection, iCollActions{

    @Override
    public TipoColeccion getTipo() {
        return TipoColeccion.CHAR;
    }

    @Override
    public void agregar(Object ob) throws ValorMaloException {
        if(ob instanceof Character){
            elementos.add(ob);
        }
        else{
            throw new ValorMaloException();
        }
    }

    @Override
    public Object sacarElemento(int indi) {
        return elementos.get(indi);
    }

    @Override
    public boolean buscarElemento(Object val) {
        try{
            if( val instanceof Character ){
                for(Object o : elementos){
                    if( val == o )
                        return true;
                }
            }
        }
        catch(Exception e){}
        return false;
    }
    
    
    
}
