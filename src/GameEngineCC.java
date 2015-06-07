import UDPServer.*;

public class GameEngineCC {


    static UDPServer udpServer;
    //static Util util;
    
    public static void main(String[] args) throws InterruptedException {
        
        
        //Initialize Server
        udpServer = new UDPServer(9875);
        new Thread(udpServer).start();
        
        
      
    }
    
}
