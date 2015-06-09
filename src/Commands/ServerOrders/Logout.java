/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import Commands.PDU;
import Commands.Order;
import Core.ServerBusinessLayer;

/**
 *
 * @author Ricardo
 */
public class Logout implements Order {
private ServerBusinessLayer business;
    private PDU message;
    public Logout(PDU message) {this.business = ServerBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public PDU execute() {
        return business.logout(message.label);
    }
    
}
