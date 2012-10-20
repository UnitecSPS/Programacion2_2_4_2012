/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;

/**
 *
 * @author Gotcha
 */
public class TestTG1 {
    public static void main(String args[]){
        Recursiones rec = new Recursiones();
        
        rec.imprimir();
        
        System.out.println("\nSuma: " + rec.suma() );
        System.out.println("\nMayor: " + rec.mayor());
        System.out.println("\nCuantos divisibles pares: " + rec.divisibles(2));
        
        //Cadena
        String cad = "FC Barcelona";
        if( Recursiones.buscarEnCadena(cad, 'F'))
            System.out.println("Se encontro F");
        else
            System.out.println("No se encontro F");
        
        cad = "anitalavalatina";
        if( Recursiones.palindromo(cad) )
            System.out.println("Es Palindromo");
        else
            System.out.println("NO es Palindromo");
                
    }
}
