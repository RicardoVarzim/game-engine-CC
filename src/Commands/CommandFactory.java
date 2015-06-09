package Commands;

import Core.ServerBusinessLayer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class CommandFactory {
    
    public CommandFactory(){
        
    }

    /** COMMANDS **/
    public PDU Hello(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)0,(byte)1,(byte)1,(short)1);
        
        return command;
    }
     
    public PDU Register(boolean sucess){
        PDU command;
        ArrayList<String> message = new ArrayList<>();
        
        if(sucess){
            message.add("0");
        }
            
        else{
            message.add("255");
            message.add("ERRO! o username ja está em uso!"); 
        } 
            command = new PDU((byte)0,(byte)0,(short)1,(byte)2,(byte)1,(short)1,message);
            
            
        return command;
    }
   
     
     public PDU Login(boolean sucess, int idUser){
        PDU command;
        ArrayList<String> message = new ArrayList<>();
        
        if(sucess){
             message.add("0");
        }

        else{
             message.add("255");
             message.add("Sorry! Wrong Username or password or both!!");  
        }
        command = new PDU((byte)0,(byte)0,(short)1,(byte)3,(byte)1,(short)1,message);
        command.label = (short)idUser;
        
        return command;
    }
     
    public PDU MakeChallenge(boolean sucess){
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess){
             message.add("0");
             message.add("Challenge created");
        }
             
        else {
             message.add("255");
             message.add("Sorry! Something wrong");  
        }
            
        command = new PDU((byte)0,(byte)0,(short)1,(byte)4,(byte)1,(short)1,message);
            
        return command;
    }
    
    public PDU ListChallenge(ArrayList<String> challenges){
        PDU command;
        
        command = new PDU((byte)0,(byte)0,(short)1,(byte)5,(byte)challenges.size(),(short)1,challenges);
            
        return command;
    }

    public PDU End(boolean sucess) {
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        if(sucess){
             message.add("0");
             message.add("Challenge created");
        }
             
        else {
             message.add("255");
             message.add("Sorry! Something wrong");  
        }
            
        command = new PDU((byte)0,(byte)0,(short)1,(byte)6,(byte)1,(short)1,message);
            
        return command;
    }

    public PDU Erro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public PDU Accept_challenge(boolean sucess){
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess){
             message.add("0");
             message.add("Challenge accepted");
        }
             
        else {
             message.add("255");
             message.add("Sorry! Something wrong");  
        }
        
        command = new PDU((byte)0,(byte)0,(short)1,(byte)3,(byte)1,(short)1,message);
            
        return command;
    }

    public PDU logout(boolean sucess, short label) {
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess){
             message.add("0");
             message.add("Logout successful!");
        }
             
        else {
             message.add("255");
             message.add("Sorry! Something wrong");  
        }
        command = new PDU((byte)0,(byte)0,(short)1,(byte)3,(byte)1,(short)1,message);
        return command;
    }
    
}
