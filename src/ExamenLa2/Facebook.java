/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLa2;

import java.util.ArrayList;

public class Facebook extends SocialClass implements iComment{
    private ArrayList<Comment> comments;
    
    public Facebook(String username){
        super(username);
        comments = new ArrayList<Comment>();
    }
    
    @Override
    public void viewMyInfo() {
        System.out.println("Username: " + username);
        System.out.println("POSTS\n---------------");

        for(int p=0; p < posts.size(); p++){
            System.out.println(posts.get(p));
            for(Comment c: comments){
                if( c.postID == p)
                    System.out.println("\t" + c.message);
            }
        }
    }

    @Override
    public boolean addComment(int postID, String message) throws NoPostException {
        try{
            posts.get(postID);//si no existe me va tirar IndexOutOfBound
            comments.add( new Comment(postID, message));
        }catch(IndexOutOfBoundsException ex){
            throw new NoPostException();
        }
        return true;
    }
}
