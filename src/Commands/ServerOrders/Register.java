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
public class Register implements ServerOrder {

    private ServerBusinessLayer business;
    private PDU message;
    
    public Register(PDU message){
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
    }
    
    @Override
    public PDU execute() {
        try {
            ArrayList<String> fields = message.getFields();
            UserBE user = new UserBE(fields.get(0),fields.get(1));
            return business.register(user);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
