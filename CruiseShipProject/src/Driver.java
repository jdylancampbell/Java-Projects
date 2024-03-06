import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();


    public static void main(String[] args) {
        String menuChoice;

        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers

        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed
        //Scanner object needed for input
        Scanner scnr = new Scanner(System.in);

        //Menu method already built
        displayMenu();


        menuChoice = scnr.next().toUpperCase();
        scnr.nextLine();

        /*
        Was looking for a better solution to dealing with this large menu without a ton of redundant IF statements
        and came across the switch-case function, in combination with the while loop and the try-catch, it's perfect for this application
        https://www.daniweb.com/programming/software-development/threads/13786/java-code-for-menu-selection-using-scanner-class
        */
        while (!menuChoice.equalsIgnoreCase("X")) {
            try {
                switch (menuChoice) {
                    case "1":
                        addShip(scnr);
                        break;
                    case "2":
                        editShip();
                        break;
                    case "3":
                        addCruise(scnr);
                        break;
                    case "4":
                        editCruise();
                        break;
                    case "5":
                        addPassenger();
                        break;
                    case "6":
                        editPassenger();
                        break;
                    case "A":
                        printShipList("name");
                        break;
                    case "B":
                        printShipList("active");
                        break;
                    case "C":
                        printShipList("full");
                        break;
                    case "D":
                        printCruiseList("list");
                        break;
                    case "E":
                        printCruiseList("details");
                        break;
                    case "F":
                        printPassengerList();
                        break;
                    case "X":
                        break;
                    default:
                        throw new Exception("Invalid input. Please select a valid option.");
                }
            }
            catch (Exception i) {
                System.out.println(i.getLocalizedMessage());
            }
            displayMenu();
            menuChoice = scnr.next().toUpperCase();
            scnr.nextLine();
        }

        //Always thank the customer for their usage
        System.out.println();
        System.out.println("Thank you for using Luxury Ocean Cruise Outings. Have a good day!");

        scnr.close();

    }

    // hard coded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, true);
        add("Candy Corn", 12, 18, 2, 24, true);
        add("Left Twix", 12, 18, 2, 24, true);
        add("Right Twix", 12, 18, 2, 24, false);
    }

    // hard coded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise1 = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise1);
        //newCruise1.printCruiseDetails();

        Cruise newCruise2 = new Cruise("South Eastern Twirl", "Peppermint Stick", "Charlotte", "Hawaii", "Charlotte");
        cruiseList.add(newCruise2);


        Cruise newCruise3 = new Cruise("Northern Chill", "Bon Bon", "San Diego", "Alaska", "San Diego");
        cruiseList.add(newCruise3);

        Cruise newCruise4 = new Cruise("Western Wild Ride", "Candy Corn", "Los Angeles", "Catalina", "Los Angeles");
        cruiseList.add(newCruise4);
    }


    // hard coded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip1 = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip1);
    }

    // custom method to add cruises to the cruiseList ArrayList
    public static void addC(String tCruiseName, String tShipName, String tDeparture, String tDestination, String tReturn) {
        Cruise newCruise1 = new Cruise(tCruiseName, tShipName, tDeparture, tDestination, tReturn);
        cruiseList.add(newCruise1);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints data in tab format on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int x = 0; x < shipList.size(); x++) {
                System.out.println(shipList.get(x));
            }
        } else if (listType == "active") {
            // complete this code block
            int inServiceShips = 0;

            for (int x = 0; x < shipList.size(); x++) {
                if (shipList.get(x).getInService()) {
                    if (x == 0) {
                        System.out.println("\n\nSHIP LIST - Active");
                    }
                    System.out.println(shipList.get(x).getShipName());
                    inServiceShips++;
                }
            }

            if (inServiceShips == 0) {
                System.out.println("There are currently no in-service ships to print.");
            }




        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-------------------------------------------------------");
            System.out.println("                    Number  of  Rooms  	  	In");
            System.out.print("SHIP NAME           Bal OV   	Ste  	Int    Service");
            System.out.println("\n-------------------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\tLuxury Ocean Cruise Outings");
        System.out.println("\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip(Scanner scnr) {

        /* complete this method
        Initialize all variables, approached this differently than the add passenger method below
        using the do-while as well as utilizing the try-catch to have it loop while incorrect
        instead of exiting to the menu.
        */
        String shipName = "";
        int balconyR = 0;
        int oceanViewR = 0;
        int suiteR = 0;
        int interiorR = 0;
        String inServiceFlag;
        boolean inServiceBool = false;
        boolean inputCheck;
        String stringNbrOfRooms;

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the name of the ship: ");
                shipName = scnr.nextLine();

                for (Ship eachShip: shipList) {
                    if (eachShip.getShipName().equalsIgnoreCase(shipName)) {
                        throw new Exception("This is a duplicate ship name.");
                    }
                }
                if (shipName.isBlank() || shipName.isEmpty()) {
                    throw new Exception("Ship name cannot be empty.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the number of balcony rooms this ship has.");
                stringNbrOfRooms = scnr.nextLine();
                balconyR = Integer.parseInt(stringNbrOfRooms);
                if (balconyR < 0) {
                    throw new Exception("Number of rooms cannot be negative or blank. Please enter 0 if this ship does not have any rooms with balconies.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the number of ocean view rooms this ship has.");
                stringNbrOfRooms = scnr.nextLine();
                oceanViewR = Integer.parseInt(stringNbrOfRooms);
                if (oceanViewR < 0) {
                    throw new Exception("Number of rooms cannot be negative or blank. Please enter 0 if this ship does not have ocean view rooms.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the number of suites this ship has.");
                stringNbrOfRooms = scnr.nextLine();
                suiteR = Integer.parseInt(stringNbrOfRooms);
                if (suiteR < 0) {
                    throw new Exception("Number of suites cannot be negative or blank. Please enter 0 if this ship does not have suites.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the number of interior rooms this ship has.");
                stringNbrOfRooms = scnr.nextLine();
                interiorR = Integer.parseInt(stringNbrOfRooms);
                if (interiorR < 0) {
                    throw new Exception("Number of rooms cannot be negative or blank. Please enter 0 if this ship does not have interior rooms.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Is this ship ready to be put in service? (Enter Y or N)");
                inServiceFlag = scnr.nextLine();
                if (!inServiceFlag.equalsIgnoreCase("y") && !inServiceFlag.equalsIgnoreCase("n")) {
                    throw new Exception("Please enter either Y or N.");
                }
                if (inServiceFlag.equalsIgnoreCase("y")) {
                    inServiceBool = true;
                }
                else {
                    inServiceBool = false;
                }
            }
            catch (Exception i) {
                System.out.println("Invalid Input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        add(shipName, balconyR, oceanViewR, suiteR, interiorR, inServiceBool);

    }


    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }


    // Add a New Cruise
    public static void addCruise(Scanner scnr) {

        /* complete this method
        Initialize all variables, approached this differently than the add passenger method below
        using the do-while as well as utilizing the try-catch to have it loop while incorrect
        instead of exiting to the menu.
        */

        String cruiseName = "";
        String nameOfCruiseShip = "";
        String portOfDeparture = "";
        String portOfReturn = "";
        String portOfDestination = "";
        boolean inputCheck;
        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the name of the cruise: ");
                cruiseName = scnr.nextLine();

                for (Cruise eachCruise: cruiseList) {
                    if (eachCruise.getCruiseName().equalsIgnoreCase(cruiseName)) {
                        throw new Exception("This is a duplicate cruise name.");
                    }
                }
                if (cruiseName.isBlank() || cruiseName.isEmpty()) {
                    throw new Exception("Cruise name cannot be empty.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the port of departure for this cruise.");
                portOfDeparture = scnr.nextLine();
                if (portOfDeparture.isBlank() || portOfDeparture.isEmpty()) {
                    throw new Exception("Departure port cannot be empty.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the port of destination for this cruise.");
                portOfDestination = scnr.nextLine();
                if (portOfDestination.isBlank() || portOfDestination.isEmpty()) {
                    throw new Exception("Destination port cannot be empty.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        do {
            inputCheck = true;
            try {
                System.out.println("Please enter the port of return for this cruise.");
                portOfReturn = scnr.nextLine();
                if (portOfReturn.isBlank() || portOfReturn.isEmpty()) {
                    throw new Exception("Return port cannot be empty.");
                }
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

        //do-while in combination with try-catch to validate user input and mitigate java errors
        // this had to be the most difficult part for me for some reason. I ended up spending quite a bit of time on this section alone
        do {
            inputCheck = true;
            try {
                boolean validShipBool;
                System.out.println("Please enter the name of the cruise ship: ");
                nameOfCruiseShip = scnr.nextLine();

                for (Cruise eachCruise: cruiseList) {
                    if (eachCruise.getCruiseShipName().equalsIgnoreCase(nameOfCruiseShip)) {
                        throw new Exception("This ship is already assigned to a cruise.");
                    }
                }
                for (Ship eachShip: shipList) {
                    if (eachShip.getShipName().equalsIgnoreCase(nameOfCruiseShip) && !eachShip.getInService()) {
                        throw new Exception("This ship is currently not in-service.");
                    }
                }
                if (nameOfCruiseShip.isBlank() || nameOfCruiseShip.isEmpty()) {
                    throw new Exception("Cruise name cannot be empty.");
                }
                for (Ship eachShip: shipList) {
                    if (eachShip.getShipName().equalsIgnoreCase(nameOfCruiseShip)) {
                        //This add was the savior and what made it work when the ship did exist and was in service and available for a cruise.
                        //Also added the shipOnFile variable to add the ship in the correct capitalization, I couldn't find a quick way to make things title case
                        String shipOnFile = eachShip.getShipName();
                        addC(cruiseName, shipOnFile,portOfDeparture, portOfDestination, portOfReturn);

                        return;
                    }
                }
                do {
                    validShipBool = false;
                    try {
                        for (int x = 0; x < shipList.size(); x++) {
                            if (shipList.get(x).getShipName().equalsIgnoreCase(nameOfCruiseShip)) {
                                validShipBool = true;
                            } else {
                                validShipBool = false;
                            }
                        }
                        if (!validShipBool) {
                           throw new Exception("This ship does not exist within the system.");
                        }
                    }
                    catch (Exception i) {
                        throw new Exception(i.getLocalizedMessage());
                    }
                } while (validShipBool);
            }
            catch (Exception i) {
                System.out.println("Invalid input detected. " + i.getLocalizedMessage());
                inputCheck = false;
            }
        } while (!inputCheck);

    }
    public final class TitleCase {

        public String toTitleCase(String input) {

            StringBuilder titleCase = new StringBuilder(input.length());
            boolean nextTitleCase = true;

            for (char c : input.toLowerCase().toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    nextTitleCase = true;
                } else if (nextTitleCase) {
                    c = Character.toTitleCase(c);
                    nextTitleCase = false;
                }
                titleCase.append(c);
            }

            return titleCase.toString();
        }

    }

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
            } else {
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }


    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}
