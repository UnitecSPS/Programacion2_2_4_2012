/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public class FinalFantasy implements IPlaystation {

    @Override
    public int maxButtons() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void loadGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int maxPlayers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getGameTitle() {
        return "Final Fintasy";
    }
    
}
