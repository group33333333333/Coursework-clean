package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/** Class representing an option in menu UI system
 *  In this case, Countries
 *  Contains multiple choices detailing what to query SQL database for
 *  Each choice calls a method to generate an ArrayList, then calls another method to display it
 */
public class menuCountry {

    /**
     * Method to select SQL query to be generated and processed for 'Countries'
     * User is shown a list of options and enters an integer to select
     * Methods are called to generate an SQL query and display resultset to user
     * @param con
     * @param a
     */
    public static void MenuCountry(Connection con, App a) {

        Scanner scanner = new Scanner(System.in);

        // Initialises 'countries' ArrayList for use in operations
        ArrayList<Country> countries;

        System.out.println("Select a Countries report:\n\n" +
                "1) All countries in the world, by population\n" +
                "2) All countries in a continent, by population\n" +
                "3) All countries in a region, by population\n" +
                "4) Top X countries in the world, by population\n" +
                "5) Top X countries in a continent, by population\n" +
                "6) Top X countries in a region, by population\n\n");

        // CURRENTLY CRASHES UPON NON-INT INPUT
        // WILL NEED VALIDATION
        // Reads user input again and feeds to switch
        int choice = scanner.nextInt();

        // Menu UI for Country reports
        switch (choice) {

            // Calls methods to generate and process SQL query, then calls another to display results for option 1
            case 1:
                countries = queryCountry.getManyCountryInWorld(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 2
            case 2:
                countries = queryCountry.getManyCountryInContinent(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 3
            case 3:
                countries = queryCountry.getManyCountryInRegion(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 4
            case 4:
                countries = queryCountry.getTopCountryInWorld(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 5
            case 5:
                countries = queryCountry.getTopCountryInContinent(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;

            // Calls methods to generate and process SQL query, then calls another to display results for option 6
            case 6:
                countries = queryCountry.getTopCountryInRegion(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;

            // Displays error message in case of invalid integer input
            default:
                System.out.println("Invalid choice!\n\n");
                break;

        }

    }
}
