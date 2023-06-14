package com.whatsapp.controller;

import com.whatsapp.model.Status;
import com.whatsapp.service.StatusServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * Passes the data between status and the service.
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class StatusController {

    private static final StatusServiceImpl STATUS_SERVICE = new StatusServiceImpl();

    /**
     * Puts a new status with the provided status object.
     *
     * @param status object containing the user status
     * @return true if the status is added to the list else false.
     */
    public boolean isUpload(final Status status) {
        return STATUS_SERVICE.isStatusUploaded(status);
    }

    /**
     * Gets a new status with the provided user id.
     *
     * @param id represents the user
     * @return the status list of the signed-up user.
     */
    public List<Status> getStatus(final long id) {
        return STATUS_SERVICE.getStatus(id);
    }

    /**
     * Gets the status list.
     *
     * @param id represents the user
     * @return the list of status how have the status
     */
    public List<Long> getStatusList(final long id) {
        return STATUS_SERVICE.getStatusList(id);
    }

    /**
     * Checks the given time is expired or not.
     *
     * @param time containing the status uploaded time
     * @return true if the status is expired else false
     */
    public boolean isExpired(final Date time) {
        return STATUS_SERVICE.isExpired(time);
    }
}