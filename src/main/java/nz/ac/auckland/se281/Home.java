package nz.ac.auckland.se281;

public class Home extends Policy {
    int basePremium;
    int sumInsured = Integer.parseInt(options[0]);
    boolean isRented = Boolean.parseBoolean(options[2]);

    public Home(String name, String age, String policyType, String[] options) {
        super(name, age, policyType, options);
    }

    @Override
    public void calculateBasePremium() {
        if (isRented == true) {
            basePremium = (int) (sumInsured * 0.02);
        } else {
            basePremium = (int) (sumInsured * 0.01);
        }
    }
}
