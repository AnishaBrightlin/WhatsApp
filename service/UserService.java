package com.whatsapp.service;

import com.whatsapp.model.User;

/**
 * <p>
 * Provides the functionalities of {@link User} service
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface UserService {

    /**
     * <p>
     * Signs up the new {@link User} into the application.
     * </p>
     *
     * @param user Represents the {@link User}
     * @return true if user is sign up else false
     */
    boolean signUp(final User user);

    /**
     * <p>
     * Gets the {@link User} details for the given id.
     * </p>
     *
     * @param id Represents the {@link User} id
     * @return the {@link User}
     */
    User getUserDetails(final long id);

    /**
     * <p>
     * Signs in a user with the given mobile number.
     * </p>
     *
     * @param mobileNumber Represents the {@link User} mobile number
     * @return true if the user is already sign in else false
     */
    boolean signIn(final String mobileNumber);

    /**
     * <p>
     * Updates the user profile with the provided {@link User}.
     * </p>
     *
     * @param user Represents the {@link User}
     * @return true if the profile is updated else false.
     */
    boolean isUpdateProfile(final User user);

    /**
     * <p>
     * Deletes the {@link User} account associated with the provided id.
     * </p>
     *
     * @param id Represents the {@link User} id
     * @return true if the account is deleted else false
     */
    boolean isAccountDeleted(final long id);

    /**
     * <p>
     * Gets the current user id
     * </p>
     *
     * @param mobileNumber Represents the user's mobile number
     * @return id of the {@link User}
     */
    long getUserId(final String mobileNumber);
}