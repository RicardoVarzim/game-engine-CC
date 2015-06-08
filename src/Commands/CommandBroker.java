package Commands;


import Commands.ServerOrders.*;
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
    
    public synchronized PDU execute(PDU p){
        Order order = PDUConverter(p);
        return order.execute();
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
        if(message.type == (byte)3){
            result = new Login(message);
        }
        if(message.type == (byte)4){
            result = new Logout(message);
        }
        if(message.type == (byte)5){
            result = new Quit(message);
        }
        if(message.type == (byte)6){
            result = new End(message);
        }
        if(message.type == (byte)7){
            result = new List_challenges(message);
        }
        if(message.type == (byte)8){
            result = new Make_challenge(message);
        }  
        if(message.type == (byte)9){
            result = new Accept_challenge(message);
        }  
        if(message.type == (byte)10){
            result = new Delete_challenge(message);
        }
        if(message.type == (byte)11){
            result = new Answer(message);
        }
        if(message.type == (byte)12){
            result = new Retransmit(message);
        }
        if(message.type == (byte)13){
            result = new List_ranking(message);
        }
        
        return result;
    }
}
