/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLa2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class UberSocial_640 {
    private static ArrayList<SocialClass> redes;
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        redes = new ArrayList<SocialClass>();
        int op=7;
        
        do{
            System.out.println("1- Agregar Cuenta");
            System.out.println("2- Agragar Amigo");
            System.out.println("3- Agregar Post");
            System.out.println("4- Agregar Comentario");
            System.out.println("5- Ver Info");
            System.out.println("6- Salir");
            System.out.print("Escoja Opcion: ");
  
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        agregarCuenta();
                        break;
                    case 2:
                        agregarAmigo();
                        break;
                    case 3:
                        agregarPost();
                        break;
                    case 4:
                        agregarComentario();
                        break;
                    case 5:
                        verUserInfo();
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }while(op != 6);
    }
        
    public static void agregarCuenta(){
        System.out.println("Ingrese el nombre de usuario");
        String user = lea.next();
        System.out.println("Ingrese el tipo de cuenta. FACEBOOK/TWITTER");
        String tipo = lea.next();

        SocialClass sc = buscarCuentaPorTipo(tipo.toUpperCase(), user);
        
        if( sc == null){//quiere decir que no se encontro
            if( tipo.toUpperCase().equals("FACEBOOK")){
                redes.add(new Facebook(user));
            }
            else if(tipo.toUpperCase().equals("TWITTER")){
                redes.add(new Twitter(user));
            }
        }
        else
            System.out.println("USUARIO YA EXISTE");       
    }
    
    public static void agregarAmigo(){
        System.out.println("Ingrese el id de usuario");
        int user1 = lea.nextInt();
        System.out.println("Ingrese el id de usuario del amigo");
        int user2 = lea.nextInt();
        
        try{
            SocialClass sc = redes.get(user1);
            SocialClass sc2 = redes.get(user2);
            
            if(sc instanceof Facebook && sc2 instanceof Facebook){
                sc.addFriend(sc2.username);
                sc2.addFriend(sc.username);
             }
             else if(sc instanceof Twitter && sc2 instanceof Twitter){
                sc.addFriend(sc2.username);
             }   
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Algunos de los usuarios no existen");
        }
    }
    
    public static void agregarComentario() throws NoPostException{
        System.out.print("Ingrese el id del usuario: ");
        int userID = lea.nextInt();
        
        try{
            SocialClass sc = redes.get(userID);

            if( sc instanceof Facebook ){
                System.out.println("ID Post: ");
                int postid = lea.nextInt();
                System.out.println("Mensaje: ");
                String m = lea.next();

                ((Facebook)sc).addComment(postid, m);
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("NO SE ENCONTRO EL USUARIO");
        }
    }
    
    private static SocialClass buscarCuentaPorTipo(String tipo, String username) {
        
        for(SocialClass s: redes){
            if((tipo.equals("FACEBOOK") && s instanceof Facebook) ||
               (tipo.equals("TWITTER") && s instanceof Twitter)){
                
                if(s.username.equals(username))
                    return s;
            }
        }
        return null;
    }

    private static void agregarPost() {
        System.out.print("Ingrese el id: ");
        int userID = lea.nextInt();
        
        try{
            System.out.println("Mensaje de Post: ");
            redes.get(userID).crearPost(lea.next());
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("NO SE ENCONTRO EL USUARIO");
        }
    }
    
    public static void verUserInfo(){
        System.out.print("Ingrese el id: ");
        int userID = lea.nextInt();

        try{
            redes.get(userID).viewMyInfo();          
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("NO SE ENCONTRO EL USUARIO");
        }
    }
}
