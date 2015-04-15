package Core;

import Commands.CommandBroker;
import Commands.Orders.*;
import UDPServer.*;

public class GameEngineCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Initialize Server
        UDPServer server = new UDPServer(9000);
        new Thread(server).start();

        BusinessLayer business = BusinessLayer.getInstance();

        
        
        //EXEMPLO COMMAND BROKER
//            Hello buyStockOrder = new Hello(business);
//            Register sellStockOrder = new Register(business);
//
//            CommandBroker broker = new CommandBroker();
//            broker.takeOrder(buyStockOrder);
//            broker.takeOrder(sellStockOrder);
//
//            broker.placeOrders();
      
        //System.out.println("Stopping Server");
        //TODO: server.stop();
    }
    
}
