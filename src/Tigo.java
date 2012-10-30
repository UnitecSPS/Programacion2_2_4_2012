
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gotcha
 */
public class Tigo {
    static ArrayList<Plan> planes;
    
    public static void main(String args[]){
        planes = new ArrayList<Plan>();
        addPlan(9993,"Carlos","IPHONE");
        addPlan(9994,"Ramon","BLACKBERRY");
        addPlan(9995,"Denis","IPHONE");
        addPlan(9996,"oscar","BLACKBERRY");
        
        if( busqueda(9997,"88","IPHONE"))
            System.out.println("SI");
        else
            System.out.println("NO");
        
        double pago = pagoMensual(9995, 34,67);
    }

    private static void addPlan(int c, String no, String tipo) {
        Scanner lea = new Scanner(System.in);
        
        if( tipo.equals("IPHONE") ){
            String email = lea.next();
            
            planes.add( new PlanIphone(c,no,email));
        }
        else if( tipo.equals("BLACKBERRY")){
            String pin = lea.next();
            
            planes.add( new PlanBlackBerry(c,no, pin));
        }
        else
            System.out.println("NO EXISTE");
    }

    private static boolean busqueda(int num, String extra, String tipo) {
        return busqueda(num,extra,tipo,0);
        
    }

    private static boolean busqueda(int num, String extra, String tipo, int pos) {
        if( pos < planes.size()){
            Plan plan = planes.get(pos);
            if( plan.getNumero() == num )
                return true;
            else{
                //miremos el extra
                if( plan instanceof PlanIphone){
                    if( ((PlanIphone)plan).getEmail().equals(extra) )
                        return true;
                }
                else{
                    if( ((PlanBlackBerry)plan).getPin().equals(extra))
                        return true;
                }
                
                return busqueda(num, extra, tipo, pos +1);
            }
        }
        return false;
    }

    private static double pagoMensual(int nt, int cm, int cms) {
        for(Plan p : planes){
            if( p.getNumero() == nt ){
                return p.pagoMensual(cm, cms);
            }
        }
        return 0;
    }
    
    
}
