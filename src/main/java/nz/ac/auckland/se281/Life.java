package nz.ac.auckland.se281;


public class Life extends Policy{
    int ageInt = Integer.parseInt(age);
    int lifeBasePremium;
    int sumInsured = Integer.parseInt(options[0]);


    public Life(String name, String age, int numberOfPolicies, String[] options) {
        super(name, age, numberOfPolicies, options);
    }

    @Override
    public void calculateBasePremium() {
        if (numberOfPolicies == 1){
            if (ageInt <= 100 ){
                lifeBasePremium = (int) (1 + (ageInt / 100));
            } else {
                System.out.printf("%s is over the age limit. No policy was created.%n", name);
            }
        }
        else {
            System.out.printf("%s already has a life policy. No new policy was created.%n", name);
        }
    }
}
