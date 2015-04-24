package UDPServer;

import Commands.ServerCommandBroker;
import Commands.PDU;
import Core.ServerBusinessLayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClientWorker implements Runnable {
    
    static ServerCommandBroker broker ;
    private DatagramPacket receivePacket;
    private DatagramSocket serverSocket;
    private ServerBusinessLayer business;
    
    
    UDPClientWorker(DatagramSocket serverSocket,DatagramPacket message){
        this.serverSocket = serverSocket;
        this.receivePacket = message;
    }
    
    @Override
    public void run() {
        
        try {
            
            //String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println ("From: " + IPAddress + ":" + port);
            //System.out.println ("Message: " + sentence);
            //String capitalizedSentence = sentence.toUpperCase();
            
            //GET PDU
            byte[] data = receivePacket.getData();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            
            try {
                
                PDU message = (PDU) is.readObject();
                System.out.println("PDU object received = "+message);
                //PDU TO BROKER
                broker = ServerCommandBroker.getInstance();
                PDU response = broker.execute(message);
                
                //broker.takeOrder(broker.PDUConverter(message));
                //RUN BROKER
                //broker.placeOrders();

                
                //Response
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(response);
                byte[] sendData = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

                serverSocket.send(sendPacket);
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(UDPClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
