package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/** Class representing an option in menu UI system
 *  In this case, Capital Cities
 *  Contains multiple choices detailing what to query SQL database for
 *  Each choice calls a method to generate an ArrayList, then calls another method to display it
 */
public class menuCapCity {

    /**
     * Method to select SQL query to be generated and processed for 'Capital Cities'
     * User is shown a list of options and enters an integer to select
     * Methods are called to generate an SQL query and display resultset to user
     * @param con
     * @param a
     */
    public static void MenuCapCity(Connection con, App a) {

        Scanner scanner = new Scanner(System.in);

        // Initialises 'cities' ArrayList for use in operations
        ArrayList<City> capCities;

        System.out.println("Select a Cities report:\n\n" +
                "1) All capital cities in the world, by population\n" +
                "2) All capital cities in a continent, by population\n" +
                "3) All capital cities in a region, by population\n" +
                "4) Top 'X' capital cities in the world, by population\n" +
                "5) Top 'X' capital cities in a continent, by population\n" +
                "6) Top 'X' capital cities in a region, by population\n\n");


        // CURRENTLY CRASHES UPON NON-INT INPUT
        // WILL NEED VALIDATION
        // Reads user input again and feeds to switch
        int choice = scanner.nextInt();

        // Menu UI for Capital City reports
        switch (choice) {

            // Calls methods to generate and process SQL query, then calls another to display results for option 1
            case 1:
                capCities = queryCapCity.getManyCapCityInWorld(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 2
            case 2:
                capCities = queryCapCity.getManyCapCityInContinent(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 3
            case 3:
                capCities = queryCapCity.getManyCapCityInRegion(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 4
            case 4:
                capCities = queryCapCity.getTopCapCityInWorld(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 5
            case 5:
                capCities = queryCapCity.getTopCapCityInContinent(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 6
            case 6:
                capCities = queryCapCity.getTopCapCityInRegion(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            // Displays error message in case of invalid integer input
            default:
                System.out.println("Invalid choice!\n\n");
                break;


        }
    }
}