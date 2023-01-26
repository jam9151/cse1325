// import java.util.*;

public class Pet{

    //Private Data
    private String name;
    private double age;
    private Type type;

    //constructor
    public Pet(String name, double age, Type type){
        this.name = name;
        this.age = age;
        this.type = type;

    }
    
    @Override
    public String toString() {
        
        return (name + " is a " + age + " year old " + type + ".");
        
    }
}