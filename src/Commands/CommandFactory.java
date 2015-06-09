package Commands;

import BusinessEntities.GameBE;
import BusinessEntities.QuestionBE;
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
            
        command = new PDU((byte)0,(byte)0,(short)1,(byte)8,(byte)1,(short)1,message);
            
        return command;
    }
    
    public PDU ListChallenge(ArrayList<String> challenges){
        PDU command;
        
        command = new PDU((byte)0,(byte)0,(short)1,(byte)7,(byte)challenges.size(),(short)1,challenges);
            
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
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        message.add("255");
        command = new PDU((byte)0,(byte)0,(short)1,(byte)0,(byte)1,(short)1,message);
        return command; 
    }
    
    public PDU Accept_challenge(boolean sucess,String game){
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess){
             message.add("0");
             message.add(game);
        }
             
        else {
             message.add("255");
             message.add("Sorry! Something wrong");  
        }
        
        command = new PDU((byte)0,(byte)0,(short)1,(byte)9,(byte)1,(short)2,message);
            
        return command;
    }
    
    public PDU Delete_challenge(boolean sucess){
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess){
             message.add("0");
             message.add("Challenge deleted");
        }
             
        else {
             message.add("255");
             message.add("Sorry! Something wrong");  
        }
        
        command = new PDU((byte)0,(byte)0,(short)1,(byte)10,(byte)1,(short)1,message);
            
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

    public PDU retransmitGame(GameBE game, ArrayList<QuestionBE> questionlist) {
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        message.add(game.getName());
        for(QuestionBE item : questionlist)
            message.add(item.toString());

        command = new PDU((byte)0,(byte)0,(short)1,(byte)3,(byte)1,(short)1,message);
        return command;
    }

    public PDU retransmit(int iDblock, byte[] block) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
