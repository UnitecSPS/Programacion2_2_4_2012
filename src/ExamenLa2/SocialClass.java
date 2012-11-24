/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLa2;

import java.util.ArrayList;

public abstract class SocialClass {
    protected ArrayList<String> friends;
    protected ArrayList<String> posts;
    protected String username;
    
    public SocialClass(String username){
        this.username = username;
        friends = new ArrayList<String>();
        posts = new ArrayList<String>();
    }
    
    public final void addFriend(String user){
        //si el arreglo tiene ese amigo o si es a el mismo!
        if( friends.contains(user) || user.equals(username)){
            throw new FriendExistException();
        }
        friends.add(user);
        
        //----NO NECESARIO-----------
        System.out.printf("Agregado %s a la cuenta de %s de tipo %s\n\n"
                ,user,username,this.getClass().toString());
        //geClass() retornar el nombre de la clase con que fue instanciado.       
    }
    
    public abstract void viewMyInfo();
    
    public void crearPost(String message){
        posts.add(message);
    }
}
