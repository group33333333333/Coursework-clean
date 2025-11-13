package com.napier.courseworkclean;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class queryCapCity {


    // Method structure for many result SQL queries
    // In this case, method is passed connection to app and no additional parameters
    // String strSelect is created and passed to method exeQueryCity()
    // Method generates and processes SQL query
    // Returns an ArrayList<City> called 'cities' with many properties
    public static ArrayList<City> getManyCapCityInWorld(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCapCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // Method to return all capital cities in a continent
    public static ArrayList<City> getManyCapCityInContinent(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the continent you would like to query:\n");
        String input = scanner.nextLine();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital AND country.Continent = '" + input + "'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCapCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // Method to return all capital cities in a region
    public static ArrayList<City> getManyCapCityInRegion(Connection con)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the region you would like to query:\n");
        String input = scanner.nextLine();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital AND country.Region = '" + input + "'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCapCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // Method to return top 'X' capital cities in the world
    public static ArrayList<City> getTopCapCityInWorld(Connection con)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of capital cities to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";
            // Execute SQL statement
            return exeQueryCapCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // Method to return top 'X' capital cities in a continent
    public static ArrayList<City> getTopCapCityInContinent(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the continent you would like to query:\n");
        String input = scanner.nextLine();

        System.out.println("Enter the number of capital cities to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital AND country.Continent = '" + input + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";
            // Execute SQL statement
            return exeQueryCapCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // Method to return top 'X' capital cities in a region
    public static ArrayList<City> getTopCapCityInRegion(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the region you would like to query:\n");
        String input = scanner.nextLine();

        System.out.println("Enter the number of capital cities to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital AND country.Region = '" + input + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";
            // Execute SQL statement
            return exeQueryCapCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }







    // Method to process SQL queries
    // Is passed String strSelect and returns ArrayList<City> 'capCities'
    public static ArrayList<City> exeQueryCapCity(String strSelect, Connection con) throws SQLException
    {
        // Creates ArrayList<City> to store properties of objects
        ArrayList<City> capCities = new ArrayList<City>();

        // Try with resources to automatically close resources when finished
        try (Statement stmt = con.createStatement();
             ResultSet rset = stmt.executeQuery(strSelect))
        {
            // Repeats for length of returned SQL result set
            // Adds all properties retrieved into ArrayList<City> 'capCities'
            while (rset.next())
            {
                // Creates objects and assigns values to its properties
                // Adds to ArrayList cities
                City city = new City();
                city.name = rset.getString("city.Name");
                city.code = rset.getString("country.Name");
                city.citypopulation = rset.getString("city.Population");
                capCities.add(city);
            }
        }

        return capCities;
    }
}
