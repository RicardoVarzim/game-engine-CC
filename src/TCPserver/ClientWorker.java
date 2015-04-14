package TCPserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

class ClientWorker implements Runnable {
    
    private Socket client;
    //private Facade facade;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    //Constructor
    ClientWorker(Socket client) 
    {
        this.client = client;
    }
    
    public void run()
    {
        //Command cmd = null;
        
        try{
            in = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());
        } catch (IOException e) {
            System.out.println("in or out failed");
            System.exit(-1);
        }

        //messageHandler = new MessageHandler(facade);
        
        while(true){
            try{
//                cmd = (Command) in.readObject();
//                System.out.println("Incoming Command:" + cmd.type);
//                messageHandler.hasResponse = false;
//                cmd = messageHandler.ResolveMessage(cmd);
//                
//                if(messageHandler.hasResponse){
//                    System.out.println("Outcoming Result:" + cmd.type);
//                    out.writeObject(cmd);
//                    out.flush();
//                }
                
            }catch (Exception e) {
                System.out.println("Read failed: " + e.getMessage())   ;
                break;
            }
        }
        
        finalize();
    }
    
    public void sendNotification(ArrayList<String> notifications){
        try{
            //Command temp = new Command("notify","",new Object[]{notifications});
            //out.writeObject(temp);
            out.flush();
        }catch(Exception e){
            System.out.println("Read failed: " + e.getMessage());
        }
        
    }
    
    protected void finalize(){
    //Objects created in run method are finalized when
    //program terminates and thread exits
        try{
            client.close();
        } catch (IOException e) {
            System.out.println("Could not close socket");
            System.exit(-1);
        }
    }
}