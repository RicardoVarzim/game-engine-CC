package BusinessObjects;

import BusinessEntities.UserBE;
import java.util.ArrayList;
import java.util.List;

public class UserBO implements BusinessObject<UserBE>  {
    
    List<UserBE> users;

    public UserBO(){
        users = new ArrayList<UserBE>();
       
        //Beta Testers
        UserBE user1 = new UserBE("Robert","213");
        UserBE user2 = new UserBE("John","123");
        create(user1);
        create(user2);		
    }

    @Override
    public synchronized UserBE create(UserBE o) {
        o.id = users.size();
        users.add(o);
        return o;
    }

    @Override
    public synchronized Object get(int id) {
        return users.get(id);
    }

    @Override
    public synchronized List<UserBE> getAll() {
        return users;
    }

    @Override
    public synchronized void update(UserBE o) {
        users.add(o.getId(),o);
    }

    @Override
    public void delete(UserBE o) {
        users.remove(o.getId());
    }
    
    //METODOS AUXILIARES DE CLASSE
    
    public boolean validUsername(UserBE o){
        String username = o.getName();
        
        for(UserBE user : users){
            if(user.getName()== username)
                return false;
        }
        return true;
    }
   
}