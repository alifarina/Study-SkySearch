
package com.book.skysearch.models;


import java.util.ArrayList;

public class ThirdParty {

    private String key;

    private ArrayList<AirportModel> airportModelList;
    private ArrayList<TPresponse> routesList;

    /**
     * Flight Data is a class not in this branch.
     * @param fd
     * @return
     */
    public  ArrayList<TPresponse> getFlights(FlightData fd){
        routesList = new ArrayList<>();
        for(int i=0;i<30;i++){
            TPresponse model = new TPresponse();
            model.setAirlineName(i);
            model.setArrival_time();
            routesList.add(model);
        }
        return routesList;


    }

    /**
     * - Abhishek
     * @return list of airports
     */
    public ArrayList<AirportModel> getAirports(){
        airportModelList = new ArrayList<>();
        for(int i=0;i<30;i++){
            AirportModel model = new AirportModel();
            model.setId(i);
            model.setName("Airport "+i);
            airportModelList.add(model);
        }
        return airportModelList;
    }

}
