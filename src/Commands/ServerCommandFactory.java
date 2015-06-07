/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Core.ServerBusinessLayer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ServerCommandFactory {
    
    public ServerCommandFactory(){
        
    }

    /** COMMANDS **/
    public PDU Hello(){
        
        int labelGenerated = ServerBusinessLayer.getInstance().labelGen();
        PDU command = new PDU((byte)0,(byte)0,(short)labelGenerated,(byte)1,(byte)1,(short)1);
        
        return command;
    }
     
    public PDU Register(boolean sucess){
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess)
            message.add("Registo Efectuado!"); 
        else 
            message.add("ERRO! o username ja está em uso!"); 
            
            command = new PDU((byte)0,(byte)0,(short)1,(byte)2,(byte)1,(short)1,message);
            
            
        return command;
    }
   
     
     public PDU Login(boolean sucess){
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess)
            message.add("Welcome! Login Sucessful"); 
        else 
            message.add("Sorry! Wrong Username or password or both!"); 
            
            command = new PDU((byte)0,(byte)0,(short)1,(byte)3,(byte)1,(short)1,message);
            
            
        return command;
    }
}
