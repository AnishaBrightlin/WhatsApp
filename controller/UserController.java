package com.whatsapp.controller;

import com.whatsapp.model.User;

import com.whatsapp.service.impl.UserServiceImpl;
import com.whatsapp.service.UserService;

/**
 * <p>
 * Controls the {@link User} related operation.
 * </p>
 *
 * @author Anisha brightlin
 * @version 1.0
 */
public class UserController {

    private static final UserController USER_CONTROLLER = new UserController();
    private static final UserService SERVICE = UserServiceImpl.getInstance();

    private UserController() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link UserController} instance.
     */
    public static UserController getInstance() {
        return USER_CONTROLLER;
    }

    /**
     * <p>
     * Signs up a new user with the provided {@link User}.
     * </p>
     *
     * @param user Represents the {@link User} details
     * @return true if the {@link User} is sign up else false
     */
    public boolean signUp(final User user) {
        return SERVICE.signUp(user);
    }

    /**
     * <p>
     * Gets the user details with the provided {@link User} id.
     * </p>
     *
     * @param id Represents the {@link User} id
     * @return {@link User} details
     */
    public User getUserDetail(final long id) {
        return SERVICE.getUserDetails(id);
    }

    /**
     * <p>
     * Gets the {@link User} id for the given mobile number
     * </p>
     *
     * @param mobileNumber Represents the mobile number of the {@link User}
     * @return the {@link User} id
     */
    public long getUserId(final String mobileNumber) {
        return SERVICE.getUserId(mobileNumber);
    }

    /**
     * <p>
     * Checks the {@link User} is signed in with the given mobile number.
     * </p>
     *
     * @param mobileNumber Describes the mobile number of the {@link User}
     * @return true if the {@link User} is signed in else false
     */
    public boolean isSignIn(final String mobileNumber) {
        return SERVICE.signIn(mobileNumber);
    }

    /**
     * <p>
     * Updates the user details with the provided {@link User} object.
     * </p>
     *
     * @param user Represents the updated {@link User} details
     * @return true if the profile is updated else false
     */
    public boolean isUpdateProfile(final User user) {
        return SERVICE.isUpdateProfile(user);
    }

    /**
     * <p>
     * Deletes the user account associated with the provided {@link User} id.
     * </p>
     *
     * @param currentId represents the current {@link User}
     * @return true if the account is deleted else false
     */
    public boolean deleteAccount(final long currentId) {
        return SERVICE.deleteAccount(currentId);
    }
}