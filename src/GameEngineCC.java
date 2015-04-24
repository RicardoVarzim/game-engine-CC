


import Commands.*;
import Core.*;
import UDPClient.*;
import UDPServer.*;
import static java.lang.Thread.sleep;

public class GameEngineCC {

    static UDPClient udpClient;
    static UDPServer udpServer;
    //static Util util;
    
    public static void main(String[] args) throws InterruptedException {
        
        
        //Initialize Server
        udpServer = new UDPServer(9875);
        new Thread(udpServer).start();
        
        //TODO INICIALIZAR GUI{
        
            ClientCommandFactory clientFactory = new ClientCommandFactory();        
        
            //Initialize Client
            udpClient = new UDPClient(clientFactory.Hello());
            new Thread(udpClient).start();
            
            sleep(10000);
            //Initialize Client
            udpClient = new UDPClient(clientFactory.Register());
            new Thread(udpClient).start();
            
            sleep(10000);
            //Initialize Client
            udpClient = new UDPClient(clientFactory.Register());
            new Thread(udpClient).start();
            
        //}
        
        
        
        

        
        
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
