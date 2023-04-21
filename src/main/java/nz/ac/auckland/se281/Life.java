package nz.ac.auckland.se281;


public class Life extends Policy{
    int ageInt = Integer.parseInt(age);
    int lifeBasePremium;
    int sumInsured;


    public Life(String name, String age, int numberOfPolicies, String[] options) {
        super(name, age, numberOfPolicies, options);

        // Initialize sumInsured and isRented after options array has been initialized
        sumInsured = Integer.parseInt(options[0]);
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

    @Override
    public String toString() {
        return String.format("Life Policy (Sum Insured: $%d, Premium: $%d -> $%d)", sumInsured, lifeBasePremium, lifeBasePremium);
    }
}

