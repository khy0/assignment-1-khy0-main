package nz.ac.auckland.se281;

public class Car extends Policy{
    boolean mechanicalBreakdown;
    int ageInt = Integer.parseInt(age);
    int carBasePremium;
    int sumInsured;

    public Car(String name, String age, int numberOfPolicies, String[] options) {
        super(name, age, numberOfPolicies, options);

        // Initialize sumInsured and isRented after options array has been initialized
        sumInsured = Integer.parseInt(options[0]);
        mechanicalBreakdown = Boolean.parseBoolean(options[3]);
    }

    @Override
    public void calculateBasePremium() {
        if (ageInt < 25) {
            if (mechanicalBreakdown == true) {
                carBasePremium = (int) (sumInsured * 0.15) + 80;
            } else {
                carBasePremium = (int) (sumInsured * 0.15);
            }
        } else if (ageInt >= 25) {
            if (mechanicalBreakdown == true) {
                carBasePremium = (int) (sumInsured * 0.1) + 80;
            } else {
                carBasePremium = (int) (sumInsured * 0.1);
            }
        }
    }
}
