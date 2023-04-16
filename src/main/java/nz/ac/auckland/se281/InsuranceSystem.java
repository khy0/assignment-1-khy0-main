package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private Database obj;
  String name;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    obj = new Database();
  }

  public void printDatabase() {

    // Calling both userDatabase and ageDatabase arrays
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> ageDatabase = obj.getAgeDatabase();
    ArrayList<String> loadedUser = obj.getLoadedUser();

    // Checks how many profiles there are in the database and prints it
    if (userDatabase.size() == 0) {
      System.out.printf("Database has %s profile%s%s%n", 0, "s", ".");
    } else if (userDatabase.size() == 1) {
      System.out.printf("Database has %s profile%s%s%n", 1, "", ":");
    } else {
      System.out.printf("Database has %s profile%s%s%n", userDatabase.size(), "s", ":");
    }

    // Print the currently loaded profile with *** before the name and the unloaded profiles without
    // it
    for (int i = 0; i < userDatabase.size(); i++) {
      if (loadedUser.contains(userDatabase.get(i))) {
        System.out.printf("*** %d: %s, %s%n", i + 1, loadedUser.get(0), ageDatabase.get(i));
      } else {
        System.out.printf("%d: %s, %s%n", i + 1, userDatabase.get(i), ageDatabase.get(i));
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    ArrayList<String> loadedUser = obj.getLoadedUser();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    if (loadedUser.size() == 1) {
      System.out.printf("Cannot create a new profile. First unload the profile for %s.%n", name);
    } else {
      // Calling previously made function from Database class
      obj.storeInDatabase(userName, age);
    }
  }

  // private ArrayList<String> originalUserDatabase = null; // new variable to store original
  // userDatabase

  public void loadProfile(String userName) {
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> loadedUser = obj.getLoadedUser();

    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    // If the user is in the database and there is no profile loaded, load the profile
    if (userDatabase.contains(userName) && loadedUser.size() == 0) {
      loadedUser.add(userName);
      name = userName;
      System.out.printf("Profile loaded for %s.%n", userName);
    }
    // If the user is in the database and there is a profile loaded, unload the profile and load the
    // new profile
    else if (userDatabase.contains(userName) && loadedUser.size() == 1) {
      // originalUserDatabase = userDatabase; // store original userDatabase in new variable
      // userDatabase.remove(loadedUser.get(0)); // remove loaded profile from userDatabase
      loadedUser.remove(0); // remove loaded profile from loadedUser
      loadedUser.add(userName); // add new profile to loadedUser
      name = userName;
      System.out.printf("Profile loaded for %s.%n", userName);
    } else {
      System.out.printf("No profile found for %s. Profile not loaded.%n", userName);
    }
  }

  public void unloadProfile() {
    // ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> loadedUser = obj.getLoadedUser();

    if (loadedUser.size() == 1) {
      // remove loaded profile from loadedUser and add to userDatabase with original index position
      // from before it was loaded
      // userDatabase.add(loadedUser.get(0));
      loadedUser.remove(0);
      System.out.printf("Profile unloaded for %s.%n", name);
    } else {
      System.out.println("No profile is currently loaded.");
    }
  }

  public void deleteProfile(String userName) {
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> ageDatabase = obj.getAgeDatabase();
    ArrayList<String> loadedUser = obj.getLoadedUser();

    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    if (loadedUser.size() == 1) {
      System.out.printf(
          "Cannot delete profile for %s while loaded. No profile was deleted.%n", userName);
    } else if (userDatabase.contains(userName)) {
      for (int i = 0; i < userDatabase.size(); i++) {
        if (userDatabase.get(i).equals(userName)) {
          userDatabase.remove(userName);
          ageDatabase.remove(i);
          System.out.printf("Profile deleted for %s.%n", userName);
        }
      }
    } else {
      System.out.printf("No profile found for %s. No profile was deleted.%n", userName);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
