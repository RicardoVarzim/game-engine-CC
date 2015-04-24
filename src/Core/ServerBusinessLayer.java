/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import BusinessObjects.*;

public class ServerBusinessLayer {
    
    //create an object of SingleObject
    private static ServerBusinessLayer instance = new ServerBusinessLayer();
    //GlobalVars
    private GameBO _gameBO;
    private UserBO _userBO;
    
    //make the constructor private so that this class cannot be instantiated
    private ServerBusinessLayer(){
        this._gameBO = new GameBO();
        this._userBO = new UserBO();
    }

    //Get the only object available
    public static ServerBusinessLayer getInstance(){
        return instance;
    }
    
    public void hello(){
        System.out.println("Hello");
    }
    
    public void register(){
        System.out.println("register");
    }
}
