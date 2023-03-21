package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;
// import java.util.ArrayList;
// import java.util.Scanner;

public class InsuranceSystem {

  private Database obj;
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    obj = new Database();
    //obj.storeInDatabase(userName, age);
  }

  public void printDatabase() {
    ArrayList<String> userDatabase = obj.getUserDatabase();
    for (int i=0; i < userDatabase.size(); i++){
      System.out.println(userDatabase.get(i));
    }
  }

  public void createNewProfile(String userName, String age) {
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
