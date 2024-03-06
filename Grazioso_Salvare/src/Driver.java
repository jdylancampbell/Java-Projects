/*
Joshua Dylan Campbell
IT-145
Project 2
 */

import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {
        // Instance variables
        Scanner scnr = new Scanner(System.in);
        //built the below variables to store the old value of the various value types while updating multiple fields per variable type
        int tempI;
        int newI;
        double tempD;
        double newD;
        String newS;
        String tempS;

        /*
        I utilize an option list built with a text block for efficiency/cleanliness to show the user their options.
        I also use a variable for this menu so it can be used multiple times cleanly throughout the program.
        */
        String optionList = """
                \s
                Please select one of the below options to begin.
                \s
                R - Request for a rescue animal.
                U - Update the information on a current animal.
                L - List of which animals are in each phase at all locations.
                A - Add animals.
                T - Transfer animals to the farm or to in-service.
                I - View which animals are In-service.
                D - Decommission animal. (death/retirement)
                Q - Quit program.""";
        char selectedOption;

        System.out.println("Welcome!\nThank you for choosing Grazioso Salvare.");
        System.out.println(optionList);
        selectedOption = scnr.nextLine().toUpperCase().charAt(0);


        while (selectedOption != 'Q') {

            /*The below takes the users input and determines which Field to update
            and output accordingly after checking it's a valid selection
            https://stackoverflow.com/questions/27555895/is-it-possible-to-check-if-a-char-matches-a-list-of-possibilities */
            while ("RULATID".indexOf(selectedOption) == -1) {
                System.out.println("Invalid Selection.");
                System.out.println(optionList);
                selectedOption = scnr.nextLine().toUpperCase().charAt(0);
                if (selectedOption == 'Q') {
                    break;
                }
            }

                /* The below methods are out of scope for the assignment
                 Method to process request for a rescue animal
                 Method to display matrix of animals based on location and status/training phase
                 Method to add animals
                 Method to out process animals for the farm or in-service placement
                 Method to display in-service animals
                 Process reports from in-service agencies reporting death/retirement

                 The below takes the users input and determines which Field to update
                 and output accordingly after checking it's a valid selection
                 https://stackoverflow.com/questions/27555895/is-it-possible-to-check-if-a-char-matches-a-list-of-possibilities */
            while ("RLATID".indexOf(selectedOption) != -1) {
                System.out.println("This program is currently in Alpha testing. During that time, this feature is unavailable");
                System.out.println(optionList);
                selectedOption = scnr.nextLine().toUpperCase().charAt(0);
                if (selectedOption == 'Q') {
                    break;
                }
                while ("RULATID".indexOf(selectedOption) == -1) {
                    System.out.println("Invalid Selection.");
                    System.out.println(optionList);
                    selectedOption = scnr.nextLine().toUpperCase().charAt(0);
                    if (selectedOption == 'Q') {
                        break;
                    }
                }
            }

            // Method(s) to update information on existing animals (Chosen method)
            if (selectedOption == 'U') {
                char animalType;

                //Building the fake Dog and Monkey to test update ability
                Dog dog1 = new Dog();
                dog1.setName("Spot");
                dog1.setType("Dog");
                dog1.setAge(4);
                dog1.setWeight(85);
                dog1.setReserved(true);
                dog1.setBreed("Lab");
                dog1.setTrainingStatus("Done");
                dog1.setInServiceCountry("USA");
                dog1.setInServiceCity("Little Rock");
                dog1.setInServiceAgency("TrainingAgents");
                dog1.setInServicePOC("Unknown");
                dog1.setInServiceEmail("Agent@trainingAgents.com");
                dog1.setInServicePhone("555-555-5555");
                dog1.setInServicePostalAddress("123 Training LN Little Rock, AR 55555");

                Monkey monkey1 = new Monkey();
                monkey1.setName("Zoboomafoo");
                monkey1.setType("Monkey");
                monkey1.setAge(6);
                monkey1.setWeight(20);
                monkey1.setReserved(true);
                monkey1.setSpecies("Capuchin");
                monkey1.setTrainingStatus("3 weeks left");
                monkey1.setInServiceCountry("USA");
                monkey1.setInServiceCity("Denver");
                monkey1.setInServiceAgency("TrainingAgents");
                monkey1.setInServicePOC("Unknown");
                monkey1.setInServiceEmail("Agent@trainingAgents.com");
                monkey1.setInServicePhone("555-555-5555");
                monkey1.setInServicePostalAddress("123 Training LN Denver, CO 55555");
                monkey1.setTailLength(19.4);
                monkey1.setHeight(22.6);
                monkey1.setBodyLength(14.5);
                monkey1.setTorsoSize(10);
                monkey1.setSkullSize(7.8);
                monkey1.setNeckSize(3.1);

                /*
                I utilize an option list built with a text block for efficiency/cleanliness to show the user their options.
                which type of animal is being updated */
                System.out.println("""
                            What type of animal are you updating?
                            \s
                            D - Dog
                            M - Monkey
                            Q - Quit""");

                animalType = scnr.nextLine().toUpperCase().charAt(0);

                if (animalType == 'Q') {
                    break;
                }
                while (animalType != 'D' && animalType != 'M' && animalType != 'Q') {
                    System.out.println("Invalid selection.");
                    System.out.println("""
                            What type of animal are you updating?
                            \s
                            D - Dog
                            M - Monkey
                            Q - Quit""");
                    animalType = scnr.nextLine().toUpperCase().charAt(0);
                    if (animalType == 'Q') {
                        break;
                    }
                }

                //Dog
                if (animalType == 'D') {

                    System.out.println("Which field would you like to update?");
                    System.out.println(dog1.listOptions());

                    char updateField = scnr.next().toUpperCase().charAt(0);

                    while (updateField != 'Q') {

                        /*The below takes the users input and determines which Field to update
                        and output accordingly after checking it's a valid selection
                        https://stackoverflow.com/questions/27555895/is-it-possible-to-check-if-a-char-matches-a-list-of-possibilities */
                        while ("NAWRSCTGPEVMQ".indexOf(updateField) == -1) {
                            System.out.println("Invalid Selection.");
                            System.out.println("Which field would you like to update?");
                            System.out.println(dog1.listOptions());
                            updateField = scnr.next().toUpperCase().charAt(0);
                            if (updateField == 'Q') {
                                break;
                            }
                        }
                        if (updateField == 'Q') {
                            break;
                        }
                        if (updateField == 'N') {
                            tempS = dog1.getName();
                            System.out.println("New name Value: ");
                            newS = scnr.next();
                            dog1.setName(newS);
                            System.out.println("Name for dog1 aka " + dog1.getName() + " has been updated from: " + "'" + tempS + "'"
                                    + " to the new value: " + "'" + dog1.getName() + "'");
                        }
                        if (updateField == 'A') {
                            tempI = dog1.getAge();
                            System.out.println("New age Value: ");
                            newI = scnr.nextInt();
                            dog1.setAge(newI);
                            System.out.println("Age for dog1 aka " + dog1.getName() + " has been updated from: " + tempI
                                    + " to the new value: " + dog1.getAge());
                        }
                        if (updateField == 'W') {
                            tempD = dog1.getWeight();
                            System.out.println("New weight Value: ");
                            newD = scnr.nextDouble();
                            dog1.setWeight(newD);
                            System.out.println("Weight for dog1 aka " + dog1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + dog1.getWeight());
                        }
                        //Only needed the boolean type variable once per animal so built it into the IF statement
                        if (updateField == 'R') {
                            boolean tempb = dog1.getReserved();
                            System.out.println("New reservation Value: ");
                            boolean newb = scnr.nextBoolean();
                            dog1.setReserved(newb);
                            System.out.println("Reservation for dog1 aka " + dog1.getName() + " has been updated from: " + tempb
                                    + " to the new value: " + dog1.getReserved());
                        }
                        if (updateField == 'S') {
                            tempS = dog1.getTrainingStatus();
                            System.out.println("New training status value: ");
                            newS = scnr.next();
                            dog1.setTrainingStatus(newS);
                            System.out.println("Training Status for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getTrainingStatus());
                        }
                        if (updateField == 'C') {
                            tempS = dog1.getInServiceCountry();
                            System.out.println("New Country value: ");
                            newS = scnr.next();
                            dog1.setInServiceCountry(newS);
                            System.out.println("In-Service Country for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getInServiceCountry());
                        }
                        if (updateField == 'T') {
                            tempS = dog1.getInServiceCity();
                            System.out.println("New City value: ");
                            newS = scnr.next();
                            dog1.setInServiceCity(newS);
                            System.out.println("In-Service City for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getInServiceCity());
                        }
                        if (updateField == 'G') {
                            tempS = dog1.getInServiceAgency();
                            System.out.println("New In-Service Agency value: ");
                            newS = scnr.next();
                            dog1.setInServiceAgency(newS);
                            System.out.println("In-Service Agency for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getInServiceAgency());
                        }
                        if (updateField == 'P') {
                            tempS = dog1.getInServicePOC();
                            System.out.println("New In-Service POC value: ");
                            newS = scnr.next();
                            dog1.setInServicePOC(newS);
                            System.out.println("In-Service POC for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getInServicePOC());
                        }
                        if (updateField == 'E') {
                            tempS = dog1.getInServiceEmail();
                            System.out.println("New In-Service Email value: ");
                            newS = scnr.next();
                            dog1.setInServiceEmail(newS);
                            System.out.println("In-Service Email for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getInServiceEmail());
                        }
                        if (updateField == 'V') {
                            tempS = dog1.getInServicePhone();
                            System.out.println("New In-Service Phone value: ");
                            newS = scnr.next();
                            dog1.setInServicePhone(newS);
                            System.out.println("In-Service Phone for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getInServicePhone());
                        }
                        if (updateField == 'M') {
                            tempS = dog1.getInServicePostalAddress();
                            System.out.println("New In-Service Postal Address value: ");
                            newS = scnr.next();
                            dog1.setInServicePostalAddress(newS);
                            System.out.println("In-Service Postal Address for dog1 aka " + dog1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + dog1.getInServicePostalAddress());
                        }
                        System.out.println();
                        System.out.println("Would you like to update anything else?");
                        System.out.println(dog1.listOptions());
                        updateField = scnr.next().toUpperCase().charAt(0);
                    }
                }

                //Monkey
                if (animalType == 'M') {
                    System.out.println("Which field would you like to update?");
                    System.out.println(monkey1.listOptions());

                    char updateField = scnr.next().toUpperCase().charAt(0);

                    while (updateField != 'Q') {


                        /*The below takes the users input and determines which Field to update
                        and output accordingly after checking it's a valid selection
                        https://stackoverflow.com/questions/27555895/is-it-possible-to-check-if-a-char-matches-a-list-of-possibilities */
                        while ("NAWRSCTGPEVMOLBUHYQ".indexOf(updateField) == -1) {
                            System.out.println("Invalid Selection.");
                            System.out.println("Which field would you like to update?");
                            System.out.println(dog1.listOptions());
                            updateField = scnr.next().toUpperCase().charAt(0);
                            if (updateField == 'Q') {
                                break;
                            }
                        }
                        if (updateField == 'Q') {
                            break;
                        }
                        if (updateField == 'N') {
                            tempS = monkey1.getName();
                            System.out.println("New name Value: ");
                            newS = scnr.next();
                            monkey1.setName(newS);
                            System.out.println("Name for monkey1 aka " + monkey1.getName() + " has been updated from: " + "'" + tempS + "'"
                                    + " to the new value: " + "'" + monkey1.getName() + "'");
                        }
                        if (updateField == 'A') {
                            tempI = monkey1.getAge();
                            System.out.println("New age Value: ");
                            newI = scnr.nextInt();
                            monkey1.setAge(newI);
                            System.out.println("Age for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempI
                                    + " to the new value: " + monkey1.getAge());
                        }
                        if (updateField == 'W') {
                            tempD = monkey1.getWeight();
                            System.out.println("New weight Value: ");
                            newD = scnr.nextDouble();
                            monkey1.setWeight(newD);
                            System.out.println("Weight for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + monkey1.getWeight());
                        }
                        //Only needed the boolean type variable once per animal so built it into the IF statement
                        if (updateField == 'R') {
                            boolean tempb = monkey1.getReserved();
                            System.out.println("New reservation Value: ");
                            boolean newb = scnr.nextBoolean();
                            monkey1.setReserved(newb);
                            System.out.println("Reservation for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempb
                                    + " to the new value: " + monkey1.getReserved());
                        }
                        if (updateField == 'S') {
                            tempS = monkey1.getTrainingStatus();
                            System.out.println("New training status value: ");
                            newS = scnr.next();
                            monkey1.setTrainingStatus(newS);
                            System.out.println("Training Status for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getTrainingStatus());
                        }
                        if (updateField == 'C') {
                            tempS = monkey1.getInServiceCountry();
                            System.out.println("New Country value: ");
                            newS = scnr.next();
                            monkey1.setInServiceCountry(newS);
                            System.out.println("In-Service Country for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getInServiceCountry());
                        }
                        if (updateField == 'T') {
                            tempS = monkey1.getInServiceCity();
                            System.out.println("New City value: ");
                            newS = scnr.next();
                            monkey1.setInServiceCity(newS);
                            System.out.println("In-Service City for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getInServiceCity());
                        }
                        if (updateField == 'G') {
                            tempS = monkey1.getInServiceAgency();
                            System.out.println("New In-Service Agency value: ");
                            newS = scnr.next();
                            monkey1.setInServiceAgency(newS);
                            System.out.println("In-Service Agency for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getInServiceAgency());
                        }
                        if (updateField == 'P') {
                            tempS = monkey1.getInServicePOC();
                            System.out.println("New In-Service POC value: ");
                            newS = scnr.next();
                            monkey1.setInServicePOC(newS);
                            System.out.println("In-Service POC for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getInServicePOC());
                        }
                        if (updateField == 'E') {
                            tempS = monkey1.getInServiceEmail();
                            System.out.println("New In-Service Email value: ");
                            newS = scnr.next();
                            monkey1.setInServiceEmail(newS);
                            System.out.println("In-Service Email for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getInServiceEmail());
                        }
                        if (updateField == 'V') {
                            tempS = monkey1.getInServicePhone();
                            System.out.println("New In-Service Phone value: ");
                            newS = scnr.next();
                            monkey1.setInServicePhone(newS);
                            System.out.println("In-Service Phone for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getInServicePhone());
                        }
                        if (updateField == 'M') {
                            tempS = monkey1.getInServicePostalAddress();
                            System.out.println("New In-Service Postal Address value: ");
                            newS = scnr.next();
                            monkey1.setInServicePostalAddress(newS);
                            System.out.println("In-Service Postal Address for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempS
                                    + " to the new value: " + monkey1.getInServicePostalAddress());
                        }
                        if (updateField == 'L') {
                            tempD = monkey1.getTailLength();
                            System.out.println("New tail length value: ");
                            newD = scnr.nextDouble();
                            monkey1.setTailLength(newD);
                            System.out.println("Tail Length for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + monkey1.getTailLength());
                        }
                        if (updateField == 'O') {
                            tempD = monkey1.getHeight();
                            System.out.println("New height value: ");
                            newD = scnr.nextDouble();
                            monkey1.setHeight(newD);
                            System.out.println("Height for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + monkey1.getHeight());
                        }
                        if (updateField == 'B') {
                            tempD = monkey1.getBodyLength();
                            System.out.println("New body length value: ");
                            newD = scnr.nextDouble();
                            monkey1.setBodyLength(newD);
                            System.out.println("Body Length for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + monkey1.getBodyLength());
                        }
                        if (updateField == 'U') {
                            tempD = monkey1.getTorsoSize();
                            System.out.println("New torso size value: ");
                            newD = scnr.nextDouble();
                            monkey1.setTorsoSize(newD);
                            System.out.println("Torso size for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + monkey1.getTorsoSize());
                        }
                        if (updateField == 'H') {
                            tempD = monkey1.getSkullSize();
                            System.out.println("New skull size value: ");
                            newD = scnr.nextDouble();
                            monkey1.setSkullSize(newD);
                            System.out.println("Skull size for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + monkey1.getSkullSize());
                        }
                        if (updateField == 'Y') {
                            tempD = monkey1.getNeckSize();
                            System.out.println("New neck size value: ");
                            newD = scnr.nextDouble();
                            monkey1.setNeckSize(newD);
                            System.out.println("Neck size for monkey1 aka " + monkey1.getName() + " has been updated from: " + tempD
                                    + " to the new value: " + monkey1.getNeckSize());
                        }
                        System.out.println();
                        System.out.println("Would you like to update anything else?");
                        System.out.println(monkey1.listOptions());
                        updateField = scnr.next().toUpperCase().charAt(0);
                    }
                }
            }
            break;
        }
        //Always thank the customer for their usage
        System.out.println();
        System.out.println("Thank you for using our rescue animal system. Have a good day!");
    }
}