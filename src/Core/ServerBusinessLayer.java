/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import BusinessEntities.GameBE;
import BusinessEntities.QuestionBE;
import BusinessEntities.UserBE;
import BusinessObjects.*;
import Commands.PDU;
import Commands.CommandFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ServerBusinessLayer {
    
    //create an object of SingleObject
    private static ServerBusinessLayer instance = new ServerBusinessLayer();
    //Factory
    private static CommandFactory _factory ;
    //GlobalVars
    private GameBO _gameBO;
    private UserBO _userBO;
    private QuestionBO _questionBO;
    
    //make the constructor private so that this class cannot be instantiated
    private ServerBusinessLayer(){
        this._gameBO = new GameBO();
        this._userBO = new UserBO();
        this._questionBO = new QuestionBO();
        this._factory = new CommandFactory();
    }

    //Get the only object available
    public static ServerBusinessLayer getInstance(){
        return instance;
    }

    
        /** PUBLIC COMMANDS**/
    public PDU hello(){
        return _factory.Hello();
    }
    
    public PDU register(UserBE user){
        
        if(_userBO.validUsername(user)){
   
            _userBO.create(user);
            return _factory.Register(true);
        }  
        return _factory.Register(false);
    }

    public PDU login(UserBE user) {
        int id = _userBO.login(user);
        if(id>=0){
            
            user = (UserBE) _userBO.get(id);
            user.setLoggedIn(true);
            _userBO.update(user);
            
            return _factory.Login(true,id);
        }
        return _factory.Login(false,0);
    }

    public PDU MakeChallenge(GameBE game) {
        
        //TODO: VERIFICAR nome jogo
        ArrayList<QuestionBE> list = (ArrayList<QuestionBE>) _questionBO.getAll();
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
        
        for (int i = 0; i < 10; i++) {
            game.addQuestion((list.get(i)).id);
        }
        //guardar no bo
        _gameBO.create(game);
        
        return _factory.MakeChallenge(true);
    }

    public ArrayList<String> getListChallenges() {
        ArrayList<String> result = new ArrayList<>();
        DateParser parser = new DateParser();
        for(GameBE item:_gameBO.getAll()){
            result.add(item.getName()+"\t"+parser.calendarToString(item.getStartDate()));
        }
        return result;
    }
    
    public PDU Accept_challenge(String game, int user)
    {
        GameBE temp =_gameBO.getByName(game);
        temp.addUser(user);
        _gameBO.update(temp);
        return _factory.Accept_challenge(true,game);
    }
    
      public PDU Delete_challenge(GameBE game)
    {
        GameBE temp =_gameBO.getByName(game.getName());
       _gameBO.delete(temp);
        return _factory.Delete_challenge(true);
    }

    public PDU logout(short label) {
        
        return _factory.logout(true,label);
    }

    public PDU retransmitGame(String gName) {
        GameBE game = _gameBO.getByName(gName);
        ArrayList<QuestionBE> questionlist = new ArrayList<>(10);
        for(int id : game.getQuestions()){
           questionlist.add(_questionBO.get(id)); 
        }
        return _factory.retransmitGame(game,questionlist);
    }
}
