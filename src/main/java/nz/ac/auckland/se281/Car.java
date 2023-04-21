package nz.ac.auckland.se281;

public class Car extends Policy {
    private String makeAndModel;
    private boolean mechanicalBreakdown;

    public Car(String userName, String userAge, int numberOfPolicies, String[] options) {
        super(userName, userAge, numberOfPolicies);
        this.sumInsured = Integer.parseInt(options[0]);
        this.makeAndModel = options[1];
        this.mechanicalBreakdown = options[3].equalsIgnoreCase("true");
    }

    @Override
    public void calculateBasePremium() {
        int ageInt = Integer.parseInt(userAge);
        
        if (ageInt < 25) {
            basePremium = (int) (sumInsured * 0.15);
        } else {
            basePremium = (int) (sumInsured * 0.10);
        }

        if (mechanicalBreakdown) {
            basePremium += 80;
        }
        calculateTotalPremium();
    }

    @Override
    public void calculateTotalPremium() {
        totalPremium = basePremium;

        // Apply discounts based on the number of policies
        if (numberOfPolicies == 2) {
            totalPremium = (int) (totalPremium * 0.90); // 10% discount
        } else if (numberOfPolicies >= 3) {
            totalPremium = (int) (totalPremium * 0.80); // 20% discount
        }
    }

    @Override
    public String toString() {
        return String.format("Car Policy (%s, Sum Insured: $%d, Premium: $%d -> $%d)", makeAndModel, sumInsured, basePremium, totalPremium);
    }
}
