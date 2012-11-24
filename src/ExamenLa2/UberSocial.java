/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLa2;

import java.util.ArrayList;
import java.util.Scanner;


public class UberSocial {
    private static ArrayList<SocialClass> redes;
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        redes = new ArrayList<SocialClass>();
        int op=7;
        
        do{
            System.out.println("1- Agregar Cuenta");
            System.out.println("2- Agragar Amigo");
            System.out.println("3- Agregar Post (No estaba en el examen)");
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
        System.out.println("Ingrese su nombre de usuario");
        String user1 = lea.next();
        System.out.println("Ingrese el nombre de usuario del amigo");
        String user2 = lea.next();
        
        //se lo vamos a agregar al primero que encuentr con ese user
        for(SocialClass sc : redes){
            if(sc.username.equals(user1) ){
                //busquemos el 2do y que sea del mismo tipo
                for(SocialClass sc2 : redes ){
                    if( sc2.username.equals(user2)){
                        //miremos si son del mismo tipo
                        if(sc instanceof Facebook && sc2 instanceof Facebook){
                            sc.addFriend(user2);
                            sc2.addFriend(user1);
                            return;
                        }
                        else if(sc instanceof Twitter && sc2 instanceof Twitter){
                            sc.addFriend(user2);
                            return;
                        }    
                    }
                }
            }
        }
    }
    
    public static void agregarComentario() throws NoPostException{
        System.out.print("Ingrese el Facebook username del duenio del post");
        String user = lea.next();
        SocialClass sc = buscarCuentaPorTipo("FACEBOOK", user);
        
        if( sc != null ){
            System.out.println("ID Post: ");
            int postid = lea.nextInt();
            System.out.println("Mensaje: ");
            String m = lea.next();
            
            ((Facebook)sc).addComment(postid, m);
        }
        else
            System.out.println("NO SE ENCONTRO EL USUARIO");
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
        System.out.print("Ingrese el username: ");
        String user = lea.next();
        
        //al primero que encontremos
        for(SocialClass sc : redes){
            if( sc.username.equals(user)){
                System.out.println("Mensaje de Post: ");
           
                sc.crearPost(lea.next());
            }
        }
    }
    
    public static void verUserInfo(){
        System.out.print("Ingrese el username: ");
        String user = lea.next();

        //al primero que encontremos
        for(SocialClass sc : redes){
            if( sc.username.equals(user)){
                sc.viewMyInfo();
            }
        }
    }
}