package com.whatsapp.DAO;

import com.whatsapp.model.User;

/**
 * <p>
 * Provides the functionalities of DAO user service
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface DAOUserService {

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
     * Signs in the existing {@link User} into the application.
     * </p>
     *
     * @param mobileNumber Represents the {@link User} mobile number
     * @return true if user is sign in else false
     */
    boolean signIn(final String mobileNumber);

    /**
     * <p>
     * Gets the user id.
     * </p>
     *
     * @param mobileNumber Represents the {@link User} mobile number
     * @return the user id
     */
    long getUserId(final String mobileNumber);

    /**
     * <p>
     * Gets the user details.
     * </p>
     *
     * @param userId Represents the {@link User}
     * @return the user
     */
    User getUserDetails(final long userId);

    /**
     * <p>
     * Updates the {@link User} profile.
     * </p>
     *
     * @param user Represents the {@link User}
     * @return true if the profile is updated else false
     */
    boolean isUpdateProfile(final User user);

    /**
     * <p>
     * Deletes the user account.
     * </p>
     *
     * @param id Represents the {@link User}
     * @return true if the profile is deleted else false
     */
    boolean isAccountDeleted(final long id);
}