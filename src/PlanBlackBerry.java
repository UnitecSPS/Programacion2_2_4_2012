
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gotcha
 */
public class PlanBlackBerry extends Plan{
    private ArrayList<String> bbm;
    private String pin;
    
    public PlanBlackBerry(int n, String no, String p){
        super(n,no);
        pin = p;
        bbm = new ArrayList<String>();
    }
    
    @Override
    public double pagoMensual(int cm, int cms){
        double plan = 40 * 19.9;
        
        if( cm > 200 )
            plan += (cm - 200) * 15;
        if( cms > 300 )
            plan += (cms - 300) * 8;
        return plan;
    }
    
    @Override
    public String toString(){
        return super.toString() + pin;
    }
    
    public void agregarPin(String pin){
        for(String p : bbm){
            if( p.equals(pin) )
                return;
        }
        
        bbm.add(pin);
    }
    
    public String getPin(){
        return pin;
    }
            
}