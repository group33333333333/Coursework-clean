package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;

public class queryCity {


    // Method structure for many result SQL queries
    // In this case, method is passed connection to app and no additional parameters
    // String strSelect is created and defined as an SQL query
    // Processes SQL query
    // Returns an ArrayList<City> called 'cities' with many properties
    public static ArrayList<City> getManyCity(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + "FROM city "
                            + "ORDER BY Name ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information into ArrayList<City>
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("Name");
                city.code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.citypopulation = rset.getString("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

}
