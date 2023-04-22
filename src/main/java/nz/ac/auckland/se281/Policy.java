package nz.ac.auckland.se281;

public abstract class Policy {
    protected String userName;
    protected String userAge;
    protected int userPoliciesCount;
    protected int sumInsured;
    protected int basePremium;
    protected int totalPremium;

    public Policy(String userName, String userAge, int userPoliciesCount) {
        this.userName = userName;
        this.userAge = userAge;
        this.userPoliciesCount = userPoliciesCount;
    }

    public abstract void calculateBasePremium();

    public abstract void calculateTotalPremium();

    public String getUserName() {
        return userName;
    }

    public abstract String toString(int userPoliciesCount);
}


