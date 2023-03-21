package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Database {

  private ArrayList<String> userDatabase;

  public Database() {
    userDatabase = new ArrayList<>();
  }

  public ArrayList<String> getUserDatabase() {
    return userDatabase;
  }

  public void storeInDatabase(String userName, String age) {
    userDatabase.add(userName);
  }

  public void unique(String[] userDatabase) {
    Set<String> set = new HashSet<>(Arrays.asList(userDatabase));

    String[] uniqueDatabase = set.toArray(new String[0]);
  }
}
