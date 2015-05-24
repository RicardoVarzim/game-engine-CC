/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ClientOrders;

import Commands.ClientOrder;
import Commands.PDU;
import Core.ClientBusinessLayer;

/**
 *
 * @author Ricardo
 */
public class Logout implements ClientOrder {

    private ClientBusinessLayer business;
    private PDU message;
    
    public Logout(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        business.logout();
    }
    
}
