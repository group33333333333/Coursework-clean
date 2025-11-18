package com.napier.courseworkclean;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    @Test
    void getManyCountries() throws Exception {

        //start a database to test
        try (MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
                .withDatabaseName("test")
                .withUsername("user")
                .withPassword("password")) {

            mysql.start();
            //connect to data base using the info above
            try (Connection con = DriverManager.getConnection(
                    mysql.getJdbcUrl(),
                    mysql.getUsername(),
                    mysql.getPassword()
            )) {

                //country table for testing
                con.createStatement().execute(
                        "CREATE TABLE country (" +
                                "Code CHAR(3)," +
                                "Name CHAR(99)," +
                                "Continent CHAR(99)," +
                                "Region CHAR(99)," +
                                "Population INT," +
                                "Capital INT)"
                );

                //insert country to test
                con.createStatement().execute(
                        "INSERT INTO country VALUES " +
                                "('SCO','Scotland','Europe','UK','5546900',1)"
                );

                //call query method
                ArrayList<Country> countries = queryCountry.getManyCountryInWorld(con);

                assertNotNull(countries);
                assertEquals(1, countries.size());
                assertEquals("Scotland", countries.get(0).name);
            }
        }
    }
}
