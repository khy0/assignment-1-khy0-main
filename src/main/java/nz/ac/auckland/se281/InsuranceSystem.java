package nz.ac.auckland.se281;

import java.util.ArrayList;

//import org.eclipse.jgit.transport.CredentialItem.Username;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private Database obj;
  //public boolean isLoaded = false;
  String name;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    obj = new Database();
  }

  public void printDatabase() {
    // Calling both userDatabase and ageDatabase arrays
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> ageDatabase = obj.getAgeDatabase();

    // Checks how many profiles there are in the database and prints it
    if (userDatabase.size() == 0) {
      System.out.printf("Database has %s profile%s%s%n", 0, "s", ".");
    } else if (userDatabase.size() == 1) {
      System.out.printf("Database has %s profile%s%s%n", 1, "", ":");
    } else {
      System.out.printf("Database has %s profile%s%s%n", userDatabase.size(), "s", ":");
    }

    // Loops through the ArrayList and prints both the user and age databases
    for (int i = 0; i < userDatabase.size(); i++) {
      System.out.printf("%d: %s, %s%n", i + 1, userDatabase.get(i), ageDatabase.get(i));
    }
  }

  public void createNewProfile(String userName, String age) {
    // Calling previously made function from Database class
    obj.storeInDatabase(userName, age);
  }

  public void loadProfile(String userName) {
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> loadedUser = obj.getLoadedUser();

    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    if (userDatabase.contains(userName)){
      userDatabase.remove(userName);
      loadedUser.add(userName);
      //isLoaded = true;
      name = userName;
      System.out.printf("Profile loaded for %s.%n", userName);
    }
    else if (loadedUser.contains(userName)){
      System.out.printf("Cannot create a new profile. First unload the profile for %s.%n", userName);
    }
    else {
      System.out.printf("No profile found for %s. Profile not loaded.%n", userName);
    }
  }

  public void unloadProfile() {
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> loadedUser = obj.getLoadedUser();

    if (loadedUser.size() == 1){
      //isLoaded = false;
      userDatabase.add(name);
      loadedUser.remove(name);
      System.out.printf("Profile unloaded for %s.%n", name);
    }
    else{
      System.out.println("No profile is currently loaded.");
    }
  }

  public void deleteProfile(String userName) {
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> ageDatabase = obj.getAgeDatabase();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    if (userDatabase.contains(userName)){
      for (int i = 0; i < userDatabase.size(); i++) {
        if (userDatabase.get(i).equals(userName)){
          userDatabase.remove(userName);
          ageDatabase.remove(i);
          System.out.printf("Profile deleted for %s.%n", userName);
        }
      }
    }
    else {
      System.out.printf("No profile found for %s. No profile was deleted.%n", userName);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
