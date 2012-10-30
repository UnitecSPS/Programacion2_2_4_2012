/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gotcha
 */
public class PlanIphone extends Plan {
    private String email;
    
    public PlanIphone(int n, String no, String e){
        super(n, no);
        email = e;
    }
    
    @Override
    public double pagoMensual(int cm, int cms){
        double plan = 22 * 19.9;
        return plan + (cm * 20) + (cms * 5);
    }
    
    @Override
    public String toString(){
        return super.toString() + " email=" + email;
    }
    
    public String getEmail(){
        return email;
    }
}
