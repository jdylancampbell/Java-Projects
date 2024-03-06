public class Monkey extends RescueAnimal {
    private double tailLength = 0.0;
    private double height = 0.0;
    private double bodyLength = 0.0;
    private double torsoSize = 0.0;
    private double skullSize = 0.0;
    private double neckSize = 0.0;
    private String species;

    public Monkey() {

    }
    //Mutator Methods
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }
    public void setTailLength(double monkeyTailLength) {
        tailLength = monkeyTailLength;
    }
    public void setHeight(double monkeyHeight) {
        height = monkeyHeight;
    }
    public void setBodyLength(double monkeyBodyLength) {
        bodyLength = monkeyBodyLength;
    }
    public void setTorsoSize(double monkeyTorsoSize) {
        torsoSize = monkeyTorsoSize;
    }
    public void setSkullSize(double monkeySkullSize) {
        skullSize = monkeySkullSize;
    }
    public void setNeckSize(double monkeyNeckSize) {
        neckSize = monkeyNeckSize;
    }

    //Accessor Methods
    public String getSpecies() {
        return species;
    }

    public double getTailLength() {
        return tailLength;
    }

    public double getHeight() {
        return height;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public double getTorsoSize() {
        return torsoSize;
    }

    public double getSkullSize() {
        return skullSize;
    }

    public double getNeckSize() {
        return neckSize;
    }

    //List of field option available to update
    /*
    I utilize an option list built with a text block for efficiency/cleanliness to show the user their options.
    */
    @Override
    public String listOptions() {
        return(super.listOptions() + """
                \s
                L - Tail Length
                O - Height
                B - Body Length
                U - Torso Size
                H - Skull/Head Size
                Y - Neck Size
                Q - QUIT
                """);
    }
}

