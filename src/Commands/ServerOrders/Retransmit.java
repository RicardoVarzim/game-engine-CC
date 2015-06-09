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

/**
 *
 * @author Ricardo
 */
public class Retransmit implements Order {
    
    private ServerBusinessLayer business;
    private PDU message;
    private CommandFactory factory;
    
    public Retransmit(PDU message) {
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
        this.factory = new CommandFactory();
    }

    @Override
    public PDU execute() {
        ArrayList<String> fields = message.getFields();
        String game = fields.get(0);
        int idquestion = Integer.valueOf(fields.get(1));
        int iDblock = Integer.valueOf(fields.get(2));
        return business.retransmit(game,idquestion,iDblock);
    }
    
}
