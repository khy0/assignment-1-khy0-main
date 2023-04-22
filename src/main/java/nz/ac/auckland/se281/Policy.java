package nz.ac.auckland.se281;

public abstract class Policy {
    protected String userName;
    protected String userAge;
    protected int numberOfPolicies;
    protected int sumInsured;
    protected int basePremium;
    protected int totalPremium;

    public Policy(String userName, String userAge, int numberOfPolicies) {
        this.userName = userName;
        this.userAge = userAge;
        this.numberOfPolicies = numberOfPolicies;
    }

    public abstract void calculateBasePremium();

    public abstract void calculateTotalPremium(int userPoliciesCount);

    public String getUserName() {
        return userName;
    }

    public abstract String toString(int userPoliciesCount);
}


