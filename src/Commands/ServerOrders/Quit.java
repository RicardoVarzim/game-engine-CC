/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import Commands.PDU;
import Commands.Order;

/**
 *
 * @author Ricardo
 */
public class Quit implements Order {

    public Quit(PDU message) {
    }

    @Override
    public PDU execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
