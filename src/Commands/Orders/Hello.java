/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Orders;

import Commands.*;
import Core.*;

/**
 *
 * @author Ricardo
 */
public class Hello implements Order {

    private BusinessLayer business;
    
    public Hello(BusinessLayer b){
        this.business = b;
    }
    
    @Override
    public void execute() {
        business.hello();
    }
    
}