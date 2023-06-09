package com.whatsapp.controller;

import com.whatsapp.model.Status;
import com.whatsapp.service.StatusServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * Passes the data between status and the service.
 *
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
    public boolean putStatus(final Status status) {
        return STATUS_SERVICE.putStatus(status);
    }

    /**
     * Checks the given time is expired or not
     *
     * @param time the time containing the status expire time
     * @return true if the status is expired else false
     */
    public boolean isExpired(final Date time ) {
        return STATUS_SERVICE.isExpired(time);
    }
}