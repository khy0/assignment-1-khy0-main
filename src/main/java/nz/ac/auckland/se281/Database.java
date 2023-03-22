package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashSet;

public class Database {

  private ArrayList<String> userDatabase;
  private ArrayList<String> ageDatabase;

  public Database() {
    // Defining ArrayLists for user and age
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
    // Processes the string in title case
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    
    // Adds the userName and age to the database ArrayLists
    userDatabase.add(userName);
    ageDatabase.add(age);

    // Defining a HashSet to make a unique set of strings inside the user database
    HashSet<String> uniqueSet = new HashSet<String>(userDatabase);

    // Converting age string to age integer
    int ageInt = Integer.parseInt(age);

    // Checking if the string is unique, has more than 3 characters and the age is a positive integer
    if (uniqueSet.size() == userDatabase.size() && userName.length() >= 3 && ageInt > 0) {
      System.out.printf("New profile created for %s with age %s.%n", userName, age);
    } else if (uniqueSet.size() != userDatabase.size()) {
      userDatabase.remove(userName);
      ageDatabase.remove(age);
      System.out.printf("Usernames must be unique. No profile was created for '%s'.%n", userName);
    } else if (userName.length() < 3) {
      userDatabase.remove(userName);
      ageDatabase.remove(age);
      System.out.printf(
          "'%s' is an invalid username, it should be at least 3 characters long. No profile was"
              + " created.%n",
          userName);
    } else if (ageInt < 0) {
      userDatabase.remove(userName);
      ageDatabase.remove(age);
      System.out.printf(
          "'%s' is an invalid age, please provide a positive whole number only. No profile was"
              + " created for %s.%n",
          age, userName);
    }
  }
}
