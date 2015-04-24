/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Orders;

import Commands.*;
import Core.*;

/**
 *
 * @author Ricardo
 */
public class Register implements Order {

    private ServerBusinessLayer business;
    private PDU message;
    
    public Register(PDU message){
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
    }
    
    @Override
    public void execute() {
        business.register();
    }
    
}
