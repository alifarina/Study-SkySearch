package com.book.skysearch.models;


/**
 * Created by Farina Ali
 * model class for holding airport data
 */
public class AirportModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
}
