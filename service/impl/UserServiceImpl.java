package com.whatsapp.service.impl;

import com.whatsapp.model.User;
import com.whatsapp.service.UserService;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Provides the {@link User} functionalities.
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see com.whatsapp.service.UserService
 */
public class UserServiceImpl implements UserService {

    private static final UserService USER_SERVICE = new UserServiceImpl();
    private final Set<User> userSet = new HashSet<>();

    private UserServiceImpl() {}

    /**
     * <p>
     * Gets the instance of the class.
     *</p>
     * @return the {@link UserService} instance.
     */
    public static UserService getInstance() {
        return USER_SERVICE;
    }

    /**
     * {@inheritDoc}
     *
     * @param user Represents the {@link User}
     * @return true if the user is sign in else false
     */
    public boolean signUp(final User user) {
        return userSet.add(user);
    }

    /**
     * {@inheritDoc}
     *
     * @param mobileNumber Represents the user's mobile number
     * @return the id of the {@link User}
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
     * @param mobileNumber Represents the user's mobile number
     * @return true if the mobile number is already sign in else false
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
     * @param id Represents the {@link User} id
     * @return the {@link User}
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
     * @param user Represents the {@link User}
     * @return true if the profile is updated else false
     */
    public boolean isUpdateProfile(final User user) {
        final Iterator<User> iterator = userSet.iterator();

        while (iterator.hasNext()) {
            final User existingUser = iterator.next();

            if (existingUser.getMobileNumber().equals(user.getMobileNumber())) {
                existingUser.setName(user.getName());
                existingUser.setDateOfBirth(user.getDateOfBirth());
                existingUser.setAbout(user.getAbout());

                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param currentId Represents the {@link User} id.
     * @return true if the account is deleted else false
     */
    public boolean deleteAccount(final long currentId) {
        return userSet.removeIf(user -> user.getId() == currentId);
    }
}