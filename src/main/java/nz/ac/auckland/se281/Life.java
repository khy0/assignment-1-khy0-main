package nz.ac.auckland.se281;

public class Life extends Policy {
  public Life(String userName, String userAge, int numberOfPolicies, String[] options) {
    super(userName, userAge, numberOfPolicies);
    this.sumInsured = Integer.parseInt(options[0]);
  }

  @Override
  public void calculateBasePremium() {
    int ageInt = Integer.parseInt(userAge);

    if (ageInt <= 100) {
      basePremium = (int) (sumInsured * (1 + (ageInt / 100.0)));
      calculateTotalPremium();
    } else {
      System.out.printf("%s is over the age limit. No policy was created.%n", userName);
    }
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
  public String toString(int userPoliciesCount) {
    return String.format(
        "Life Policy (Sum Insured: $%s, Premium: $%s -> $%s)",
        sumInsured, basePremium, totalPremium);
  }
}
