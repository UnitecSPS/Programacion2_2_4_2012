/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLa2;

public class Twitter extends SocialClass{

    public Twitter(String username){
        super(username);
    }
    
    @Override
    public void viewMyInfo() {
        System.out.println("Username: " + this.username);
        System.out.println("POSTS:");
        for(String s: posts){
            System.out.println(s);
        }
    }
    
}
