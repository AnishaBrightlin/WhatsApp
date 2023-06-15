package com.whatsapp.controller;

import com.whatsapp.model.Viewers;
import com.whatsapp.service.ViewersServiceImpl;

import java.util.List;

/**
 * Passes the data between viewers and the service.
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class ViewersController {

    private static final ViewersServiceImpl VIEWERS_SERVICE = new ViewersServiceImpl();

    /**
     * Puts a new viewers with the provided viewers object.
     */
    public boolean isStatusViewed(final Viewers viewers) {
        return VIEWERS_SERVICE.isStatusViewed(viewers);
    }

    /**
     * Gets the viewers of the given status id
     *
     * @param statusId represents the status id
     * @return the list of viewers
     */
    public List<Viewers> getViewers(final long statusId) {
        return VIEWERS_SERVICE.getStatusViewers(statusId);
    }
}
