package BusinessObjects;

import BusinessEntities.UserBE;
import java.util.ArrayList;
import java.util.List;

public class UserBO  {
    List<UserBE> users;

   public UserBO(){
      users = new ArrayList<UserBE>();
      
      //Beta Testers
      UserBE user1 = new UserBE("Robert","213");
      UserBE user2 = new UserBE("John","123");
      users.add(user1);
      users.add(user2);		
   }
   public synchronized void deleteUser(UserBE user) {
      users.remove(user.getId());
      System.out.println("User: Roll No " + user.getId()+ ", deleted from database");
   }

   //retrive list of students from the database
   public synchronized List<UserBE> getAllUsers() {
      return users;
   }

   public synchronized UserBE getUser(int id) {
      return users.get(id);
   }

   public synchronized void updateName(UserBE user) {
      users.get(user.getId()).setName(user.getName());
      System.out.println("User: Roll No " + user.getId() +", updated in the database");
   }
   
   public synchronized void updateTotalScore(UserBE user) {
      users.get(user.getId()).setTotalScore(user.getTotalScore());
      System.out.println("User: Roll No " + user.getId() +", updated in the database");
   }
   
   public synchronized void updateInGame(UserBE user) {
      users.get(user.getId()).setInGame(user.getInGame());
      System.out.println("User: Roll No " + user.getId() +", updated in the database");
   }
   
   public synchronized void updateHasGame(UserBE user) {
      users.get(user.getId()).setHasGame(user.getHasGame());
      System.out.println("User: Roll No " + user.getId() +", updated in the database");
   }
   
   public synchronized void updateLoggedIn(UserBE user) {
      users.get(user.getId()).setLoggedIn(user.getLoggedIn());
      System.out.println("User: Roll No " + user.getId() +", updated in the database");
   }
}