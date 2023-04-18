package nz.ac.auckland.se281;

public abstract class Policy {
    String name;
    String age;
    int numberOfPolicies;
    String[] options;

    public Policy(String name, String age, int numberOfPolicies, String[] options) {
        this.name = name;
        this.age = age;
        this.numberOfPolicies = numberOfPolicies;
        this.options = options;
    }

    public abstract void calculateBasePremium();
}
