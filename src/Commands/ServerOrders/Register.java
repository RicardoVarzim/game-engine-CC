/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import BusinessEntities.UserBE;
import Commands.*;
import Core.*;

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
        UserBE user = new UserBE(message.fields.get(0),message.fields.get(1));
        return business.register(user);
    }
    
}
