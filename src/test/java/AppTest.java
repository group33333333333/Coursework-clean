package com.napier.courseworkclean;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class AppTest {

    @Test
        //creates a test country and population, then displays it. makes sure countrys can be displayed
    void displayCountry() {
        App app = new App();
        Country c = new Country();
        c.name = "country";
        c.population = 100;

        //display country and pop
        app.displayCountry(c);
    }

    @Test
        //create a city and call display method. fills array with data about city, also loops through then displays
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

    private void setInput(String s) {
        System.setIn(new ByteArrayInputStream((s + "\n").getBytes()));
    }

    @Test
    void appNullCasesAndToStrings() {
        App app = new App();

        //display checks
        app.displayCountry(null);
        app.displayCountries(null);
        app.displayCities(null);
        app.displayCapCities(null);

        Country c = new Country();
        c.code = "GBR";
        c.name = "United Kingdom";
        c.continent = "Europe";
        c.population = 70000000;
        c.capital = "London";
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(c);
        app.displayCountries(countries);

        City cap = new City();
        cap.name = "London";
        cap.code = "GBR";
        cap.citypopulation = "8000000";
        ArrayList<City> caps = new ArrayList<>();
        caps.add(cap);
        app.displayCapCities(caps);

        app.con = null;
        app.disconnect();

        City city = new City();
        city.toString();
        Country country = new Country();
        country.toString();
        Language lang = new Language();
        lang.toString();
    }

    @Test
    void mainAndSimpleMenus() {
        App app = new App();
        app.con = null;

        setInput("99\n4\n5\n6\n");
        mainMenu.Menu(null, app);

        menuLanguage mLang = new menuLanguage();
        menuPopulation mPop = new menuPopulation();
    }

    @Test
    void cityCountryCapMenus_invalidAndOption1() {
        App app = new App();
        app.con = null;

        setInput("99");
        menuCity.MenuCity(null, app);
        setInput("1");
        menuCity.MenuCity(null, app);

        setInput("99");
        menuCountry.MenuCountry(null, app);
        setInput("1");
        menuCountry.MenuCountry(null, app);

        setInput("99");
        menuCapCity.MenuCapCity(null, app);
        setInput("1");
        menuCapCity.MenuCapCity(null, app);
    }

    @Test
    void queryCity_allMethods_nullCon() {
        queryCity.getManyCityInWorld(null);

        setInput("Europe");
        queryCity.getManyCityInContinent(null);

        setInput("Western Europe");
        queryCity.getManyCityInRegion(null);

        setInput("United Kingdom");
        queryCity.getManyCityInCountry(null);

        setInput("Edinburgh");
        queryCity.getManyCityInDistrict(null);

        setInput("3");
        queryCity.getTopCityInWorld(null);

        setInput("Europe\n3");
        queryCity.getTopCityInContinent(null);

        setInput("Western Europe\n3");
        queryCity.getTopCityInRegion(null);

        setInput("United Kingdom\n3");
        queryCity.getTopCityInCountry(null);

        setInput("Edinburgh\n3");
        queryCity.getTopCityInDistrict(null);
    }

    @Test
    void queryCountry_allMethods_nullCon() {
        queryCountry.getCountry("AAA", null);
        queryCountry.getManyCountryInWorld(null);

        setInput("Europe");
        queryCountry.getManyCountryInContinent(null);

        setInput("Western Europe");
        queryCountry.getManyCountryInRegion(null);

        setInput("3");
        queryCountry.getTopCountryInWorld(null);

        setInput("Europe\n3");
        queryCountry.getTopCountryInContinent(null);

        setInput("Western Europe\n3");
        queryCountry.getTopCountryInRegion(null);
    }

    @Test
    void queryCapCity_allMethods_nullCon() {
        queryCapCity.getManyCapCityInWorld(null);

        setInput("Europe");
        queryCapCity.getManyCapCityInContinent(null);

        setInput("Western Europe");
        queryCapCity.getManyCapCityInRegion(null);

        setInput("3");
        queryCapCity.getTopCapCityInWorld(null);

        setInput("Europe\n3");
        queryCapCity.getTopCapCityInContinent(null);

        setInput("Western Europe\n3");
        queryCapCity.getTopCapCityInRegion(null);
    }
}
