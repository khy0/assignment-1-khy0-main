package nz.ac.auckland.se281;

public abstract class Policy {
    String name;
    String age;
    String policyType;
    String[] options;

    public Policy(String name, String age, String policyType, String[] options) {
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.options = options;
    }

    public abstract void calculateBasePremium();
}
