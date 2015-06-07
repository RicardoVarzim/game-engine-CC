/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import BusinessEntities.UserBE;
import Commands.*;
import Core.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Login implements ServerOrder {

    private ServerBusinessLayer business;
    private PDU message;
    
    public Login(PDU message){
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
    }
    
    @Override
    public PDU execute() {
        UserBE user = new UserBE(null, null);
        try {
            ArrayList<String> fields = message.getFields();
            user = new UserBE(fields.get(0),fields.get(1));
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return business.login(user);
    }
    
}
