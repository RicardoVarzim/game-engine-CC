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

/**
 *
 * @author Ricardo
 */
public class End implements Order {

    private ServerBusinessLayer business;
    private PDU message;
    private Commands.CommandFactory factory;
    
    public End(PDU message) {
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
        this.factory = new CommandFactory();
    }

    @Override
    public PDU execute() {
        
        return factory.End(true);
    }
    
}
