/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import Commands.PDU;
import Commands.ServerOrder;
import Core.ServerBusinessLayer;

/**
 *
 * @author Ricardo
 */
public class Accept_challenge implements ServerOrder {

    private ServerBusinessLayer business;
    private PDU message;
    
    public Accept_challenge(PDU message) {
    }

    @Override
    public PDU execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
