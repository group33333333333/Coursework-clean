package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCity {

    public static void MenuCity(Connection con, app a){

        Scanner scanner = new Scanner(System.in);

        // Initialises 'cities' ArrayList for use in operations
        ArrayList<City> cities;

        System.out.println("Select a Cities report:\n\n" +
                "1) All cities in the world, by population\n" +
                "2) All cities in a continent, by population\n" +
                "3) All cities in a region, by population\n" +
                "4) All cities in a country, by population\n" +
                "5) All cities in a district, by population\n" +
                "6) Top X cities in the world, by population\n" +
                "7) Top X cities in a continent, by population\n" +
                "8) Top X cities in a region, by population\n" +
                "9) Top X cities in a country, by population\n" +
                "10) Top X cities in a district, by population\n\n" );


        // CURRENTLY CRASHES UPON NON-INT INPUT
        // WILL NEED VALIDATION
        // Reads user input again and feeds to switch
        int choice = scanner.nextInt();

        // City reports
        switch (choice) {
            case 1:
                cities = queryCity.getManyCityInWorld(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 2:
                cities = queryCity.getManyCityInContinent(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 3:
                cities = queryCity.getManyCityInRegion(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 4:
                cities = queryCity.getManyCityInCountry(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 5:
                cities = queryCity.getManyCityInDistrict(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 6:
                cities = queryCity.getTopCityInWorld(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 7:
                cities = queryCity.getTopCityInContinent(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 8:
                cities = queryCity.getTopCityInRegion(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 9:
                cities = queryCity.getTopCityInCountry(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            case 10:
                cities = queryCity.getTopCityInDistrict(a.con);
                if (cities == null) {
                    System.out.println("Failed to retrieve cities!");
                    return;
                }
                a.displayCities(cities);
                break;
            default:
                System.out.println("Invalid choice!\n\n");
                break;

        }
    }
}
