package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private Database obj;

  String name;
  int numberOfPolicies = 0;
  String policyType;
  String[] options;
  int totalPremium = 0;
  String age;
  PolicyType type;

  private int homeBasePremium;
  private int carBasePremium;
  private int lifeBasePremium;

  HashMap<String, ArrayList<Policy>> policyDataStorage = new HashMap<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    obj = new Database();
  }

  public void printDatabase() {

    // Calling both userDatabase and ageDatabase arrays
    ArrayList<String> userDatabase = obj.getUserDatabase();
    ArrayList<String> ageDatabase = obj.getAgeDatabase();
    ArrayList<String> loadedUser = obj.getLoadedUser();
    ArrayList<String> userPolicies = obj.getUserPolicies();

    // Checks how many profiles there are in the database and prints it
    if (userDatabase.size() == 0) {
      System.out.printf("Database has %s profile%s%s%n", 0, "s", ".");
    } else if (userDatabase.size() == 1) {
      System.out.printf("Database has %s profile%s%s%n", 1, "", ":");
    } else {
      System.out.printf("Database has %s profile%s%s%n", userDatabase.size(), "s", ":");
    }

    totalPremium = homeBasePremium + carBasePremium + lifeBasePremium;

    // Print the currently loaded profile with *** before the name and the unloaded profiles without
    // it
    for (int i = 0; i < userDatabase.size(); i++) {
      HashMap<String, Integer> countMap = new HashMap<>();
      String user = userDatabase.get(i);
      for (String policyUser : userPolicies) {
        if (policyUser.equals(user)) {
          countMap.put(policyUser, countMap.getOrDefault(policyUser, 0) + 1);
        }
      }
      int numberOfPolicies = countMap.getOrDefault(user, 0);
      
      if (loadedUser.contains(user)) {
        if (numberOfPolicies == 1) {
          System.out.printf(" %s%s: %s, %s, %s polic%s%n", "*** ", i+1, loadedUser.get(0), ageDatabase.get(i), numberOfPolicies, "y");
        } else {
          System.out.printf(" %s%s: %s, %s, %s polic%s%n", "*** ", i+1, loadedUser.get(0), ageDatabase.get(i), numberOfPolicies, "ies");
        }
      } else {
        
        if (numberOfPolicies == 1) {
          System.out.printf(" %s%s: %s, %s, %s polic%s%n", "", i+1, userDatabase.get(i), ageDatabase.get(i), numberOfPolicies, "y");
        } else {
          System.out.printf(" %s%s: %s, %s, %s polic%s%n", "", i+1, userDatabase.get(i), ageDatabase.get(i), numberOfPolicies, "ies");
        }
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
      this.age = age;
    }
  }

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
      loadedUser.remove(0); // remove loaded profile from loadedUser
      loadedUser.add(userName); // add new profile to loadedUser
      name = userName;
      System.out.printf("Profile loaded for %s.%n", userName);
    } else {
      System.out.printf("No profile found for %s. Profile not loaded.%n", userName);
    }
  }

  public void unloadProfile() {
    ArrayList<String> loadedUser = obj.getLoadedUser();

    if (loadedUser.size() == 1) {
      // remove loaded profile from loadedUser and add to userDatabase with original index position
      // from before it was loaded
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
    ArrayList<String> loadedUser = obj.getLoadedUser();
    String policyTypeString = type.toString();
    policyType = policyTypeString.toLowerCase();

    ArrayList<String> userPolicies = obj.getUserPolicies();

    if ((loadedUser.size() == 1)) {
      System.out.printf("New %s policy created for %s.%n", policyType, name);
      userPolicies.add(name);
    } else {
      System.out.println("Need to load a profile in order to create a policy.");
    }
    

    if (type == PolicyType.HOME){
      Home obj1 = new Home(name, age, numberOfPolicies, options);
      obj1.calculateBasePremium();
      homeBasePremium = obj1.homeBasePremium;
    }
    else if (type == PolicyType.CAR){
      Car obj2 = new Car(name, age, numberOfPolicies, options);
      obj2.calculateBasePremium();
      carBasePremium = obj2.carBasePremium;
    }
    else if (type == PolicyType.LIFE){
      Life obj3 = new Life(name, age, numberOfPolicies, options);
      obj3.calculateBasePremium();
      lifeBasePremium = obj3.lifeBasePremium;
    }
  }
}

