package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class queryCountry {



    // Method structure for single result SQL queries
    // Method is passed 'code' variable with value "TWN"
    // String strSelect is created and defined as an SQL query
    // Processes SQL query
    // Returns a single Country object 'country'
    // In this case, method only prints Name and Population properties but could print more if needed
    // PROBABLY NOT RELEVANT TO COURSEWORK AS QUERIES NEED MULTIPLE DATA POINTS
    public static Country getCountry(String code, Connection con) {
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
    // In this case, method is passed app connection and no other parameters
    // String strSelect is created and passed to method 'exeQueryCountry()'
    // Method creates SQL query with String strSelect and processes SQL query
    // Returns an ArrayList<Country> called 'countries' with many properties
    // ArrayList is automatically ordered by 'Population' by SQL query
    public static ArrayList<Country> getManyCountryInWorld(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            return exeQueryCountry(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    // Method to return all countries in a continent
    public static ArrayList<Country> getManyCountryInContinent(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the continent you would like to query:");
        String input = scanner.nextLine();

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = '" + input + "'"
                            + "ORDER BY Population DESC";
            return exeQueryCountry(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    // Method to return all countries in a region
    public static ArrayList<Country> getManyCountryInRegion(Connection con)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the region you would like to query:");
        String input = scanner.nextLine();

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Region = '" + input + "'"
                            + "ORDER BY Population DESC";
            return exeQueryCountry(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    // Method to return top 'X' countries in the world
    public static ArrayList<Country> getTopCountryInWorld(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of countries to display:");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + inputNum + "";
            return exeQueryCountry(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    // Method to return top 'X' countries in a continent
    public static ArrayList<Country> getTopCountryInContinent(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the continent you would like to query:");
        String input = scanner.nextLine();

        System.out.println("Enter the number of countries to display:");
        int inputNum = scanner.nextInt();

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = '" + input + "'"
                            + "ORDER BY Population DESC "
                            + "LIMIT " + inputNum + "";
            return exeQueryCountry(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    // Method to return top 'X' countries in a region
    public static ArrayList<Country> getTopCountryInRegion(Connection con)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the region you would like to query:");
        String input = scanner.nextLine();

        System.out.println("Enter the number of countries to display:");
        int inputNum = scanner.nextInt();

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Region = '" + input + "'"
                            + "ORDER BY Population DESC "
                            + "LIMIT " + inputNum + "";
            return exeQueryCountry(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    // Method to process SQL queries
    // Is passed String strSelect and returns ArrayList<Country> 'countries'
    public static ArrayList<Country> exeQueryCountry(String strSelect, Connection con) throws SQLException
    {
        // Creates ArrayList<Country> to store properties of objects
        ArrayList<Country> countries = new ArrayList<Country>();

        // Try with resources to automatically close resources when finished
        try (Statement stmt = con.createStatement();
             ResultSet rset = stmt.executeQuery(strSelect))
        {
            // Repeats for length of returned SQL result set
            // Adds all properties retrieved into ArrayList<Country> 'countries'
            while (rset.next())
            {
                // Creates objects and assigns values to its properties
                // Adds to ArrayList countries
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
        }

        return countries;
    }

}

