/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import Commands.CommandFactory;
import Commands.PDU;
import Commands.Order;
import Core.ServerBusinessLayer;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ricardo
 */
public class Delete_challenge implements Order {

    private ServerBusinessLayer business;
    private PDU message;
    private Commands.CommandFactory factory;
    
    public Delete_challenge(PDU message) {
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
        this.factory = new CommandFactory();
    }

    @Override
    public PDU execute() {
        
        try {
            return business.Accept_challenge(message.getFields().get(0), message.label);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Accept_challenge.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
