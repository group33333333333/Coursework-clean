package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/** Class representing an option in menu UI system
 *  In this case, Cities
 *  Contains multiple choices detailing what to query SQL database for
 *  Each choice calls a method to generate an ArrayList, then calls another method to display it
 */
public class menuCity {

    /**
     * Method to select SQL query to be generated and processed for 'Cities'
     * User is shown a list of options and enters an integer to select
     * Methods are called to generate an SQL query and display resultset to user
     * @param con
     * @param a
     */
    public static void MenuCity(Connection con, App a){

        Scanner scanner = new Scanner(System.in);

        // Initialises 'cities' ArrayList for use in operations
        ArrayList<City> cities;

        System.out.println("Select a Cities report:\n\n" +
                "1) All cities in the world, by population\n" +
                "2) All cities in a continent, by population\n" +
                "3) All cities in a region, by population\n" +
                "4) All cities in a country, by population\n" +
                "5) All cities in a district, by population\n" +
                "6) Top X cities in the world, by population\n" +
                "7) Top X cities in a continent, by population\n" +
                "8) Top X cities in a region, by population\n" +
                "9) Top X cities in a country, by population\n" +
                "10) Top X cities in a district, by population\n\n" );


        // CURRENTLY CRASHES UPON NON-INT INPUT
        // WILL NEED VALIDATION
        // Reads user input again and feeds to switch
        int choice = scanner.nextInt();

        // Menu UI for City reports
        switch (choice) {

            // Calls methods to generate and process SQL query, then calls another to display results for option 1
            case 1:
                cities = queryCity.getManyCityInWorld(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 2
            case 2:
                cities = queryCity.getManyCityInContinent(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 3
            case 3:
                cities = queryCity.getManyCityInRegion(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 4
            case 4:
                cities = queryCity.getManyCityInCountry(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 5
            case 5:
                cities = queryCity.getManyCityInDistrict(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 6
            case 6:
                cities = queryCity.getTopCityInWorld(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 7
            case 7:
                cities = queryCity.getTopCityInContinent(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 8
            case 8:
                cities = queryCity.getTopCityInRegion(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 9
            case 9:
                cities = queryCity.getTopCityInCountry(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 10
            case 10:
                cities = queryCity.getTopCityInDistrict(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;

            // Displays error message in case of invalid integer input
            default:
                System.out.println("Invalid choice!\n\n");
                break;

        }
    }
}
