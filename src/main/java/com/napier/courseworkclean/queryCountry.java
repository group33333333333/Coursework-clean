package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;

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
    // String strSelect is created and defined as an SQL query
    // Processes SQL query
    // Returns an ArrayList<Country> called 'countries' with many properties
    public static ArrayList<Country> getManyCountry(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Name ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information into ArrayList<Country>
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

}

