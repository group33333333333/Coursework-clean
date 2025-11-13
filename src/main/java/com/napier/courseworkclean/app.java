package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class app {

    // Class-level connection
    public Connection con = null;

    public static void main(String[] args) {

        // Instantiates app object and connects to SQL database
        // Only needs done once at beginning of program
        // Do not remove!!
        app a = new app();
        a.connect();

        // Welcomes users once at beginning of program
        System.out.println("Welcome to coursework-clean!");

        // Passes app a and connection to mainMenu system where calls to methods are stored
        // User remains in menu system for duration of the program
        // Only returns to app class to disconnect
        mainMenu.Menu(a.con, a);

        // Final message at end of program
        System.out.println("Thank you for using coursework-clean!");

        // Disconnects from SQL database and program ends
        a.disconnect();
    }





    // Method to connect to SQL database
    // Do not touch
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 100;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(3000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://database:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "Roddy-2006");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    // Method to disconnect from SQL database
    // Do mot touch
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }




    // Method to display single Country object 'country'
    // Prints single row and exits
    public void displayCountry(Country country) {
        if (country != null) {
            System.out.println(country.name + " " + country.population);
        }
    }

    // Method to display ArrayList<Country> 'countries'
    // Iterated through for loop to print every row in order
    // Array is already sorted alphabetically by SQL query
    // Prints 239 rows and exits
    public void displayCountries(ArrayList<Country> countries) {
        try {
            if (countries != null) {
                System.out.println("\nAbout to display " + countries.size() + " countries! \n");

                // Prints a header with spacing prior to printing results of SQL query
                System.out.println(String.format("%-10s %-50s %-25s%-35s %-25s %-25s" , "Code", "Name", "Continent", "Region", "Population", "Capital \n"));
                // Loop over all employees in the list
                for (Country country : countries)
                {
                    String country_string =
                            String.format("%-10s %-50s %-25s%-35s %-25s %-25s",
                                    country.code, country.name, country.continent, country.region, country.population, country.capital);
                    System.out.println(country_string);
                }
                System.out.println("\nFinished displaying " + countries.size() + " countries! \n");
            } else {
                System.out.println("Countries list is NULL!");
            }
        } catch (Exception e) {
            System.out.println("ERROR in displayCountries:");
            e.printStackTrace();
        }
    }

    // Method to display ArrayList<City> 'cities'
    // Iterated through for loop to print every row in order
    // Array is already sorted alphabetically by SQL query
    // Prints all cities and exits
    public void displayCities(ArrayList<City> cities) {
        try {
            if (cities != null) {
                System.out.println("\nAbout to display " + cities.size() + " cities \n");

                // Prints a header with spacing prior to printing results of SQL query
                System.out.println(String.format("%-30s %-55s %-25s %-10s",  "Name", "Country", "District", "Population  \n"));


                // Loop over all cities in the list
                for (City city : cities)
                {
                    String country_string =
                            String.format("%-30s %-55s %-25s %-10s",
                                    city.name, city.code, city.district, city.citypopulation);
                    System.out.println(country_string);
                }
                System.out.println("\nFinished displaying " + cities.size() + " cities\n");
            } else {
                System.out.println("Cities list is NULL!");
            }
        } catch (Exception e) {
            System.out.println("ERROR in displayCities:");
            e.printStackTrace();
        }
    }

    public void displayCapCities(ArrayList<City> capCities) {
        try {
            if (capCities != null) {
                System.out.println("\nAbout to display " + capCities.size() + " capital cities \n");

                // Prints a header with spacing prior to printing results of SQL query
                System.out.println(String.format("%-35s %-55s %-10s",  "Name", "Country", "Population  \n"));


                // Loop over all cities in the list
                for (City city : capCities)
                {
                    String country_string =
                            String.format("%-35s %-55s %-10s",
                                    city.name, city.code, city.citypopulation);
                    System.out.println(country_string);
                }
                System.out.println("\nFinished displaying " + capCities.size() + " capital cities\n");
            } else {
                System.out.println("Capital cities list is NULL!");
            }
        } catch (Exception e) {
            System.out.println("ERROR in displayCapCities:");
            e.printStackTrace();
        }
    }

}
