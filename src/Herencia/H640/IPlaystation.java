/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H640;

/**
 *
 * @author Gotcha
 */
public interface IPlaystation {
    double VERSION_XMB = 4.2;
    int maxButtons();
    void loadGame();
    int maxPlayers();
    String getGameTitle();
}
