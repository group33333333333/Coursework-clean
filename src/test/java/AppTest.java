package com.napier.courseworkclean;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {

    @Test
    void displayCountries_null_doesNotCrash() {
        App app = new App();
        app.displayCountries(null);
    }

    @Test
    void displayCities_null_doesNotCrash() {
        App app = new App();
        app.displayCities(null);
    }

    @Test
    void displayCountry_valid_prints() {
        App app = new App();
        Country c = new Country();
        c.name = "test";
        c.population = 1;
        app.displayCountry(c);
    }

    @Test
    void displayCities_withData_runsLoop() {
        App app = new App();

        City ed = new City();
        ed.name = "E";
        ed.code = "EEE";
        ed.district = "ELAND";
        ed.citypopulation = "8";

        ArrayList<City> cities = new ArrayList<>();
        cities.add(ed);

        app.displayCities(cities);
    }

    @Test
    void disconnect_safeWhenNull() {
        App app = new App();
        app.disconnect();
    }
}
