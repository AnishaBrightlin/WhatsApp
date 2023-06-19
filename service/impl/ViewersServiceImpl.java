package com.whatsapp.service.impl;

import com.whatsapp.model.User;
import com.whatsapp.model.Viewers;

import com.whatsapp.service.UserService;
import com.whatsapp.service.ViewersService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Provides the {@link Viewers} functionalities.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class ViewersServiceImpl implements ViewersService {

    private static final ViewersServiceImpl VIEWERS_SERVICE = new ViewersServiceImpl();
    private final List<Viewers> viewersList = new ArrayList<>();

    private ViewersServiceImpl() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link UserService} instance.
     */
    public static ViewersServiceImpl getInstance() {
        return VIEWERS_SERVICE;
    }

    /**
     * {@inheritDoc}
     *
     * @param viewers Represents the {@link Viewers}
     * @return true if the status is viewed else false
     */
    public boolean isStatusViewed(final Viewers viewers) {
        return viewersList.add(viewers);
    }

    /**
     * {@inheritDoc}
     *
     * @param userId Represents the {@link User}
     * @return the {@link List} of {@link Viewers}
     */
    public List<Viewers> getStatusViewers(final long userId) {

        final List<Viewers> userView = new ArrayList<>();

        for (final Viewers viewers : viewersList) {

            if (userId == viewers.getOtherUser()) {
                userView.add(viewers);
            }
        }
        return userView;
    }
}