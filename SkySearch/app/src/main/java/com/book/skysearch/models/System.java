package com.book.skysearch.models;

import android.text.TextUtils;

import java.util.ArrayList;

public class System  {
    private ArrayList<AirportModel> airports;

    private String key;

    private UserObject user = new UserObject();

    private  ArrayList<FlightData> fdList;


    //methods

    /**
     * This function returns the list of best flights for the given combination of source, destination, date etc.
     * @param source
     * @param destination
     * @param date1
     * @param date2
     * @param flighttype
     * @return
     */
    public ArrayList<TPresponse> search_query(String source, String destination, String date1, String date2, String flighttype){

        ArrayList<TPresponse> bestResults = new ArrayList<>();
        for(FlightData data : fdList){
            if(data.origin.equals(source) && data.destination.equals(destination)){
                TPresponse tPresponse = new TPresponse();
                tPresponse.setData(data);
                bestResults.add(tPresponse);
            }
        }
        return  bestResults;
    }

    /**
     * This function gets the list of airports from the third party
     * @return
     */
    public ArrayList<AirportModel> getAirports(){
        ThirdParty tp = new ThirdParty();
        airports= tp.getAirports();

    }

    /**
     * This function gets the list of flights from third party
     * @return
     */
    public ArrayList<FlightData> getFlights(){
        ThirdParty tp = new ThirdParty();
        fdList= tp.getFlights();
    }

    public boolean Authenticate(String username, String password){
        //TODO: proper authentication needed from database.
        if(!TextUtils.isEmpty(username)&& !TextUtils.isEmpty((password))){

            return true;
        }
    }

    /**
     *
     * @param cardNo
     * @param expD
     * @param cvv
     */
    public void AcceptPayment(String cardNo, String expD, String cvv ){
       //TODO: This will validate the payment for the given card details.
    }
}
