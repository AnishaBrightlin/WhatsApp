package com.whatsapp.service.impl2;

import com.whatsapp.DAO.impl.DAOUserServiceImpl;
import com.whatsapp.DAO.DAOUserService;

import com.whatsapp.model.User;
import com.whatsapp.service.UserService;

/**
 * Provides the {@link User} functionalities.
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see com.whatsapp.service.UserService
 */
public class UserServiceImpl2 implements UserService {

    private static final UserService USER_SERVICE = new UserServiceImpl2();
    private static final DAOUserService DAO_USER_SERVICE = DAOUserServiceImpl.getInstance();

    private UserServiceImpl2() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
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
        return DAO_USER_SERVICE.signUp(user);
    }

    /**
     * {@inheritDoc}
     *
     * @param mobileNumber Represents the user's mobile number
     * @return true if the mobile number is already sign in else false
     */
    public boolean signIn(final String mobileNumber) {
        return DAO_USER_SERVICE.signIn(mobileNumber);
    }

    /**
     * {@inheritDoc}
     *
     * @param mobileNumber Represents the user's mobile number
     * @return the id of the {@link User}
     */
    public long getUserId(final String mobileNumber) {
        return DAO_USER_SERVICE.getUserId(mobileNumber);
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the {@link User} id
     * @return the {@link User}
     */
    public User getUserDetails(final long id) {
        return DAO_USER_SERVICE.getUserDetails(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param user Represents the {@link User}
     * @return true if the profile is updated else false
     */
    public boolean isUpdateProfile(final User user) {
        return DAO_USER_SERVICE.isUpdateProfile(user);
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the {@link User} id.
     * @return true if the account is deleted else false
     */
    public boolean isAccountDeleted(final long id) {
        return DAO_USER_SERVICE.isAccountDeleted(id);
    }
}