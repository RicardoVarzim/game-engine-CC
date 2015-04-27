/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import BusinessEntities.UserBE;
import BusinessObjects.*;
import Commands.PDU;
import Commands.ServerCommandFactory;

public class ServerBusinessLayer {
    
    //create an object of SingleObject
    private static ServerBusinessLayer instance = new ServerBusinessLayer();
    //Factory
    private static ServerCommandFactory factory ;
    //GlobalVars
    private GameBO _gameBO;
    private UserBO _userBO;
    
    //make the constructor private so that this class cannot be instantiated
    private ServerBusinessLayer(){
        this._gameBO = new GameBO();
        this._userBO = new UserBO();
        this.factory = new ServerCommandFactory();
    }

    //Get the only object available
    public static ServerBusinessLayer getInstance(){
        return instance;
    }
    
    public PDU hello(){
        return factory.Hello();
    }
    
    public PDU register(UserBE user){
        
        if(_userBO.validUsername(user)){
   
            _userBO.create(user);
            return factory.Register(true);
        }  
        return factory.Register(false);
    }

    public PDU login(UserBE user) {
        int id = _userBO.login(user);
        if(id>=0){
            
            user = (UserBE) _userBO.get(id);
            user.setLoggedIn(true);
            _userBO.update(user);
            
            return factory.Login(true);
        }
        return factory.Login(false);
    }
}
