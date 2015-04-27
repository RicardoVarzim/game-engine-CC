/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import BusinessEntities.UserBE;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ClientCommandFactory {
    
    public ClientCommandFactory(){
        
    }
    
    public PDU Hello(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)1,(byte)1,(short)1,new ArrayList<>());
        return command;
    }
    
    public PDU Register(UserBE user){
        ArrayList list = new ArrayList<String>();
        list.add(user.getName());
        list.add(user.getPassword());
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)2,(byte)1,(short)1, list);
        return command;
    }
    
    
     public PDU Login(UserBE user){
        ArrayList list = new ArrayList<String>();
        list.add(user.getName());
        list.add(user.getPassword());
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)3,(byte)1,(short)1, list);
        return command;
    }
     
}
