package com.whatsapp.controller;

import com.whatsapp.model.Status;
import com.whatsapp.service.StatusServiceImpl;

import java.util.Date;

/**
 * Passes the data between status and the service.
 *
 * @see com.whatsapp.model.Status
 * @see com.whatsapp.service.StatusService
 * @version 1.0
 * @author Anisha Brightlin
 */
public class StatusController {

    private static final StatusServiceImpl STATUS_SERVICE = new StatusServiceImpl();

    /**
     * Puts a new Status with the provided status object.
     *
     * @param status the status object containing the user status
     * @return the mobile number of the signed-up user.
     */
    public String putStatus(final Status status) {
        return STATUS_SERVICE.putStatus(status);
    }

    /**
     * Checks the given
     *
     * @param time the time containing the status expire time
     * @return true if the status is expired else false
     */
    public boolean isExpired(final Date time ) {
        return STATUS_SERVICE.isExpired(time);
    }
}