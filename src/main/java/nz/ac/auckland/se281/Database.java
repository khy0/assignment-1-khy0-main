package nz.ac.auckland.se281;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Database {
    
    public void storeInDatabase(String userName, String age) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> userList = new ArrayList<>();
        ArrayList<Integer> ageList = new ArrayList<>();

        String userInput = sc.nextLine();
        userList.add(userInput);
        Integer ageInput = sc.nextInt();
        ageList.add(ageInput);

        String[] userDatabase = userList.toArray(new String[0]);
        Integer[] ageDatabase = ageList.toArray(new Integer[0]);
    }
}
