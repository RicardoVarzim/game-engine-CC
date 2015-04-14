/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import BusinessObjects.*;

public class BusinessLayer {
    
    //GlobalVars
    private GameBO _gameBO;
    private UserBO _userBO;
    
    //Commands
    public void hello(){
        System.out.println("Hello");
    }
    
    public void register(){
        System.out.println("register");
    }
}
