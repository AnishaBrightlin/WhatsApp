package com.whatsapp.service;

import com.whatsapp.model.User;

import java.util.Set;
import java.util.HashSet;

/**
 * Implements the service interface and provides the whatsApp functionality
 *
 * @see com.whatsapp.service.UserService
 * @author Anisha Brightlin
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private final Set<User> userSet = new HashSet<>();

    /**
     * {@inheritDoc}
     * @param user the user object containing the user details
     * @return true if the user is added to the list else false
     */
    public boolean signUp(final User user) {
        return userSet.add(user);
    }

    /**
     * {@inheritDoc}
     * @param mobileNumber get the id from the mobile number
     * @return userId
     */
    public long getUserId(final String mobileNumber) {
        for (final User user : userSet) {

            if (user.getMobileNumber().equals(mobileNumber)) {
                return user.getId();
            }
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     * @param mobileNumber the user object to check
     * @return true if the mobile number is already exist in the list else false
     */
    public boolean signIn(final String mobileNumber) {

        for (final User user : userSet) {

            if (user.getMobileNumber().equals(mobileNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @param id
     * @return the user object
     */
    public User getUserDetails(final long id) {

        for (User user : userSet) {

            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * @param user the user object containing the updated user details
     * @return true if the user object is updated else false
     */
    public boolean isUpdateProfile(final User user) {

        for (final User existingUser : userSet) {

            if (existingUser.getMobileNumber().equals(user.getMobileNumber())) {
                existingUser.setName(existingUser.getName());
                existingUser.setDateOfBirth(user.getDateOfBirth());

                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @param currentId the mobile number of the user account to delete
     * @return true if the given user id is existing in the list else false
     */
    public boolean deleteAccount(final long currentId) {
        return userSet.removeIf(user -> user.getId() == currentId);
    }
}