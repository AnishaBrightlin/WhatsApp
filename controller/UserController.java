package com.whatsapp.controller;

import com.whatsapp.model.User;
import com.whatsapp.service.UserServiceImpl;
import com.whatsapp.service.UserService;

/**
 * Passes the data between user and the service.
 *
 * @author Anisha brightlin
 * @version 1.0
 */
public class UserController {

    private static final UserService SERVICE = new UserServiceImpl();

    /**
     * Signs up a new user with the provided user object.
     *
     * @param user the user object containing the user details
     * @return the mobile number of the signed-up user.
     */
    public boolean signUp(final User user) {
        return SERVICE.signUp(user);
    }

    /**
     * Retrieves the collection of user details.
     *
     * @return user details
     */
    public User getUserDetail(final long id) {
        return SERVICE.getUserDetails(id);
    }

    /**
     * Retrieves the id for the given mobile number
     *
     * @param mobileNumber of the user object ti check
     * @return the id
     */
    public long getUserId(final String mobileNumber) {
        return SERVICE.getUserId(mobileNumber);
    }

    /**
     * Checks if a user is signed in.
     *
     * @param mobileNumber the user object to check
     * @return true if the user is signed in else false
     */
    public boolean isSignIn(final String mobileNumber) {
        return SERVICE.signIn(mobileNumber);
    }

    /**
     * Updates the user details with the provided user object.
     *
     * @param user the user object containing the updated user details
     * @return the updated profile
     */
    public boolean isUpdateProfile(final User user) {
        return SERVICE.isUpdateProfile(user);
    }

    /**
     * Deletes the user account associated with the provided mobile number.
     *
     * @param currentId the mobile number of the user account to delete
     * @return true if the account is deleted else false
     */
    public boolean deleteAccount(final long currentId) {
        return SERVICE.deleteAccount(currentId);
    }
}