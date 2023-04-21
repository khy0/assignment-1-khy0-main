package nz.ac.auckland.se281;

import java.util.List;

public class Profile {
    private String name;
    private int age;
    private List<InsurancePolicy> policies;

    // Constructor
    public Profile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<InsurancePolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<InsurancePolicy> policies) {
        this.policies = policies;
    }

}
