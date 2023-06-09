package com.whatsapp.service;

import com.whatsapp.model.User;

import java.util.Set;
import java.util.HashSet;

/**
 * Implements the service interface and provides the whatsApp functionality
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private final Set<User> userSet = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    public boolean signUp(final User user) {
        return userSet.add(user);
    }

    /**
     * {@inheritDoc}
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
     */
    public User getUserDetails(final int id) {

        for (User user : userSet) {

            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isUpdatedProfile(final User user) {

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
     */
    public boolean deleteAccount(final String mobileNumber) {
        return userSet.removeIf(user -> user.getMobileNumber().equals(mobileNumber));
    }
}