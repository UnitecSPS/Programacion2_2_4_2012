/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class FIFA extends EASports implements IOnline {
    public FIFA(){
        super("Soccer");
    }

    @Override
    public int maxButtons() {
        return 5;
    }

    @Override
    public void loadGame() {
        System.out.println("Loading FIFA13...");
    }

    @Override
    public int maxPlayers() {
        return 12;
    }

    @Override
    public String getGameTitle() {
        return "FIFA 13";
    }

    @Override
    public String getServer() {
        return "easports.com/fifa";
    }

    @Override
    public void setUserIp(String ip) {
        System.out.println(ip);
    }

    @Override
    public int maxOnlinePlayers() {
        return 12;
    }
}
