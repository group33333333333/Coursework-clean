package com.napier.courseworkclean;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {

    @Test //creates a test country and population, then displays it. makes sure countrys can be displayed
    void displayCountry() {
        App app = new App();
        Country c = new Country();
        c.name = "country";
        c.population = 100;

        //display country and pop
        app.displayCountry(c);
    }

    @Test //create a city and call display method. fills array with data about city, also loops through then displays
    void displayCities_withLoop() {
        App app = new App();
        City ed = new City();
        ed.name = "Edinburgh";
        ed.code = "EDI";
        ed.district = "Lothian";
        ed.citypopulation = "500,000";

        //display
        ArrayList<City> cities = new ArrayList<>();
        cities.add(ed);
        app.displayCities(cities);
    }
}
