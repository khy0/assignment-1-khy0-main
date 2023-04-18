package nz.ac.auckland.se281;

public class Car extends Policy{
    boolean mechanicalBreakdown = Boolean.parseBoolean(options[3]);
    int ageInt = Integer.parseInt(age);
    int carBasePremium;
    int sumInsured = Integer.parseInt(options[0]);

    public Car(String name, String age, String policyType, String[] options) {
        super(name, age, policyType, options);
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
