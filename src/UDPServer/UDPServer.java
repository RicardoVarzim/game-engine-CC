package UDPServer;

import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class UDPServer implements Runnable { 
  
    protected int port;
    
    public UDPServer(int port){
        this.port = port;
    }

    
    @Override
    public void run() {
        try
        { 
            DatagramSocket serverSocket = new DatagramSocket(port); 

            byte[] receiveData = new byte[1024]; 
            byte[] sendData  = new byte[1024]; 

            while(true) 
            { 
                receiveData = new byte[1024]; 

                DatagramPacket receivePacket = 
                   new DatagramPacket(receiveData, receiveData.length); 

                System.out.println ("Waiting for datagram packet");

                serverSocket.receive(receivePacket); 

                new Thread(new UDPClientWorker(serverSocket, receivePacket)).start();
            } 
        }
        catch (SocketException ex) {
            System.out.println("UDP Port "+port+" is occupied.");
            System.exit(1);
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}  

