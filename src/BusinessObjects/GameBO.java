package BusinessObjects;

import BusinessEntities.GameBE;
import java.util.ArrayList;
import java.util.List;

public class GameBO implements BusinessObject<GameBE>  {
    
    List<GameBE> games;
            
    public GameBO(){
       games = new ArrayList<>();     	
    } 

    @Override
    public synchronized GameBE create(GameBE o) {
        o.id = games.size();
        games.add(o);
        return o;
    }

    @Override
    public synchronized Object get(int id) {
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

}
