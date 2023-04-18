package nz.ac.auckland.se281;

public class Car extends Policy{
    public Car(String name, String age, String policyType, String[] options) {
        super(name, age, policyType, options);
    }

    @Override
    public void calculateBasePremium() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateBasePremium'");
    }
}
