package BusinessObjects;

import BusinessEntities.GameBE;
import java.util.ArrayList;
import java.util.List;

public class GameBO implements BusinessObject<GameBE>  {
    
    List<GameBE> games;
    int nextId;
    
    public GameBO(){
       games = new ArrayList<>();    
       nextId = 0;
    } 

    @Override
    public synchronized GameBE create(GameBE o) {
        o.id = nextId;
        games.add(o);
        nextId = nextId++;
        return o;
    }

    @Override
    public synchronized GameBE get(int id) {
        return games.get(id);
    }

    @Override
    public synchronized List<GameBE> getAll() {
        return games;
    }

    @Override
    public synchronized void update(GameBE o) {
        games.add(o.getId(), o);
    }

    @Override
    public synchronized void delete(GameBE o) {
        games.remove(o.getId());
    }
    
    public synchronized GameBE getByName(String name){
        for(GameBE game: games){
            if(game.getName() == name)
                return game;
        }
        
    }
    
}
