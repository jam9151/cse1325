

public class MyPets{
    public static void main(String[] args){
        
        Pet petOne = new Pet("Tom",12.5, Type.Squirrel);
        
        Pet petTwo = new Pet("Jim", 4.0, Type.Goat);
        
        Pet petThree = new Pet("Alex", 9, Type.Lama);
        
        Pet petFour = new Pet("Bjorn", 103, Type.Bear);

        Pet myPets[] = {petOne, petTwo, petThree, petFour};

        for(Pet ID: myPets){
            System.out.println(ID);
        }
        
        
    }
}
