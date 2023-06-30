package com.whatsapp.DAO.impl;

import com.whatsapp.DAO.DAOUserService;
import com.whatsapp.DAO.DBConnection;

import com.whatsapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <p>
 * Provides the DAO user functionalities.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see DAOUserService
 */
public class DAOUserServiceImpl implements DAOUserService {

    private static final DAOUserService DAO_SERVICE = new DAOUserServiceImpl();
    private static final DBConnection DB_CONNECTION = DBConnection.getInstance();

    private DAOUserServiceImpl() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link DAOUserServiceImpl} instance.
     */
    public static DAOUserService getInstance() {
        return DAO_SERVICE;
    }

    /**
     * {@inheritDoc}
     *
     * @param user Represents the {@link User}
     * @return true if the user is sign up else false
     */
    public boolean signUp(final User user) {

        if (!isExistUser(user)) {
            try {
                final Connection connection = DB_CONNECTION.getConnection();
                final PreparedStatement statement = connection.prepareStatement("Insert into user (name, dateOfBirth, mobileNumber, about) values(?, ?, ?, ?)");

                statement.setString(1, user.getName());
                statement.setString(2, user.getDateOfBirth());
                statement.setString(3, user.getMobileNumber());
                statement.setString(4, user.getAbout());
                statement.execute();

                return true;
            } catch (final Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param mobileNumber Represents the {@link User} mobile number
     * @return true if the user is sign in else false
     */
    public boolean signIn(final String mobileNumber) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement statement = connection.prepareStatement("Select mobileNumber from user where mobileNumber = ?");

            statement.setString(1, mobileNumber);
            final ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * Checks the user is existing.
     *
     * @param user Represents the {@link User}
     * @return true if the user is existing else false
     */
    public boolean isExistUser(final User user) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement statement = connection.prepareStatement("Select mobileNumber from user where mobileNumber = ?");

            statement.setString(1, user.getMobileNumber());
            final ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param mobileNumber Represents the {@link User} mobile number
     * @return user id
     */
    public long getUserId(final String mobileNumber) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement statement = connection.prepareStatement("Select id from user where mobileNumber = ?");

            statement.setString(1, mobileNumber);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     *
     * @param userId Represents the {@link User}
     * @return the {@link User}
     */
    public User getUserDetails(final long userId) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement statement = connection.prepareStatement("Select * from user where id = ?");

            statement.setLong(1, userId);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                final User userDetails = new User();

                userDetails.setId(resultSet.getInt("id"));
                userDetails.setName(resultSet.getString("name"));
                userDetails.setDateOfBirth(resultSet.getString("dateOfBirth"));
                userDetails.setMobileNumber(resultSet.getString("mobileNumber"));
                userDetails.setAbout(resultSet.getString("about"));

                return userDetails;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param user Represents the {@link User}
     * @return true if the profile is updated else false
     */
    public boolean isUpdateProfile(final User user) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement statement = connection.prepareStatement("Update user set name = ?, dateOfBirth = ?, about = ? where id = ?");

            statement.setString(1, user.getName());
            statement.setString(2, user.getDateOfBirth());
            statement.setString(3, user.getAbout());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the {@link User} id
     * @return true if the account is deleted else false
     */
    public boolean isAccountDeleted(final long id) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement statement = connection.prepareStatement("Delete from user where id = ?");

            statement.setLong(1, id);
            final int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}