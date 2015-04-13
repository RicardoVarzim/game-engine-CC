/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameenginecc;

import UDPServer.*;


/**
 *
 * @author Ricardo
 */
public class GameEngineCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //TODO: MUDAR PARA UDPServer
        
        UDPServer server = new UDPServer(9000);
        new Thread(server).start();

        //System.out.println("Stopping Server");
        //server.stop();
    }
    
}
