package com.napier.courseworkclean;

/** Class representing a city **/
public class City {

    /** Property representing City's ID num **/
    public int ID;

    /** Property representing City's name **/
    public String name;

    /** Property representing City's country code **/
    public String countryCode;

    /** Property representing City's district **/
    public String district;

    /** Property representing City's population **/
    public String citypopulation;

    // toString override method
    // Fixes ArrayList display output, lists an object's properties instead of memory address
    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", citypopulation='" + citypopulation + '\'' +
                '}';
    }
}