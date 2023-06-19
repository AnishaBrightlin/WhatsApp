package com.whatsapp.service.impl;

import com.whatsapp.model.Status;
import com.whatsapp.service.StatusService;

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

    private StatusServiceImpl() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
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

        for (final Status status : statusList) {

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

        if (isIdExist(id)) {

            for (final Status status : statusList) {

                if (id == status.getUserId()) {
                    userStatus.add(status);
                }
            }
        }
        return userStatus;
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user
     * @return true if the id is present else false.
     */
    public boolean isIdExist(final long id) {

        for (final Status status : statusList) {

            if (id == status.getUserId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user id
     * @return the {@link List} of {@link Status}id
     */
    public List<Long> getStatusIdList(final long id) {

        final List<Long> userStatus = new ArrayList<>();

        for (final Status status : statusList) {

            if (status != null && id != status.getUserId() && !userStatus.contains(status.getUserId())) {
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
    public int getStatusId(final long otherId) {

        final List<Long> statusId = new ArrayList<>();

        if (isIdExist(otherId)) {

            for (final Status status : statusList) {

                if (otherId == status.getUserId()) {
                    statusId.add(status.getId());
                }
            }
        }
        return statusId.size();
    }

    /**
     * {@inheritDoc}
     *
     * @param statusId Represents the {@link Status} id
     * @return the {@link Status}
     */
    public Status getOthersStatus(final long statusId) {

        for (final Status status : statusList) {

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
    public boolean isStatusExpired(final Date time) {
        final Date currentTime = new Date();

        return currentTime.after(time);
    }
}