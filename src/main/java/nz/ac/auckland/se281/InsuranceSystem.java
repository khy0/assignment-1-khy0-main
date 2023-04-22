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
    ArrayList<Policy> policies = obj.getPolicies();

    // Checks how many profiles there are in the database and prints it
    if (userDatabase.size() == 0) {
      System.out.printf("Database has %s profile%s%s%n", 0, "s", ".");
    } else if (userDatabase.size() == 1) {
      System.out.printf("Database has %s profile%s%s%n", 1, "", ":");
    } else {
      System.out.printf("Database has %s profile%s%s%n", userDatabase.size(), "s", ":");
    }

    // Calculate the total premium using the totalPremium field from each policy object
    totalPremium = 0;
    for (Policy policy : policies) {
      totalPremium += policy.totalPremium;
    }

    // Print the currently loaded profile with *** before the name and the unloaded profiles without
    // it
    for (int i = 0; i < userDatabase.size(); i++) {
      HashMap<String, Integer> countMap = new HashMap<>();
      String user = userDatabase.get(i);
      int userPoliciesCount = 0;
      for (String policyUser : userPolicies) {
        if (policyUser.equals(user)) {
          countMap.put(policyUser, countMap.getOrDefault(policyUser, 0) + 1);
          userPoliciesCount++;
        }
      }
      int numberOfPolicies = countMap.getOrDefault(user, 0);

      if (loadedUser.contains(user)) {
        if (numberOfPolicies == 1) {
          System.out.printf(
              " %s%s: %s, %s, %s polic%s%n",
              "*** ", i + 1, loadedUser.get(0), ageDatabase.get(i), numberOfPolicies, "y");
        } else {
          System.out.printf(
              " %s%s: %s, %s, %s polic%s%n",
              "*** ", i + 1, loadedUser.get(0), ageDatabase.get(i), numberOfPolicies, "ies");
        }
      } else {
        if (numberOfPolicies == 1) {
          System.out.printf(
              " %s%s: %s, %s, %s polic%s%n",
              "", i + 1, userDatabase.get(i), ageDatabase.get(i), numberOfPolicies, "y");
        } else {
          System.out.printf(
              " %s%s: %s, %s, %s polic%s%n",
              "", i + 1, userDatabase.get(i), ageDatabase.get(i), numberOfPolicies, "ies");
        }
      }

      // Print the policies created for each profile
      for (Policy policy : policies) {
        if (policy.getUserName().equals(user)) {
          System.out.println(" " + policy.toString(userPoliciesCount));
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

  public void applyDiscountsToPolicies(String userName) {
    ArrayList<Policy> policies = obj.getPolicies();
    int userPoliciesCount = 0;

    for (Policy policy : policies) {
      if (policy.getUserName().equals(userName)) {
        userPoliciesCount++;
      }
    }

    for (Policy policy : policies) {
      if (policy.getUserName().equals(userName)) {
        policy.calculateTotalPremium();
      }
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    ArrayList<String> loadedUser = obj.getLoadedUser();
    String policyTypeString = type.toString();
    policyType = policyTypeString.toLowerCase();

    ArrayList<String> userPolicies = obj.getUserPolicies();
    int userPoliciesCount = 0;

    String userName = "";
    String userAge = "";

    if ((loadedUser.size() == 1)) {
      userName = loadedUser.get(0);
      int userIndex = obj.getUserDatabase().indexOf(userName);
      userAge = obj.getAgeDatabase().get(userIndex);

      for (String policyUser : userPolicies) {
        if (policyUser.equals(userName)) {
          userPoliciesCount++;
        }
      }

      if (type == PolicyType.HOME) {
        userPoliciesCount++;
        Home obj1 = new Home(userName, userAge, userPoliciesCount, options);
        obj1.calculateBasePremium();
        obj.getPolicies().add(obj1);
        userPolicies.add(userName);
        System.out.printf("New %s policy created for %s.%n", policyType, userName);
      } else if (type == PolicyType.CAR) {
        userPoliciesCount++;
        Car obj2 = new Car(userName, userAge, userPoliciesCount, options);
        obj2.calculateBasePremium();
        obj.getPolicies().add(obj2);
        userPolicies.add(userName);
        System.out.printf("New %s policy created for %s.%n", policyType, userName);
      } else if (type == PolicyType.LIFE) {
        // Count the number of life policies for the user
        int lifePoliciesCount = 0;
        for (Policy policy : obj.getPolicies()) {
          if (policy instanceof Life && policy.getUserName().equals(userName)) {
            lifePoliciesCount++;
          }
        }
        // Only create a new life policy if the user doesn't have one
        try {
          if (lifePoliciesCount == 0) {
            Life obj3 = new Life(userName, userAge, userPoliciesCount, options);
            obj3.calculateBasePremium();
            if (obj3.basePremium != 0) { // Check if the base premium is not 0
              obj.getPolicies().add(obj3);
              userPoliciesCount++;
              userPolicies.add(userName);
              System.out.printf("New %s policy created for %s.%n", policyType, userName);
            }
          } else {
            System.out.printf(
                "%s already has a life policy. No new policy was created.%n", userName);
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        applyDiscountsToPolicies(userName);
      }
    } else {
      System.out.println("Need to load a profile in order to create a policy.");
    }
  }
}
