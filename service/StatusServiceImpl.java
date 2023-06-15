package com.whatsapp.service;

import com.whatsapp.model.Status;

import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

/**
 * Implements the status service interface and provides the status functionality.
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see com.whatsapp.service.StatusService
 */
public class StatusServiceImpl implements StatusService {

    private final List<Status> statusList = new ArrayList<>();

    /**
     * {@inheritDoc}
     *
     * @param status contains the user status
     * @return true if the status is added to the list else false
     */
    public boolean isStatusUploaded(final Status status) {
        return statusList.add(status);
    }

    /**
     * {@inheritDoc}
     *
     * @param id contains the user id
     * @return the list of status
     */
    public Status getStatus(final long id) {
        final Iterator<Status> iterator = statusList.iterator();

        while (iterator.hasNext()) {
            final Status status = iterator.next();

            if (status.getUserId() == id) {
                return status;
            }
        }
        return null;
    }

    /**
     * Gets the list of status id
     *
     * @param id represents the status id
     * @return the list of status
     */
    public List<Status> getStatusList(final long id) {
        final List<Status> userStatus = new ArrayList<>();
        final Iterator<Status> iterator = statusList.iterator();

        while (iterator.hasNext()) {
            final Status status = iterator.next();

            if (status.getUserId() == id) {
                userStatus.add(status);
            }
        }
        return userStatus;
    }

    /**
     * {@inheritDoc}
     *
     * @param id represents the user id
     * @return the list of id who have the status
     */
    public List<Long> getStatusIdList(final long id) {
        final List<Long> userStatus = new ArrayList<>();
        final Iterator<Status> iterator = statusList.iterator();

        while (iterator.hasNext()) {
            final Status status = iterator.next();

            if (status != null && id != status.getUserId()) {
                userStatus.add(status.getUserId());
            }
        }
        return userStatus;
    }

    /**
     * {@inheritDoc}
     *
     * @param otherId represents the other user
     * @return the list of status id
     */
    public List<Long> getStatusId(final long otherId) {
        final List<Long> statusId = new ArrayList<>();
        final Iterator<Status> iterator = statusList.iterator();

        while (iterator.hasNext()) {
            final Status status = iterator.next();

            if (otherId == status.getUserId()) {
                statusId.add(status.getId());
            }
        }
        return statusId;
    }

    /**
     * {@inheritDoc}
     *
     * @param statusId represents the status id
     * @return the status object
     */
    public Status getOthersStatus(final long statusId) {
        final Iterator<Status> iterator = statusList.iterator();

        while (iterator.hasNext()) {
            final Status status = iterator.next();

            if (statusId == status.getId()) {
                return status;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param time the status uploaded time
     * @return true if the status time is after the current time else false
     */
    public boolean isExpired(final Date time) {
        final Date currentTime = new Date();

        return currentTime.after(time);
    }
}