package com.dio.courses.abakhtiozin.model;

/**
 * Created by AA on 02.11.2014.
 */
public class Hotel {

    private String hotelName;
    private String dateConstructed;
    private int stars;
    private String country;
    private String city;
    private String shortDesc;
    private String desc;
    private String notes;

    public Hotel withHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public Hotel withdateConstructed(String dateConstructed) {
        this.dateConstructed = dateConstructed;
        return this;
    }

    public Hotel withStars(int stars) {
        this.stars = stars;
        return this;
    }

    public Hotel withCountry(String country) {
        this.country = country;
        return this;
    }

    public Hotel withCity(String city) {
        this.city = city;
        return this;
    }

    public Hotel withShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
        return this;
    }
    public Hotel withDesc(String desc) {
        this.desc = desc;
        return this;
    }
    public Hotel withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getDateConstructed() {
        return dateConstructed;
    }

    public int getStars() {
        return stars;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getDesc() {
        return desc;
    }

    public String getNotes() {
        return notes;
    }

}
