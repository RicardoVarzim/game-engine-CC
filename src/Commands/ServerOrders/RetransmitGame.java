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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class RetransmitGame implements Order {

    private ServerBusinessLayer business;
    private PDU message;
    private CommandFactory factory;
    
    public RetransmitGame(PDU message) {
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
        this.factory = new CommandFactory();
    }

    @Override
    public PDU execute() {
        try {
            ArrayList<String> fields = message.getFields();
            return business.retransmitGame(fields.get(0));
        } catch (Exception ex) {
            return factory.Erro();
        }
    }
    
}
