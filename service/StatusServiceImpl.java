package com.whatsapp.service;

import com.whatsapp.controller.StatusController;
import com.whatsapp.model.Status;

import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

/**
 * <p>
 * Provides the status functionality.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see com.whatsapp.service.StatusService
 */
public class StatusServiceImpl implements StatusService {

    private static final StatusService STATUS_SERVICE = new StatusServiceImpl();
    private final List<Status> statusList = new ArrayList<>();

    private StatusServiceImpl() {}

    /**
     * <p>
     * Gets the instance of the class.
     *</p>
     * @return the {@link StatusService} instance.
     */
    public static StatusService getInstance() {
        return STATUS_SERVICE;
    }

    /**
     * {@inheritDoc}
     *
     * @param status Represents the user's {@link Status}.
     * @return true if the status is Uploaded else false
     */
    public boolean isStatusUploaded(final Status status) {
        return statusList.add(status);
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user id
     * @return the {@link List} of {@link Status}
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
     * @param id Represents the {@link Status} id
     * @return the {@link List} of {@link Status}
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
     * @param id Represents the user id
     * @return the {@link List} of {@link Status}id
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
     * @param otherId Represents the other user
     * @return the {@link List} of {@link Status} id
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
     * @param statusId Represents the {@link Status} id
     * @return the {@link Status}
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
     * @param time Represents the uploaded time
     * @return true if the status time is after the current time else false
     */
    public boolean isExpired(final Date time) {
        final Date currentTime = new Date();

        return currentTime.after(time);
    }
}