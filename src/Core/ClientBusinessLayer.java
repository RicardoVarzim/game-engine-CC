package Core;

import BusinessEntities.UserBE;
import BusinessObjects.*;
import Commands.ClientCommandFactory;
import Commands.PDU;
import UDPClient.UDPClient;

public class ClientBusinessLayer {
    
    //create an object of SingleObject
    private static ClientBusinessLayer instance = new ClientBusinessLayer();
    //staticClasses
    static UDPClient udpClient;
    //GlobalVars
    private GameBO _gameBO;
    private UserBO _userBO;
    
    //make the constructor private so that this class cannot be instantiated
    private ClientBusinessLayer(){
        this._gameBO = new GameBO();
        this._userBO = new UserBO();
    }

    //Get the only object available
    public static ClientBusinessLayer getInstance(){
        return instance;
    }
    
    public void hello(){
        ClientCommandFactory factory = new ClientCommandFactory();
        udpClient = new UDPClient(factory.Hello());
        new Thread(udpClient).start();
    }
    
    public void register(UserBE user){
        ClientCommandFactory factory = new ClientCommandFactory();
        udpClient = new UDPClient(factory.Register(user));
        new Thread(udpClient).start();
    }
    
    public void login(UserBE user){
        ClientCommandFactory factory = new ClientCommandFactory();
        udpClient = new UDPClient(factory.Login(user));
        new Thread(udpClient).start();
    }
	
}
