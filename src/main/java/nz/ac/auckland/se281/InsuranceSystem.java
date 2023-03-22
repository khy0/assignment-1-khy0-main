package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private Database obj;

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
