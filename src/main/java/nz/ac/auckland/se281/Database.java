package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    userDatabase.add(userName);
    ageDatabase.add(age);
  }

  public void unique(String[] userDatabase) {
    Set<String> set = new HashSet<>(Arrays.asList(userDatabase));

    String[] uniqueDatabase = set.toArray(new String[0]);
  }
}
