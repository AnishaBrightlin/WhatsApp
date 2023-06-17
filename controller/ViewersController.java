package com.whatsapp.controller;

import com.whatsapp.model.Viewers;
import com.whatsapp.service.ViewersServiceImpl;

import java.util.List;

/**
 * <p>
 * Controls the viewers related operation and interaction
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class ViewersController {

    private static final ViewersServiceImpl VIEWERS_SERVICE = ViewersServiceImpl.getInstance();
    private static final ViewersController VIEWERS_CONTROLLER = new ViewersController();

    private ViewersController() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link ViewersController} instance.
     */
    public static ViewersController getInstance() {
        return VIEWERS_CONTROLLER;
    }

    /**
     * <p>
     * Checks the status is viewed or not.
     * </p>
     *
     * @param viewers Represents the {@link Viewers}
     * @return true if the status is viewed else false
     */
    public boolean isStatusViewed(final Viewers viewers) {
        return VIEWERS_SERVICE.isStatusViewed(viewers);
    }

    /**
     * <p>
     * Gets the viewers of the given status id.
     * </p>
     *
     * @param statusId Represents the status id
     * @return the list of {@link Viewers}
     */
    public List<Viewers> getViewers(final long statusId) {
        return VIEWERS_SERVICE.getStatusViewers(statusId);
    }
}