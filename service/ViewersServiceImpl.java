package com.whatsapp.service;

import com.whatsapp.model.Viewers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Provides the status functionality.
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class ViewersServiceImpl {

    private final List<Viewers> viewersList = new ArrayList<>();

    /**
     * Puts a new viewers with the provided viewers object.
     *
     * @param viewers represents the viewers
     * @return true if the viewers is added to teh list else false
     */
    public boolean isStatusViewed(final Viewers viewers) {
        return viewersList.add(viewers);
    }

    /**
     * Gets the status of the respective status id
     *
     * @param statusId represents the status id
     * @return the list of viewers
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