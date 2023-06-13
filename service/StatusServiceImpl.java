package com.whatsapp.service;

import com.whatsapp.model.Status;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

/**
 * Implements the status service interface and provides the status functionality.
 *
 * @see com.whatsapp.service.StatusService
 * @version 1.0
 * @author Anisha Brightlin
 */
public class StatusServiceImpl implements StatusService {

    private final List<Status> statusList = new ArrayList<>();

    /**
     * {@inheritDoc}
     * @param status the status contains the user status
     * @return true if the status is added to the list else false
     */
    public boolean isStatusUploaded(final Status status) {
        return statusList.add(status);
    }

    /**
     * {@inheritDoc}
     * @param id the id contains the user id
     * @return the list of status
     */
    public List<Status> getStatus(final long id) {
        final List<Status> userStatus = new ArrayList<>();

        for (final Status status : statusList) {

            if (status.getUserId() == id) {
                userStatus.add(status);
            }
        }
        return userStatus;
    }

    /**
     * {@inheritDoc}
     * @param id the id contains the user id
     * @return the list of id who have the status
     */
    public List<Long> getStatusList(final long id) {
        final List<Long> userStatus = new ArrayList<>();

        for (final Status status : statusList) {

            if (id != status.getUserId() && status != null) {
                userStatus.add(status.getUserId());
            }
        }
        return userStatus;
    }

    /**
     * {@inheritDoc}
     * @param time the status uploaded time
     * @return true if the status time is after the current time else false
     */
    public boolean isExpired(final Date time) {
        final Date currentTime = new Date();

        return currentTime.after(time);
    }
}