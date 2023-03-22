package nz.ac.auckland.se281;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashSet;
// import java.util.Set;
// import org.apache.commons.text.WordUtils;;

public class Database {

  private ArrayList<String> userDatabase;
  private ArrayList<String> ageDatabase;

  public Database() {
    userDatabase = new ArrayList<>();
    ageDatabase = new ArrayList<>();
  }

  public ArrayList<String> getUserDatabase() {
    return userDatabase;
  }

  public ArrayList<String> getAgeDatabase() {
    return ageDatabase;
  }

  public void storeInDatabase(String userName, String age) {
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    userDatabase.add(userName);
    ageDatabase.add(age);
    
    HashSet<String> uniqueSet = new HashSet<String>(userDatabase);
    int ageInt = Integer.parseInt(age);

    if (uniqueSet.size() == userDatabase.size() && userName.length() >= 3 && ageInt > 0) {
      System.out.printf("New profile created for %s with age %s.", userName, age);
    }
    else if (uniqueSet.size() != userDatabase.size()){
      userDatabase.remove(userName);
      ageDatabase.remove(age);
      System.out.printf("Usernames must be unique. No profile was created for '%s'.", userName);
    }
    else if (userName.length() < 3) {
      userDatabase.remove(userName);
      ageDatabase.remove(age);
      System.out.printf("'%s' is an invalid username, it should be at least 3 characters long. No profile was"
      + " created.", userName);
    }
    else if (ageInt < 0) {
      userDatabase.remove(userName);
      ageDatabase.remove(age);
      System.out.printf("'%s' is an invalid age, please provide a positive whole number only. No profile was created"
      + " for %s.", age, userName);
    }
    
  }

}
