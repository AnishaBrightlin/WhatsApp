package com.whatsapp.DAO.impl;

import com.whatsapp.DAO.DAOStatusService;
import com.whatsapp.DAO.DAOUserService;
import com.whatsapp.DAO.DBConnection;

import com.whatsapp.model.Status;
import com.whatsapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Provides the DAO status functionalities.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see DAOUserService
 */
public class DAOStatusServiceImpl implements DAOStatusService {

    private static final DAOStatusService DAO_SERVICE = new DAOStatusServiceImpl();
    private static final DBConnection DB_CONNECTION = DBConnection.getInstance();

    private DAOStatusServiceImpl() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link DAOUserServiceImpl} instance.
     */
    public static DAOStatusService getInstance() {
        return DAO_SERVICE;
    }

    /**
     * {@inheritDoc}
     *
     * @param status Represents the {@link Status}
     * @return true if status is uploaded else false
     */
    public boolean isStatusUploaded(final Status status) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement statement = connection.prepareStatement("Insert into status (userID, format, caption, uploadedTime) values(?, ?, ?, ?)");

            statement.setLong(1, status.getUserId());
            statement.setString(2, String.valueOf(status.getFormat()));
            statement.setString(3, status.getCaption());
            statement.setString(4, String.valueOf(status.getStatusTime()));
            statement.execute();

            return true;
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the {@link User}
     * @return list of status
     */
    public List<Status> getStatusList(final long id) {

        final List<Status> statuses = new ArrayList<>();

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("Select s.id, s.uploadedTime, s.caption from status s inner join user u ON s.userId = u.id where u.id = ?");

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                final long statusId = resultSet.getLong("id");
                final String uploadedTime = resultSet.getString("uploadedTime");
                final String caption = resultSet.getString("caption");
                final Status status = new Status();

                status.setStatusId(statusId);
                status.setUploadedTime(uploadedTime);
                status.setCaption(caption);
                statuses.add(status);
            }
            return statuses;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user
     * @return list of status id
     */
    public List<Long> getStatusIdList(final long id) {

        final List<Long> userIds = new ArrayList<>();

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("Select distinct userid from status where userId != ?");

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Long userId = resultSet.getLong("userId");

                userIds.add(userId);
            }
            return userIds;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user
     * @return true if the id is existing else false
     */
    public boolean isIdExist(final long id) {

        try {
            final Connection connection = DB_CONNECTION.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("Select id from user where id = ?");

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}