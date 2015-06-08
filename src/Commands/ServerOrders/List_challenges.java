/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import Commands.CommandFactory;
import Commands.PDU;
import Commands.Order;
import Core.DateParser;
import Core.ServerBusinessLayer;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class List_challenges implements Order {
    
    private ServerBusinessLayer business;
    private PDU message;
    private CommandFactory factory;
    
    public List_challenges(PDU message) {
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
        this.factory = new CommandFactory();
    }

    @Override
    public PDU execute() {
        ArrayList<String> list = business.getListChallenges();
        return factory.ListChallenge(list);
    }
    
}
