package nz.ac.auckland.se281;

public class Home extends Policy {
    int homeBasePremium;
    int sumInsured;
    boolean isRented;

    public Home(String name, String age, int numberOfPolicies, String[] options) {
        super(name, age, numberOfPolicies, options);

        // Initialize sumInsured and isRented after options array has been initialized
        sumInsured = Integer.parseInt(options[0]);
        isRented = Boolean.parseBoolean(options[2]);
    }

    @Override
    public void calculateBasePremium() {
        if (isRented == true) {
            homeBasePremium = (int) (sumInsured * 0.02);
        } else {
            homeBasePremium = (int) (sumInsured * 0.01);
        }
    }

    @Override
    public String toString() {
        return String.format("Home Policy (Sum Insured: $%d, Premium: $%d -> $%d)", sumInsured, homeBasePremium, homeBasePremium);
    }
}

