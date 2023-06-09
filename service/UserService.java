package com.whatsapp.service;

import com.whatsapp.model.User;

/**
 * Defines the behavior of whatsApp service
 *
 * @version 1.0
 * @author Anisha Brightlin
 */
public interface UserService {

    /**
     * Appends all the user details into the list
     *
     * @param user the user object containing the user details
     * @return Returns the mobile number of the signed-up user
     */
    boolean signUp(final User user);

    /**
     * Retrieves the user details
     *
     * @return Returns the set of user details
     */
    User getUserDetails(final int mobileNumber);

    /**
     * Checks the user is already signUp
     *
     * @param mobileNumber the user object to check
     * @return Returns true if the user is already exist else false
     */
    boolean signIn(final String mobileNumber);

    /**
     * Updates the user details with the provided user object.
     *
     * @param user the user object containing the updated user details
     * @return Returns a set of user objects representing the updated profiles
     */
   boolean isUpdatedProfile(final User user);

    /**
     * Deletes the user account associated with the provided mobile number.
     *
     * @param mobileNumber the mobile number of the user account to delete
     * @return Returns true if the account is deleted successfully else false
     */
    boolean deleteAccount(final String mobileNumber);
}