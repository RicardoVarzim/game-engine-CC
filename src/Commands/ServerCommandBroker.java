package Commands;

import Commands.ServerOrders.*;
import BusinessObjects.GameBO;
import BusinessObjects.UserBO;
import Core.ServerBusinessLayer;
import java.util.ArrayList;
import java.util.List;

public class ServerCommandBroker {
    //create an object of SingleObject
    private static ServerCommandBroker instance = new ServerCommandBroker();
    
    private List<ServerOrder> _orderList ; 

    private ServerCommandBroker(){
        this._orderList = new ArrayList<ServerOrder>();
    }

    //Get the only object available
    public static ServerCommandBroker getInstance(){
        return instance;
    }
    
    public synchronized void takeOrder(ServerOrder order){
        _orderList.add(order);		
    }

    //PDU to Order
    public synchronized void takeOrder(PDU p){
        _orderList.add(PDUConverter(p));
    }
    
    public synchronized PDU execute(PDU p){
        ServerOrder order = PDUConverter(p);
        return order.execute();
    }
    public synchronized void placeOrders(){
   
        for (ServerOrder order : _orderList) {
            order.execute();
        }
        _orderList.clear();
    } 
    
    public ServerOrder PDUConverter(PDU message){
        ServerOrder result = null;
                
        if(message.type == (byte)1){
            result = new Hello(message);
        }
        if(message.type == (byte)2){
            result = new Register(message);
        }
        if(message.type == (byte)3){
            result = new Login(message);
        }
             
        return result;
    }
}
