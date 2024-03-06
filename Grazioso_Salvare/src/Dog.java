
public class Dog extends RescueAnimal {

    // Instance variable
    public String breed;

    // Constructor
    public Dog() {
    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

    //List of field option available to update
    @Override
    public String listOptions() {
        return(super.listOptions() + "\nQ - QUIT");
    }


}
