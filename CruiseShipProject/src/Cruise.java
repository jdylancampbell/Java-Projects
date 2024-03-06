public class Cruise {

    // Instance Variables
    private String cruiseName;
    private String cruiseShipName;
    private String departurePort;
    private String destination;
    private String returnPort;

    // Constructor - default
    Cruise() {
    }

    // Constructor - full
    Cruise(String tCruiseName, String tShipName, String tDeparture, String tDestination, String tReturn) {
        cruiseName = tCruiseName;
        cruiseShipName = tShipName;
        departurePort = tDeparture;
        destination = tDestination;
        returnPort = tReturn;
    }

    // Accessors
    public String getCruiseName() {
        return cruiseName;
    }

    public String getCruiseShipName() {
        return cruiseShipName;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getDestination() {
        return destination;
    }

    public String getReturnPort() {
        return returnPort;
    }

    // Mutators
    public void setCruiseName(String tVar) {
        cruiseName = tVar;
    }

    public void setCruiseShipName(String tVar) {
        cruiseShipName = tVar;
    }

    public void setDeparturePort(String tVar) {
        departurePort = tVar;
    }

    public void setDestination(String tVar) {
        destination = tVar;
    }

    public void setReturnPort(String tVar) {
        returnPort = tVar;
    }

    // print cruise details
    public void printCruiseDetails() {

        // complete this method
        // used the same methodology as Passenger.java to accomplish the below printCruiseDetails
        int spaceCount;
        String space1 = "";
        String space2 = "";
        String space3 = "";
        String space4 = "";
        String space5 = "";
        spaceCount = 20 - cruiseName.length();
        for (int i = 1; i <= spaceCount; i++) {
            space1 = space1 + " ";
        }
        spaceCount = 20 - cruiseShipName.length();
        for (int i = 1; i <= spaceCount; i++) {
            space2 = space2 + " ";
        } spaceCount = 20 - departurePort.length();
        for (int i = 1; i <= spaceCount; i++) {
            space3 = space3 + " ";
        }
        spaceCount = 20 - destination.length();
        for (int i = 1; i <= spaceCount; i++) {
            space4 = space4 + " ";
        }
        spaceCount = 20 - returnPort.length();
        for (int i = 1; i <= spaceCount; i++) {
            space5 = space5 + " ";
        }
        System.out.println(cruiseName + space1 + cruiseShipName + space2 +
                departurePort + space3 + destination + space4 + returnPort + space5);

    }

    // method added to print ship's name vice memory address
    @Override
    public String toString() {
        return cruiseName;
    }
}
