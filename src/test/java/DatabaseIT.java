package com.napier.courseworkclean;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseIT {

    @Test
    void canStartDatabaseAndConnect() throws Exception {
        try (MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
                .withDatabaseName("testdb")
                .withUsername("root")
                .withPassword("testpass")) {

            mysql.start();

            try (Connection con = DriverManager.getConnection(
                    mysql.getJdbcUrl(),
                    mysql.getUsername(),
                    mysql.getPassword()
            )) {
                assertNotNull(con);
                assertFalse(con.isClosed(), "Connection should be open");

                try (PreparedStatement stmt = con.prepareStatement("SELECT 1");
                     ResultSet rs = stmt.executeQuery()) {

                    assertTrue(rs.next(), "Should have one row");
                    assertEquals(1, rs.getInt(1), "SELECT 1 should return 1");
                }
            }
        }
    }

    @Test
    void canCreateAndQueryTable() throws Exception {
        try (MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
                .withDatabaseName("testdb")
                .withUsername("root")
                .withPassword("testpass")) {

            mysql.start();

            try (Connection con = DriverManager.getConnection(
                    mysql.getJdbcUrl(),
                    mysql.getUsername(),
                    mysql.getPassword()
            )) {
                assertNotNull(con);

                try (PreparedStatement create = con.prepareStatement(
                        "CREATE TABLE person (" +
                                "id INT PRIMARY KEY, " +
                                "name VARCHAR(50)" +
                                ")"
                )) {
                    create.executeUpdate();
                }

                try (PreparedStatement insert = con.prepareStatement(
                        "INSERT INTO person (id, name) VALUES (?, ?)"
                )) {
                    insert.setInt(1, 1);
                    insert.setString(2, "Reiss");
                    insert.executeUpdate();
                }

                try (PreparedStatement select = con.prepareStatement(
                        "SELECT name FROM person WHERE id = ?"
                )) {
                    select.setInt(1, 1);
                    try (ResultSet rs = select.executeQuery()) {
                        assertTrue(rs.next(), "Row should exist");
                        assertEquals("Reiss", rs.getString("name"));
                    }
                }
            }
        }
    }
}
