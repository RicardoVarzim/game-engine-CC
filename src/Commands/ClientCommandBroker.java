package Commands;

import Commands.ClientOrders.Register;
import Commands.ClientOrders.Hello;
import BusinessObjects.GameBO;
import BusinessObjects.UserBO;
import Core.ClientBusinessLayer;
import java.util.ArrayList;
import java.util.List;

public class ClientCommandBroker {
    //create an object of SingleObject
    private static ClientCommandBroker instance = new ClientCommandBroker();
    
    private List<ClientOrder> _orderList ; 

    private ClientCommandBroker(){
        this._orderList = new ArrayList<ClientOrder>();
    }

    //Get the only object available
    public static ClientCommandBroker getInstance(){
        return instance;
    }
    
    public synchronized void takeOrder(ClientOrder order){
        _orderList.add(order);		
    }

    //PDU to Order
    public synchronized void takeOrder(PDU p){
        _orderList.add(PDUConverter(p));
    }
    
    public synchronized void placeOrders(){
   
        for (ClientOrder order : _orderList) {
            order.execute();
        }
        _orderList.clear();
    } 
    
    public ClientOrder PDUConverter(PDU message){
        ClientOrder result = null;
                
        if(message.type == (byte)1){
            result = new Hello(message);
        }
        if(message.type == (byte)2){
            result = new Register(message);
        }
             
        return result;
    }
}
