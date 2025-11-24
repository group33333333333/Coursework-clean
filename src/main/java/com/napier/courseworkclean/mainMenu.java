package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.Scanner;

/** Class representing the first page of menu UI system
 *  Contains one method with a choice of menus to progress to depending on user input
 *  Method establishes while loop for continuity of menu UI
 *  While loop is broken by selecting '6' and user returns to 'App' class to disconnect from database
 */
public class mainMenu {

    /**
     * Method to read user input and select relevant menu UI
     * Redirects to other menus with SQL query methods
     * @param con
     * @param a
     */
    public static void Menu(Connection con, App a)
    {
        Scanner scanner = new Scanner(System.in);

        // Establishing while loop around menu system so menu returns to start
        boolean menuOn = true;
        while(menuOn){

            // First line of menu
            System.out.println("Which reports would you like to view? Enter a number:\n\n" +
                    "1) Country reports\n" +
                    "2) City reports\n" +
                    "3) Capital city reports\n" +
                    "4) Population reports\n" +
                    "5) Language reports\n" +
                    "6) Exit Program\n\n");


            // Reads user input
            // CURRENTLY CRASHES UPON NON-INT INPUT
            // WILL NEED VALIDATION
            int choice = scanner.nextInt();


            // User input is fed into switch statement
            switch (choice) {

                // Connects to 'Countries' menu
                case 1:
                    menuCountry.MenuCountry(a.con, a);
                    break;

                // Connects to 'Cities' menu
                case 2:
                    menuCity.MenuCity(a.con, a);
                    break;

                // Connects to 'Capital Cities' menu
                case 3:
                    menuCapCity.MenuCapCity(a.con, a);
                    break;

                // Connects to 'Languages' menu
                // TO BE IMPLEMENTED
                case 4:
                    break;

                // Connects to 'Population' menu
                // TO BE IMPLEMENTED
                case 5:
                    break;

                // Breaks while loop and returns to 'App'
                case 6:
                    // Disconnects from SQL database
                    // Do not remove!
                    // INPUT METHOD BACK TO MAIN TO DISCONNECT AND END PROGRAM RUN
                    menuOn = false;
                    break;

                // Displays error message when invalid int input is entered
                default:
                    System.out.println("Invalid choice!\n\n");

            }
        }
    }
}