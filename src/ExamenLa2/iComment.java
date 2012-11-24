/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLa2;

public interface iComment {
    boolean addComment(int postID, String message) throws NoPostException;
}
