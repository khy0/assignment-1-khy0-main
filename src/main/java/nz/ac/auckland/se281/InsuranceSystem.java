package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;
import java.util.ArrayList;
import java.util.Scanner;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
  
  }

  public void createNewProfile(String userName, String age) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> userList = new ArrayList<>();

    String userInput = sc.nextLine();
    userList.add(userInput);

    String[] userDatabase = userList.toArray(new String[0]);
    
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
