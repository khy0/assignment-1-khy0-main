package nz.ac.auckland.se281;

public class Life extends Policy {
    public Life(String userName, String userAge, int numberOfPolicies, String[] options) throws IllegalArgumentException {
        super(userName, userAge, numberOfPolicies);

        int ageInt = Integer.parseInt(userAge);
        if (ageInt > 100) {
            throw new IllegalArgumentException(String.format("%s is over the age limit. No policy was created.", userName));
        }

        this.sumInsured = Integer.parseInt(options[0]);
        calculateBasePremium();
    }

    @Override
    public void calculateBasePremium() {
        int ageInt = Integer.parseInt(userAge);
        basePremium = (int) (sumInsured * ((1 + (ageInt / 100.0))/100));
        //calculateTotalPremium();
    }

  @Override
  public void calculateTotalPremium(int userPoliciesCount) {
    totalPremium = basePremium;

    // Apply discounts based on the number of policies
    if (userPoliciesCount == 2) {
      totalPremium = (int) (totalPremium * 0.90); // 10% discount
    } else if (userPoliciesCount >= 3) {
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
