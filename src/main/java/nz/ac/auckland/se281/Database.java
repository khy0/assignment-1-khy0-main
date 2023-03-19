package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Database {

  public void storeInDatabase(String userName, String age) {
    Scanner sc = new Scanner(System.in);

    ArrayList<String> userList = new ArrayList<>();
    ArrayList<Integer> ageList = new ArrayList<>();

    String userInput = sc.next();
    userList.add(userInput);
    Integer ageInput = sc.nextInt();
    ageList.add(ageInput);

    String[] userDatabase = userList.toArray(new String[0]);
    int[] ageDatabase = ageList.stream().mapToInt(i -> i).toArray();

    unique(userDatabase);

    sc.close();
  }

  public void unique(String[] userDatabase) {
    Set<String> set = new HashSet<>(Arrays.asList(userDatabase));

    String[] uniqueDatabase = set.toArray(new String[0]);
  }
}
