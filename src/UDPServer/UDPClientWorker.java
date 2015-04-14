package UDPServer;

import Core.BusinessLayer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClientWorker implements Runnable {
    
    private DatagramPacket receivePacket;
    private DatagramSocket serverSocket;
    private BusinessLayer business;

    
    UDPClientWorker(DatagramSocket serverSocket,DatagramPacket message){
        this.serverSocket = serverSocket;
        this.receivePacket = message;
    }
    
    @Override
    public void run() {
        
        try {
            
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println ("From: " + IPAddress + ":" + port);
            System.out.println ("Message: " + sentence);
            
            String capitalizedSentence = sentence.toUpperCase();
            
            byte[] sendData = capitalizedSentence.getBytes();
            
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
             
            serverSocket.send(sendPacket);
            
        } catch (IOException ex) {
            Logger.getLogger(UDPClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
