package UDPServer;

import Commands.CommandBroker;
import Commands.PDU;
import Core.BusinessLayer;
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
    
    static CommandBroker broker ;
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
                broker = CommandBroker.getInstance();
                broker.takeOrder(broker.PDUConverter(message));
                //RUN BROKER
                broker.placeOrders();

                
                //Response
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(message);
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
