package Builder;

import BusinessEntities.GameBE;

public class GameBuilder {
    
    public GameBE prepareGame(String name){
        GameBE game = new GameBE(name);
        return game;
    }
    
}
