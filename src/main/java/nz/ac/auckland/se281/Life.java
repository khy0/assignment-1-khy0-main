package nz.ac.auckland.se281;


public class Life extends Policy{
    public Life(String name, String age, String policyType, String[] options) {
        super(name, age, policyType, options);
    }

    @Override
    public void calculateBasePremium() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateBasePremium'");
    }
}
