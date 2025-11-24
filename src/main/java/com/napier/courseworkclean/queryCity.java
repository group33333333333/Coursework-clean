package com.napier.courseworkclean;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class detailing all methods related to querying Cities via SQL
 * Contains 10 methods to generate SQL methods, and 1 to universally process them
 * Final method returns ArrayList<City> cities
 */
public class queryCity {


    /**
     *  Method structure for many result SQL queries
     *  Returns all cities in the world
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getManyCityInWorld(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns all cities in a continent
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getManyCityInContinent(Connection con)
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
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Continent = '" + input + "'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns all cities in a region
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getManyCityInRegion(Connection con)
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
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Region = '" + input + "'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns all cities in a country
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getManyCityInCountry(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the country you would like to query:\n");
        String input = scanner.nextLine();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Name = '" + input + "'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns all cities in a district
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getManyCityInDistrict(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the district you would like to query:\n");
        String input = scanner.nextLine();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND city.District = '" + input + "'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns top X cities in the world
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getTopCityInWorld(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of countries to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns top X cities in a continent
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getTopCityInContinent(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the continent you would like to query:\n");
        String input = scanner.nextLine();

        System.out.println("Enter the number of countries to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Continent = '" + input + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";;
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns top X cities in a region
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getTopCityInRegion(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the region you would like to query:\n");
        String input = scanner.nextLine();

        System.out.println("Enter the number of countries to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Region = '" + input + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns top X cities in a country
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getTopCityInCountry(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the country you would like to query:\n");
        String input = scanner.nextLine();

        System.out.println("Enter the number of countries to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Name = '" + input + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     *  Method structure for many result SQL queries
     *  Returns top X cities in a district
     *  In this case, method is passed connection to app and no additional parameters
     *  String strSelect is created and passed to method exeQueryCity()
     *  Method generates and processes SQL query
     *  Returns an ArrayList<City> called 'cities' with many properties
     * @param con
     * @return cities
     */
    public static ArrayList<City> getTopCityInDistrict(Connection con)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the district you would like to query:\n");
        String input = scanner.nextLine();

        System.out.println("Enter the number of countries to display:\n");
        int inputNum = scanner.nextInt();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND city.District = '" + input + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + inputNum + "";
            // Execute SQL statement
            return exeQueryCity(strSelect, con);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     * Method to process generated SQL queries
     * Is passed String strSelect and connection to app and returns ArrayList<City> 'cities'
     * @param strSelect
     * @param con
     * @return
     * @throws SQLException
     */
    public static ArrayList<City> exeQueryCity(String strSelect, Connection con) throws SQLException
    {
        // Creates ArrayList<City> to store properties of objects
        ArrayList<City> cities = new ArrayList<City>();

        // Try with resources to automatically close resources when finished
        try (Statement stmt = con.createStatement();
             ResultSet rset = stmt.executeQuery(strSelect))
        {
            // Repeats for length of returned SQL result set
            // Adds all properties retrieved into ArrayList<City> 'cities'
            while (rset.next())
            {
                // Creates objects and assigns values to its properties
                // Adds to ArrayList cities
                City city = new City();
                city.name = rset.getString("city.Name");
                city.code = rset.getString("country.Name");
                city.district = rset.getString("city.District");
                city.citypopulation = rset.getString("city.Population");
                cities.add(city);
            }
        }

        return cities;
    }

}


