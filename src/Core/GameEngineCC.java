package Core;

import Commands.CommandBroker;
import Commands.CommandFactory;
import Commands.Orders.*;
import UDPClient.UDPClient;
import UDPServer.*;

public class GameEngineCC {

    static UDPClient udpClient;
    static UDPServer udpServer;
    static BusinessLayer business;
    static CommandFactory pduFactory ;
    //static Util util;
    
    public static void main(String[] args) {
        
        pduFactory = new CommandFactory();
                
        business = BusinessLayer.getInstance();
        //Initialize Server
        udpServer = new UDPServer(9875);
        new Thread(udpServer).start();

        //Initialize Client
        udpClient = new UDPClient(pduFactory.Hello());
        new Thread(udpClient).start();
        
        

        
        
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
