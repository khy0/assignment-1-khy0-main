package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;
//import java.util.Set;
// import java.util.ArrayList;
// import java.util.Scanner;

public class InsuranceSystem {

  private Database obj;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    obj = new Database();
  }

  public void printDatabase() {
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> ageDatabase = obj.getAgeDatabase();

    if (userDatabase.size() == 0) {
      System.out.printf("Database has %s profile%s%s%n", 0, "s", ".");
    } else if (userDatabase.size() == 1) {
      System.out.printf("Database has %s profile%s%s%n", 1, "", ":");
    } else {
      System.out.printf("Database has %s profile%s%s%n", userDatabase.size(), "s", ":");
    }

    for (int i = 0; i < userDatabase.size(); i++) {
      System.out.printf("%d: %s, %s%n", i + 1, userDatabase.get(i), ageDatabase.get(i));
    }
  }

  public void createNewProfile(String userName, String age) {
    // obj.storeInDatabase(userName, age);
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> ageDatabase = obj.getAgeDatabase();

    HashSet<String> uniqueSet = new HashSet<String>(userDatabase);

    for (int i = 0; i < userDatabase.size(); i++) {
      if (uniqueSet.size() == userDatabase.size()) {
        obj.storeInDatabase(userName, age);
        System.out.printf("New profile created for %s with age %s", userDatabase.get(i), ageDatabase.get(i));
      }
      else if (uniqueSet.size() != userDatabase.size()){
        System.out.printf("Usernames must be unique. No profile was created for %s.", userDatabase.get(i));
      }
      if (userName.length() >= 3) {
        System.out.printf("New profile created for %s with age %s", userDatabase.get(i), ageDatabase.get(i));
      }
      else if (userName.length() < 3) {
        System.out.printf("%s is an invalid username, it should be at least 3 characters long. No profile was created.", userDatabase.get(i));
      }
    }
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
