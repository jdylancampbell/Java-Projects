

import java.text.SimpleDateFormat;

public class RescueAnimal {

    // Instance variables
    private String name;
    private String type;
    private String gender;
    private int age;
    private double weight = 0.0;
    private SimpleDateFormat acquisitionDate;
    private SimpleDateFormat statusDate;
    private String acquisitionSource;
    private Boolean reserved;

    private String trainingLocation;
    private SimpleDateFormat trainingStart;
    private SimpleDateFormat trainingEnd;
    private String trainingStatus;

    private String inServiceCountry;
    private String inServiceCity;
    private String inServiceAgency;
    private String inServicePOC;
    private String inServiceEmail;
    private String inServicePhone;
    private String inServicePostalAddress;

    // Constructor
    public RescueAnimal() {
    }

    // Add Accessor Methods here
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public double getWeight() {
        return weight;
    }
    public SimpleDateFormat getAcquisitionDate() {
        return acquisitionDate;
    }
    public SimpleDateFormat getStatusDate() {
        return statusDate;
    }
    public String getAcquisitionSource() {
        return acquisitionSource;
    }
    public boolean getReserved() {
        return reserved;
    }
    public String getTrainingLocation() {
        return trainingLocation;
    }
    public SimpleDateFormat getTrainingStart() {
        return trainingStart;
    }
    public SimpleDateFormat getTrainingEnd() {
        return trainingEnd;
    }
    public String getTrainingStatus() {
        return trainingStatus;
    }
    public String getInServiceCountry() {
        return inServiceCountry;
    }
    public String getInServiceCity() {
        return inServiceCity;
    }
    public String getInServiceAgency() {
        return inServiceAgency;
    }
    public String getInServicePOC() {
        return inServicePOC;
    }
    public String getInServiceEmail() {
        return inServiceEmail;
    }
    public String getInServicePhone() {
        return inServicePhone;
    }
    public String getInServicePostalAddress() {
        return inServicePostalAddress;
    }


    // Add Mutator Methods here
    public void setName(String Name) {
        name = Name;
    }
    public void setType(String Type) {
        type = Type;
    }
    public void setGender(String Gender) {
        gender = Gender;
    }
    public void setAge(int Age) {
        age = Age;
    }
    public void setWeight(double Weight) {
       weight = Weight;
    }
    public void setAcquisitionDate(SimpleDateFormat aqDate) {
       acquisitionDate = aqDate;
    }
    public void setStatusDate(SimpleDateFormat statDate) {
       statusDate = statDate;
    }
    public void setAcquisitionSource(String aqSource) {
       acquisitionSource = aqSource;
    }
    public void setReserved(boolean Reserved) {
       reserved = Reserved;
    }
    public void setTrainingLocation(String trainPlace) {
       trainingLocation = trainPlace;
    }
    public void setTrainingStart(SimpleDateFormat trainStart) {
       trainingStart = trainStart;
    }
    public void setTrainingEnd(SimpleDateFormat trainEnd) {
       trainingEnd = trainEnd;
    }
    public void setTrainingStatus(String trainStatus) {
       trainingStatus = trainStatus;
    }
    public void setInServiceCountry(String serviceCountry) {
       inServiceCountry = serviceCountry;
    }
    public void setInServiceCity(String serviceCity) {
       inServiceCity = serviceCity;
    }
    public void setInServiceAgency(String serviceAgency) {
        inServiceAgency = serviceAgency;
    }
    public void setInServicePOC(String servicePOC) {
        inServicePOC = servicePOC;
    }
    public void setInServiceEmail(String serviceEmail) {
        inServiceEmail = serviceEmail;
    }
    public void setInServicePhone(String servicePhone) {
        inServicePhone = servicePhone;
    }
    public void setInServicePostalAddress(String servicePostalAddress) {
        inServicePostalAddress = servicePostalAddress;
    }


    //List of field option available to update
    /*
    I utilize an option list built with a text block for efficiency/cleanliness to show the user their options.
    */
    public String listOptions() {
        String temp = """
                N - Name
                A - Age
                W - Weight
                R - Reserved
                S - Training Status
                C - InService Country
                T - InService Town/City
                G - InService Agency
                P - InService POC
                E - InService Email
                V - InService Phone(Voice)
                M - InService Mailing address""";
        return temp;
    }

}
