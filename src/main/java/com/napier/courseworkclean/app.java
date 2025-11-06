package com.napier.courseworkclean;

import java.sql.*;

public class app {
    // Class-level connection
    private Connection con = null;

    public static void main(String[] args) {
        app a = new app();
        a.connect();

        Country country = a.getCountry("TWN");
        a.displayCountry(country);

        a.disconnect();
    }

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
                country.name = rset.getString("Name");        // Changed to "Name"
                country.population = rset.getInt("Population"); // Changed to "Population"
                return country;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountry(Country country) {
        if (country != null) {
            System.out.println(country.name + " " + country.population);
        }
    }
}



