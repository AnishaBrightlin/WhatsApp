package com.whatsapp.service;

import com.whatsapp.model.User;

/**
 * Defines the behavior of whatsApp service
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface UserService {

    /**
     * Appends all the user details into the list
     *
     * @param user the user object containing the user details
     * @return the mobile number of the signed-up user
     */
    boolean signUp(final User user);

    /**
     * Retrieves the user details
     *
     * @return the set of user details
     */
    User getUserDetails(final long id);

    /**
     * Checks the user is already signUp
     *
     * @param mobileNumber the user object to check
     * @return true if the user is already exist else false
     */
    boolean signIn(final String mobileNumber);

    /**
     * Updates the user details with the provided user object.
     *
     * @param user the user object containing the updated user details
     * @return true if the profile is updated else false.
     */
    boolean isUpdateProfile(final User user);

    /**
     * Deletes the user account associated with the provided mobile number.
     *
     * @param currentId the mobile number of the user account to delete
     * @return true if the account is deleted successfully else false
     */
    boolean deleteAccount(final long currentId);

    /**
     * Retrieves the current user id
     * @param mobileNumber get the id from the mobile number
     * @return id
     */
    long getUserId(final String mobileNumber);
}