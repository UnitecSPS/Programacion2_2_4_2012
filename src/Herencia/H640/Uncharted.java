/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public final class Uncharted implements IPlaystation, IOnline{

    @Override
    public int maxButtons() {
        return 6;
    }

    @Override
    public void loadGame() {
        System.out.println("Loading..Uncharted 3");
    }

    @Override
    public int maxPlayers() {
        return 2;
    }

    @Override
    public String getGameTitle() {
        return "Uncharted 3: Drake's Deception";
    }

    @Override
    public String getServer() {
        return "naughty.dog.com";
    }

    @Override
    public void setUserIp(String ip) {
        System.out.println("ip: " + ip);
    }

    @Override
    public int maxOnlinePlayers() {
        return 24;
    }
    
    public void dog(){
        System.out.println("GUAUU");
    }
    
}
