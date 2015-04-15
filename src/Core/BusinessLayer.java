/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import BusinessObjects.*;

public class BusinessLayer {
    
    //create an object of SingleObject
    private static BusinessLayer instance = new BusinessLayer();
    //GlobalVars
    private GameBO _gameBO;
    private UserBO _userBO;
    
    //make the constructor private so that this class cannot be instantiated
    private BusinessLayer(){
        this._gameBO = new GameBO();
        this._userBO = new UserBO();
    }

    //Get the only object available
    public static BusinessLayer getInstance(){
        return instance;
    }
    
    //Commands
    public void hello(){
        System.out.println("Hello");
    }
    
    public void register(){
        System.out.println("register");
    }
}
