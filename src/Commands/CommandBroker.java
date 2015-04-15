package Commands;

import Commands.Orders.Hello;
import Core.BusinessLayer;
import java.util.ArrayList;
import java.util.List;

public class CommandBroker {
    
    private List<Order> orderList = new ArrayList<Order>(); 

    public void takeOrder(Order order){
        orderList.add(order);		
    }

    //PDU to Order
    public void takeOrder(PDU p){
        
    }
    
    public void placeOrders(){
   
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    } 
    
    public Order PDUConverter(PDU p, BusinessLayer business){
        Order result = null;
                
        if(p.type == (byte)0){
            result = new Hello(business);
        }
             
        return result;
    }
}
