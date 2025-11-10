package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;

public class app {
    // Class-level connection
    public Connection con = null;

    public static void main(String[] args) {

        // Instantiates app container and connects to SQL database
        // Do not remove!!!
        app a = new app();
        a.connect();

        // Calls getManyCity method from class CityQueries and returns ArrayList<City> 'cities'
        // Contains list of City objects and associated properties
        ArrayList<City> cities = queryCity.getManyCity(a.con);
        if (cities == null) {
            System.out.println("Failed to retrieve cities!");
            return;
        }
        // Calls displayCities method when passed ArrayList<City> 'cities'
        // ArrayList is iterated through a for loop of ArrayList length and printed
        a.displayCities(cities);

        // Call getCountry method from CountryQueries class, passing the connection from app
        Country country = queryCountry.getCountry("TWN", a.con);
        a.displayCountry(country);


        // Calls getManyCountry method and returns ArrayList<Country> 'countries'
        // Contains list of Country objects and associated properties
        ArrayList<Country> countries = queryCountry.getManyCountry(a.con);
        if (countries == null) {
            System.out.println("Failed to retrieve countries!");
            return;
        }
        // Calls displayCountries method when passed ArrayList<Country> 'countries'
        // ArrayList is iterated through a for loop of ArrayList length and printed
        a.displayCountries(countries);


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
                System.out.println("About to display " + countries.size() + " countries \n");

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
                System.out.println("\nFinished displaying " + countries.size() + " countries");
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

    /**
     * --------------------------------------New for countries by dec pop-------------------------------------------------------------------
     */
    // Call the method to get all countries ordered by population descending
    ArrayList<Country> countriesByPop = queryCountry.getCountriesByPopulationDesc(a.con);


    // Check that the query worked
    if (countriesByPop == null) {

        System.out.println("Failed to retrieve countries by population (descending)!");
        return;
    }

    // Display results (you can use your new display method or the existing one)
    a.displayCountriesByPopulation(countriesByPop);


    // Method to display ArrayList<Country> 'countries'
// Prints only Name and Population, sorted in descending order by SQL query
    public void displayCountriesByPopulation(ArrayList<Country> countries) {
        try {
            if (countries != null) {
                System.out.println("About to display " + countries.size() + " countries by population (descending)\n");

                System.out.println(String.format("%-50s %-20s", "Country Name", "Population"));
                System.out.println("-------------------------------------------------------------");

                for (Country country : countries) {
                    String country_string = String.format("%-50s %-20s", country.name, country.population);
                    System.out.println(country_string);
                }

                System.out.println("\nFinished displaying " + countries.size() + " countries by population.");
            } else {
                System.out.println("Countries list is NULL!");
            }
        } catch (Exception e) {
            System.out.println("ERROR in displayCountriesByPopulation:");
            e.printStackTrace();
        }
    }



}
