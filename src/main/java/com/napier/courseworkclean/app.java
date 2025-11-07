package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;

public class app {
    // Class-level connection
    private Connection con = null;

    public static void main(String[] args) {

        // Instantiates app container and connects to SQL database
        // Do not remove!!
        app a = new app();
        a.connect();


        // Calls getCountry method and returns single object 'country'
        // Calls displayCountry method and prints values of properties in 'country' object
        Country country = a.getCountry("TWN");
        a.displayCountry(country);


        // Calls getManyCountry method and returns ArrayList<Country> 'countries'
        // Contains list of Country objects and associated properties
        ArrayList<Country> countries = a.getManyCountry();
        if (countries == null) {
            System.out.println("Failed to retrieve countries!");
            return;
        }

        // Calls displayCountries method when passed ArrayList<Country> 'countries'
        // ArrayList is iterated through a for loop of ArrayList length and printed
        // Calculates ArrayList size and prints
        a.displayCountries(countries);
        System.out.println("Number of countries: " + countries.size());


        // Prints entire ArrayList<Country> 'countries'
        // Prints on one line, mot ideal
        System.out.println(countries);


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


    // Method structure for single result SQL queries
    // Method is passed 'code' variable with value "TWN"
    // String strSelect is created and defined as an SQL query
    // Processes SQL query
    // Returns a single Country object 'country'
    // In this case, method only prints Name and Population properties but could print more if needed
    public Country getCountry(String code) {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Population " +
                            "FROM country " +
                            "WHERE Code = '" + code + "'";
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()) {
                Country country = new Country();
                country.name = rset.getString("Name");
                country.population = rset.getInt("Population");
                return country;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    // Method structure for many result SQL queries
    // In this case, method is not passed any values but could be if needed
    // String strSelect is created and defined as an SQL query
    // Processes SQL query
    // Returns an ArrayList<Country> called 'countries' with many properties
    public ArrayList<Country> getManyCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Continent, Region "
                            + "FROM country "
                            + "ORDER BY Name ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information into ArrayList<Country>
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
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
                System.out.println("About to display " + countries.size() + " countries");
                int size = countries.size();
                for (int i = 0; i < size; i++) {
                    Country country = countries.get(i);
                    System.out.println(country.name + " " + country.continent);
                }
                System.out.println("Finished displaying countries");
            } else {
                System.out.println("Countries list is NULL!");
            }
        } catch (Exception e) {
            System.out.println("ERROR in displayCountries:");
            e.printStackTrace();
        }
    }

}


