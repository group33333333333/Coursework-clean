package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;

public class queryPopulation {



    // WILL REQUIRE A JOIN SQL QUERY.
    // JOIN CITY ON COUNTRY WHERE city.name = country.capital
    // Method to get all countries ordered by population (descending)
    public static ArrayList<Country> getCountriesByPopulationDesc(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create SQL query to select countries ordered by population
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";

            // Execute SQL query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information into ArrayList<Country>
            ArrayList<Country> countries = new ArrayList<>();

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
            System.out.println("Failed to get countries by population (descending)");
            return null;
        }
    }


}
