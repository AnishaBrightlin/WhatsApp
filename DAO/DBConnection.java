package com.whatsapp.DAO;

import com.whatsapp.controller.UserController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>
 * Provides the DB connection
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class DBConnection {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    private DBConnection() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link UserController} instance.
     */
    public static DBConnection getInstance() {
        return DB_CONNECTION;
    }

    /**
     * <p>
     * Gets the DB connection.
     * </p>
     *
     * @return the {@link Connection}
     * @throws ClassNotFoundException if the class is not found
     * @throws SQLException  if there is an exception in sql query
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://Localhost:3306/whatsApp", "root", "1234");
    }
}