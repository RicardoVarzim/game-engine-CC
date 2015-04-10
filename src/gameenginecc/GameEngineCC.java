/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameenginecc;

import server.Server;


/**
 *
 * @author Ricardo
 */
public class GameEngineCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server(9000);
        new Thread(server).start();

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }
    
}
