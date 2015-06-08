import Core.ServerBusinessLayer;
import UDPServer.*;

public class GameEngineCC {


    static UDPServer udpServer;
    //static Util util;
    
    public static void main(String[] args) throws InterruptedException {
        
        //Init BusinessLauyer
        ServerBusinessLayer business = ServerBusinessLayer.getInstance();
        //Initialize Server
        udpServer = new UDPServer(9875);
        new Thread(udpServer).start();
        
        
      
    }
    
}
