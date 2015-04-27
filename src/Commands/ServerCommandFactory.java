/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ServerCommandFactory {
    
    public ServerCommandFactory(){
        
    }
    
    public PDU Register(boolean sucess){
        PDU command;
        ArrayList<String> message = new ArrayList<>(1);
        
        if(sucess)
            message.add("NICE"); 
        else 
            message.add("BADD"); 
            
            command = new PDU((byte)0,(byte)0,(short)1,(byte)2,(byte)1,(short)1,message);
            
            
        return command;
    }
    
     public PDU Hello(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)1,(byte)1,(short)1,new ArrayList<>());
        return command;
    }
}
