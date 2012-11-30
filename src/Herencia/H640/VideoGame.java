   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class VideoGame extends Item {
    
    private TipoConsola tipo;
    private int max_players;
    private String clasificacion;
    
    public VideoGame(int i, String n, int c,TipoConsola co){
        super(i,n, c);
        tipo = co;
    }
    
    @Override
    public double renta(int d)throws InvalidDaysException{
        if( d < 0 || d > 31 )
            throw new InvalidDaysException(d);
        
        //es porque cada dia renta es igual a 3 dias
        //ej lo llevo 6 dias , seria como que lo rentara 2 dias renta.
        if( copiasRenta> 0 ){
            int dias = d / 3;
            return tipo.getPrecio() * dias;
        }
        return 0;
    }

    public TipoConsola getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " tipo=" + tipo + '}';
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public int getMax_players() {
        return max_players;
    }
    
    /**
     * Configurar los datos restantes no inicializados en el
     * constructor
     * @param max Maximo de Jugadores
     * @param c Clasificacion del juego
     */
    public void setDemasDatos(int max, String c){
        max_players = max;
        clasificacion = c;
    }
}
