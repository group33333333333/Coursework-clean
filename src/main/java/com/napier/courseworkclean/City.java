package com.napier.courseworkclean;

/** Class representing a city
 *  Properties are pulled from SQL database and assigned to object 'City'
 *  Objects are added to ArrayList<City> cities to be displayed
 * */
public class City {

    /** Property representing City's ID num **/
    public int id;

    /** Property representing City's name **/
    public String name;

    /** Property representing City's country code **/
    public String code;

    /** Property representing City's district **/
    public String district;

    /** Property representing City's population **/
    public String citypopulation;

    /** toString override method
        Fixes ArrayList display output, lists an object's properties instead of memory address
    *      */
    @Override
    public String toString() {
        return "City {" +
                "ID =" + id +
                ", Name ='" + name + '\'' +
                ", CountryCode ='" + code + '\'' +
                ", District ='" + district + '\'' +
                ", Population ='" + citypopulation + '\'' +
                '}';
    }
}

