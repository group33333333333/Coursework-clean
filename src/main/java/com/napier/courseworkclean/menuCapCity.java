package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCapCity {

    public static void MenuCapCity(Connection con, App a) {

        Scanner scanner = new Scanner(System.in);

        // Initialises 'cities' ArrayList for use in operations
        ArrayList<City> capCities;

        System.out.println("Select a Cities report:\n\n" +
                "1) All capital cities in the world, by population\n" +
                "2) All capital cities in a continent, by population\n" +
                "3) All capital cities in a region, by population\n" +
                "4) Top 'X' capital cities in the world, by population\n" +
                "5) Top 'X' capital cities in a continent, by population\n" +
                "6) Top 'X' capital cities in a region, by population\n\n");


        // CURRENTLY CRASHES UPON NON-INT INPUT
        // WILL NEED VALIDATION
        // Reads user input again and feeds to switch
        int choice = scanner.nextInt();

        // City reports
        switch (choice) {
            case 1:
                capCities = queryCapCity.getManyCapCityInWorld(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            case 2:
                capCities = queryCapCity.getManyCapCityInContinent(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            case 3:
                capCities = queryCapCity.getManyCapCityInRegion(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            case 4:
                capCities = queryCapCity.getTopCapCityInWorld(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            case 5:
                capCities = queryCapCity.getTopCapCityInContinent(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            case 6:
                capCities = queryCapCity.getTopCapCityInRegion(a.con);
                if (capCities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCapCities(capCities);
                break;

            default:
                System.out.println("Invalid choice!\n\n");
                break;


        }
    }
}