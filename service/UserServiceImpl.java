package com.whatsapp.service;

import com.whatsapp.model.User;

import java.util.Set;
import java.util.HashSet;

/**
 * Implements the service interface and provides the whatsApp functionality
 *
 * @version 1.0
 * @author Anisha Brightlin
 */
public class UserServiceImpl implements UserService {

    private final Set<User> userList = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public String signUp(final User user) {
        userList.add(user);

        return user.getMobileNumber();
    }

    /**
     * {@inheritDoc}
     */
    public User getUserDetails(final String mobileNumber) {
        User foundUser = null;

        for (User user : userList) {
            if (user.getMobileNumber().equals(mobileNumber)) {
                foundUser = user;
                break;
            }
        }

        if (foundUser != null) {
            return foundUser;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean signIn(final String mobileNumber) {
        for (final User user : userList) {

            if (user.getMobileNumber().equals(mobileNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isUpdatedProfile(final User user) {

        for (final User existingUser : userList ) {

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
        return userList.removeIf(user -> user.getMobileNumber().equals(mobileNumber));
    }
}