package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCountry {

    public static void MenuCountry(Connection con, app a) {

        Scanner scanner = new Scanner(System.in);

        // Initialises 'countries' ArrayList for use in operations
        ArrayList<Country> countries;
        System.out.println("Select a Countries report:\n\n" +
                "1) All countries in the world, by population\n" +
                "2) All countries in a continent, by population\n" +
                "3) All countries in a region, by population\n" +
                "4) Top X countries in the world, by population\n" +
                "5) Top X countries in a continent, by population\n" +
                "6) Top X countries in a region, by population\n\n");

        // CURRENTLY CRASHES UPON NON-INT INPUT
        // WILL NEED VALIDATION
        // Reads user input again and feeds to switch
        int choice = scanner.nextInt();

        // Country reports
        switch (choice) {
            case 1:
                countries = queryCountry.getManyCountryInWorld(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;
            case 2:
                countries = queryCountry.getManyCountryInContinent(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;
            case 3:
                countries = queryCountry.getManyCountryInRegion(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;
            case 4:
                countries = queryCountry.getTopCountryInWorld(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;
            case 5:
                countries = queryCountry.getTopCountryInContinent(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;
            case 6:
                countries = queryCountry.getTopCountryInRegion(a.con);
                if (countries == null) {
                    System.out.println("Failed to retrieve countries!");
                    return;
                }
                a.displayCountries(countries);
                break;
            default:
                System.out.println("Invalid choice!\n\n");
                break;

        }

    }
}
