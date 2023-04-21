package nz.ac.auckland.se281;

public class Home extends Policy {
  private String address;
  private boolean rented;

  public Home(String userName, String userAge, int numberOfPolicies, String[] options) {
    super(userName, userAge, numberOfPolicies);
    this.sumInsured = Integer.parseInt(options[0]);
    this.address = options[1];
    this.rented = options[2].equalsIgnoreCase("yes");
  }

  @Override
  public void calculateBasePremium() {
    if (rented) {
      basePremium = (int) (sumInsured * 0.02); // 2% of the sum insured
    } else {
      basePremium = (int) (sumInsured * 0.01); // 1% of the sum insured
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
  public String toString(int userPoliciesCount) {
    return String.format(
        "Home Policy (%s, Sum Insured: $%s, Premium: $%s -> $%s)",
        address, sumInsured, basePremium, totalPremium);
  }
}
