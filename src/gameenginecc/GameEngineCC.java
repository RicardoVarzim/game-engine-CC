package gameenginecc;

import UDPServer.*;

public class GameEngineCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UDPServer server = new UDPServer(9000);
        new Thread(server).start();

        //System.out.println("Stopping Server");
        //TODO: server.stop();
    }
    
}
