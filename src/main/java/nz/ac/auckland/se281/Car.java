package nz.ac.auckland.se281;

public class Car extends Policy {
  private String makeAndModel;
  private boolean mechanicalBreakdown;

  public Car(String userName, String userAge, int numberOfPolicies, String[] options) {
    super(userName, userAge, numberOfPolicies);
    this.sumInsured = Integer.parseInt(options[0]);
    this.makeAndModel = options[1];
    this.mechanicalBreakdown = options[3].equalsIgnoreCase("yes");
  }

  @Override
  public void calculateBasePremium() {
    System.out.println("User Age: " + userAge);
    int ageInt = Integer.parseInt(userAge);

    // Calculate the base premium based on the age of the user and whether they have mechanical breakdown cover
    if (mechanicalBreakdown) {
      if (ageInt < 25) {
        basePremium = (int) (sumInsured * 0.15) + 80;
      } else {
        basePremium = (int) (sumInsured * 0.10) + 80;
      }
    } else {
      if (ageInt < 25) {
        basePremium = (int) (sumInsured * 0.15);
      } else {
        basePremium = (int) (sumInsured * 0.10);
      }
    }
  }

  @Override
  public void calculateTotalPremium(int userPoliciesCount) {
    totalPremium = basePremium;

    // Apply discounts based on the number of policies the user has 
    if (userPoliciesCount == 2) {
      totalPremium = (int) (totalPremium * 0.90); // 10% discount
    } else if (userPoliciesCount >= 3) {
      totalPremium = (int) (totalPremium * 0.80); // 20% discount
    }
  }

  @Override
  public String toString(int userPoliciesCount) {
    return String.format(
        "Car Policy (%s, Sum Insured: $%d, Premium: $%d -> $%d)",
        makeAndModel, sumInsured, basePremium, totalPremium);
  }
}
