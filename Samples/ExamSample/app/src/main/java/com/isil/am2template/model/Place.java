package com.isil.am2template.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 2/10/17.
 */

public class Place implements Serializable {

    private int id;
    private String userEmail;
    private String name;
    private String address;
    private boolean favorite;
    private double distance;

    public Place() {
    }

    public Place(String userEmail, String name, String address, boolean favorite, double distance) {
        this.userEmail = userEmail;
        this.name = name;
        this.address = address;
        this.favorite = favorite;
        this.distance = distance;
    }

    public Place( String userEmail, String name, String address, double distance) {
        this.userEmail = userEmail;
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.favorite=true;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
