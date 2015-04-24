package Commands;

import BusinessObjects.GameBO;
import BusinessObjects.UserBO;
import Commands.Orders.*;
import Core.ServerBusinessLayer;
import java.util.ArrayList;
import java.util.List;

public class CommandBroker {
    //create an object of SingleObject
    private static CommandBroker instance = new CommandBroker();
    
    private List<Order> _orderList ; 

    private CommandBroker(){
        this._orderList = new ArrayList<Order>();
    }

    //Get the only object available
    public static CommandBroker getInstance(){
        return instance;
    }
    
    public synchronized void takeOrder(Order order){
        _orderList.add(order);		
    }

    //PDU to Order
    public synchronized void takeOrder(PDU p){
        _orderList.add(PDUConverter(p));
    }
    
    public synchronized void placeOrders(){
   
        for (Order order : _orderList) {
            order.execute();
        }
        _orderList.clear();
    } 
    
    public Order PDUConverter(PDU message){
        Order result = null;
                
        if(message.type == (byte)1){
            result = new Hello(message);
        }
        if(message.type == (byte)2){
            result = new Register(message);
        }
             
        return result;
    }
}
