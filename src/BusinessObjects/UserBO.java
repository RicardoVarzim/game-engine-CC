package BusinessObjects;

import BusinessEntities.UserBE;
import java.util.ArrayList;
import java.util.List;

public class UserBO implements BusinessObject<UserBE>  {
    
    List<UserBE> users;
    int nextId;

    public UserBO(){
        users = new ArrayList<UserBE>();
        nextId = 0;
        //Beta Testers
        UserBE user1 = new UserBE("Robert","213");
        UserBE user2 = new UserBE("John","123");
        create(user1);
        create(user2);		
    }

    @Override
    public synchronized UserBE create(UserBE o) {
        o.id = nextId;
        users.add(o);
        nextId = nextId++;
        return o;
    }

    @Override
    public synchronized UserBE get(int id) {
        return users.get(id);
    }

    @Override
    public synchronized List<UserBE> getAll() {
        return users;
    }

    @Override
    public synchronized void update(UserBE o) {
        users.get(o.id).update(o);
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
    
    public int login(UserBE o){
        String username = o.getName();
        String password = o.getPassword();
        
        for(UserBE user : users){
            if(user.getName() == username && user.getPassword() == password)
                return user.id;
        }
        return -1;
    }
   
}