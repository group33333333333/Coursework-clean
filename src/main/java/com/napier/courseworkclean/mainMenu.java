package com.napier.courseworkclean;

import java.sql.Connection;
import java.util.Scanner;

public class mainMenu {

    public static void Menu(Connection con, app a)
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


                case 1:
                    menuCountry.MenuCountry(a.con, a);
                    break;

                case 2:
                    menuCity.MenuCity(a.con, a);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    // Disconnects from SQL database
                    // Do not remove!
                    // INPUT METHOD BACK TO MAIN TO DISCONNECT AND END PROGRAM RUN
                    menuOn = false;
                    break;
                default:
                    System.out.println("Invalid choice!\n\n");

                    menuOn = false;
                    break;
            }
        }
    }
}