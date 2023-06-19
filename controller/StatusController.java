package com.whatsapp.controller;

import com.whatsapp.model.Status;

import com.whatsapp.service.StatusService;
import com.whatsapp.service.impl.StatusServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Controls the {@link Status} related operation.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class StatusController {

    private static final StatusController STATUS_CONTROLLER = new StatusController();
    private static final StatusService STATUS_SERVICE = StatusServiceImpl.getInstance();

    private StatusController() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link StatusController} instance.
     */
    public static StatusController getInstance() {
        return STATUS_CONTROLLER;
    }

    /**
     * <p>
     * Uploads a new status with the provided {@link Status}.
     * </p>
     *
     * @param status Represents the user {@link Status}
     * @return true if the {@link Status} is uploaded else false.
     */
    public boolean isUpload(final Status status) {
        return STATUS_SERVICE.isStatusUploaded(status);
    }

    /**
     * <p>
     * Gets the list of {@link Status}.
     * </p>
     *
     * @param id Represents the {@link Status} id
     * @return the list of {@link Status}
     */
    public List<Status> getStatusList(final long id) {
        return STATUS_SERVICE.getStatusList(id);
    }

    /**
     * <p>
     * Gets the list of {@link Status} id.
     * </p>
     *
     * @param id Represents the user
     * @return the list of {@link Status} id who have the status
     */
    public List<Long> getStatusIdList(final long id) {
        return STATUS_SERVICE.getStatusIdList(id);
    }

    /**
     * <p>
     * Gets the status id of the respective given id.
     * </p>
     *
     * @param othersId Represents the other user
     * @return {@link Status} id
     */
    public int getStatusId(final long othersId) {
        return STATUS_SERVICE.getStatusId(othersId);
    }

    /**
     * Checks the id is existed or not.
     *
     * @param otherId Represents the other user
     * @return true if the id is existed else false
     */
    public boolean isIdExist(final long otherId) {
        return STATUS_SERVICE.isIdExist(otherId);
    }

    /**
     * Checks the given time is expired or not.
     *
     * @param time Represents the status uploaded time
     * @return true if the status is expired else false
     */
    public boolean isExpired(final Date time) {
        return STATUS_SERVICE.isStatusExpired(time);
    }
}