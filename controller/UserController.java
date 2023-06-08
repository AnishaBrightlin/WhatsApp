package com.whatsapp.controller;

import com.whatsapp.model.User;
import com.whatsapp.service.UserServiceImpl;
import com.whatsapp.service.UserService;

/**
 * Passes the data between user and the service.
 *
 * @see com.whatsapp.model.User
 * @see UserService
 * @version 1.0
 * @author Anisha brightlin
 */
public class UserController {

    private static final UserService SERVICE = new UserServiceImpl();

    /**
     * Signs up a new user with the provided user object.
     *
     * @param user the user object containing the user details
     * @return the mobile number of the signed-up user.
     */
    public String signUp(final User user) {
        return SERVICE.signUp(user);
    }

    /**
     * Retrieves the collection of user details.
     *
     * @return user details
     */
    public User getUserDetail(final String mobileNumber) {
        return SERVICE.getUserDetails(mobileNumber);
    }

    /**
     * Checks if a user is signed in.
     *
     * @param mobileNumber the user object to check
     * @return true if the user is signed in else false
     */
    public boolean signIn(final String mobileNumber) {
        return SERVICE.signIn(mobileNumber);
    }

    /**
     * Updates the user details with the provided user object.
     *
     * @param user the user object containing the updated user details
     * @return the updated profile
     */
    public boolean updateProfile(final User user) {
        return SERVICE.isUpdatedProfile(user);
    }

    /**
     * Deletes the user account associated with the provided mobile number.
     *
     * @param mobileNumber the mobile number of the user account to delete
     * @return true if the account is deleted else false
     */
    public boolean deleteAccount(final String mobileNumber) {
        return SERVICE.deleteAccount(mobileNumber);
    }
}