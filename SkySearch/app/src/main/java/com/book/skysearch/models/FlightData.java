package com.book.skysearch.models;

/**
 * Created by Prashant Dhillon
 * Purpose: This class correspond to Flight data module in class diagram. this class input the data
 *          needed from user regarding query and send it to third party class.
 */

public class FlightData {

    private String origin;
    private String destination;
    private String dateOfTravel;
    private String backDate;
    private String tripType;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(String dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getTypeOfClass() {
        return typeOfClass;
    }

    public void setTypeOfClass(String typeOfClass) {
        this.typeOfClass = typeOfClass;
    }

    private String typeOfClass;

    /**
     * This function is used to send request to third party client.
     */
    private void sendRequest(){
        // Todo : This will call third party to get best possible flight routes.
        ThirdParty thirdparty = new ThirdParty();
        thirdparty.getFlights();
    }


}
