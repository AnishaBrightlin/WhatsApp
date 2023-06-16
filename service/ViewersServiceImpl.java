package com.whatsapp.service;

import com.whatsapp.model.Viewers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * Provides the {@link Viewers} functionalities.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class ViewersServiceImpl {

    private static final ViewersServiceImpl VIEWERS_SERVICE = new ViewersServiceImpl();
    private final List<Viewers> viewersList = new ArrayList<>();

    private ViewersServiceImpl() {}

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
     * <p>
     * Checks if the status is viewed.
     * </p>
     *
     * @param viewers Represents the {@link Viewers}
     * @return true if the status is viewed else false
     */
    public boolean isStatusViewed(final Viewers viewers) {
        return viewersList.add(viewers);
    }

    /**
     * <p>
     * Gets the {@link Viewers} for the provided status id.
     * </p>
     *
     * @param statusId Represents the status id
     * @return the {@link List} of {@link Viewers}
     */
    public List<Viewers> getStatusViewers(final long statusId) {
        final List<Viewers> userView = new ArrayList<>();
        final Iterator<Viewers> iterator = viewersList.iterator();

        while (iterator.hasNext()) {
            final Viewers viewers = iterator.next();

            if (statusId == viewers.getStatusId()) {
                userView.add(viewers);
            }
        }
        return userView;
    }
}