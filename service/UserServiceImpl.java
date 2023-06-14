package com.whatsapp.service;

import com.whatsapp.model.User;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Implements the user service interface and provides the whatsApp functionality
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see com.whatsapp.service.UserService
 */
public class UserServiceImpl implements UserService {

    private final Set<User> userSet = new HashSet<>();

    /**
     * {@inheritDoc}
     *
     * @param user object containing the user details
     * @return true if the user is added to the list else false
     */
    public boolean signUp(final User user) {
        return userSet.add(user);
    }

    /**
     * {@inheritDoc}
     *
     * @param mobileNumber get the id from the mobile number
     * @return userId of the current user
     */
    public long getUserId(final String mobileNumber) {
        final Iterator<User> iterator = userSet.iterator();

        while (iterator.hasNext()) {
            final User user = iterator.next();

            if (user.getMobileNumber().equals(mobileNumber)) {
                return user.getId();
            }
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     *
     * @param mobileNumber of the user object to check
     * @return true if the mobile number is already exist in the list else false
     */
    public boolean signIn(final String mobileNumber) {
        final Iterator<User> iterator = userSet.iterator();

        while (iterator.hasNext()) {
            final User user = iterator.next();

            if (user.getMobileNumber().equals(mobileNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param id of the current user
     * @return the user object
     */
    public User getUserDetails(final long id) {
        final Iterator<User> iterator = userSet.iterator();

        while (iterator.hasNext()) {
            final User user = iterator.next();

            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param user object containing the updated user details
     * @return true if the user object is updated else false
     */
    public boolean isUpdateProfile(final User user) {
        final Iterator<User> iterator = userSet.iterator();

        while (iterator.hasNext()) {
            final User existingUser = iterator.next();

            if (existingUser.getMobileNumber().equals(user.getMobileNumber())) {
                existingUser.setName(user.getName());
                existingUser.setDateOfBirth(user.getDateOfBirth());

                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param currentId of the user account to delete
     * @return true if the given user id is existing in the list else false
     */
    public boolean deleteAccount(final long currentId) {
        return userSet.removeIf(user -> user.getId() == currentId);
    }
}