package com.book.skysearch.models;

/**
 * Abhishek
 * return list of possible routes based on user's airport selection
 */
public class TPresponse {

    String airlineName;

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getStop_count() {
        return stop_count;
    }

    public void setStop_count(int stop_count) {
        this.stop_count = stop_count;
    }

    public  void setData(FLightData fd){
        this.source=fd.origin;
        this.destination=fd.destination;
        //TODO: similarly for others
    }
    String source;
    String destination;
    String duration;
    String departure_time;
    String arrival_time;
    long price;
    int stop_count;

}
