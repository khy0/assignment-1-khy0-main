package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Database {

  public void storeInDatabase(String userName, String age) {
    String[] userDatabase = new String[1];
    userDatabase[0] = userName;
  }

  public void unique(String[] userDatabase) {
    Set<String> set = new HashSet<>(Arrays.asList(userDatabase));

    String[] uniqueDatabase = set.toArray(new String[0]);
  }
}
