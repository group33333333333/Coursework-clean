package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class app {
    // Class-level connection
    public Connection con = null;

    public static void main(String[] args) {


        // Instantiates app container and connects to SQL database
        // Only needs done once at beginning of program
        // Do not remove!!
        app a = new app();
        a.connect();

        // Imports scanner for reading user inputs
        Scanner scanner = new Scanner(System.in);

        // First line of menu
        System.out.println("Welcome to coursework-clean!");
        System.out.println("Which reports would you like to view? Enter a number:\n" +
                "1) Country reports\n" +
                "2) City reports\n" +
                "3) Capital city reports\n" +
                "4) Population reports\n" +
                "5) Language reports\n");

        // Reads user input
        int choice = scanner.nextInt();

        // User input is fed into switch statement
        switch (choice)
        {

            // Second line of menu
            case 1:
                //Initialises 'countries' ArrayList for use in operations
                ArrayList<Country> countries;

                System.out.println("Select a Countries report:\n\n" +
                    "1) All countries in the world, by population\n" +
                    "2) All countries in a continent, by population\n" +
                    "3) All countries in a region, by population\n" +
                    "4) Top X countries in the world, by population\n" +
                    "5) Top X countries in a continent, by population\n" +
                    "6) Top X countries in a region, by population\n");

                // Reads user input again and feeds to switch
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        countries  = queryCountry.getManyCountryInWorld(a.con);
                        if (countries == null) {
                            System.out.println("Failed to retrieve countries!");
                            return;}
                        a.displayCountries(countries);
                        break;
                    case 2:
                        countries  = queryCountry.getManyCountryInContinent(a.con);
                        if (countries == null) {
                            System.out.println("Failed to retrieve countries!");
                            return;}
                        a.displayCountries(countries);
                        break;
                    case 3:
                        countries  = queryCountry.getManyCountryInRegion(a.con);
                        if (countries == null) {
                            System.out.println("Failed to retrieve countries!");
                            return;}
                        a.displayCountries(countries);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;

                }
                break;


            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;


        }






        // Disconnects from SQL database
        // Do not remove!
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
                System.out.println(String.format("%-10s %-50s %-25s %-35s %-25s %-25s" , "Code", "Name", "Continent", "Region", "Population", "Capital \n"));
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
                System.out.println("About to display " + cities.size() + " cities \n");

                // Prints a header with spacing prior to printing results of SQL query
                System.out.println(String.format("%-30s %-10s %-25s %-10s",  "Name", "Country", "District", "Population  \n"));


                // Loop over all cities in the list
                for (City city : cities)
                {
                    String country_string =
                            String.format("%-30s %-10s %-25s %-10s",
                                    city.name, city.code, city.district, city.citypopulation);
                    System.out.println(country_string);
                }
                System.out.println("\nFinished displaying " + cities.size() + " cities");
            } else {
                System.out.println("Cities list is NULL!");
            }
        } catch (Exception e) {
            System.out.println("ERROR in displayCities:");
            e.printStackTrace();
        }
    }

}
