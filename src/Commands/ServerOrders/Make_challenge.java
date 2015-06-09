/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ServerOrders;

import BusinessEntities.GameBE;
import Commands.CommandFactory;
import Commands.PDU;
import Commands.Order;
import Core.DateParser;
import Core.ServerBusinessLayer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Make_challenge implements Order {
 
    private ServerBusinessLayer business;
    private PDU message;
    private DateParser parser;
    private CommandFactory factory;
    
    public Make_challenge(PDU message) {
        this.business = ServerBusinessLayer.getInstance();
        this.message = message;
        this.factory = new CommandFactory();
        this.parser = new DateParser();
    }

    @Override
    public PDU execute() {
        try {
            GameBE game;
            ArrayList<String> fields = message.getFields();
            game = new GameBE(fields.get(0));
            String data = fields.get(1);
            game.setStartDate(parser.stringToCalendar(data));
            
            return business.MakeChallenge(game);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Make_challenge.class.getName()).log(Level.SEVERE, null, ex);
            return factory.MakeChallenge(false);
        }

    }
    
}
