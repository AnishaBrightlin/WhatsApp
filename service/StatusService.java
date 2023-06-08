package com.whatsapp.service;

import com.whatsapp.model.Status;

import java.util.Date;

/**
 * Defines the behavior of status service
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface StatusService {

    /**
     * Appends all the status into the list
     *
     * @param status the status object containing the user status
     * @return the status of the user
     */
    String putStatus(final Status status);

    /**
     * Deletes the status associated with the provided time
     *
     * @param time the status object to be delete
     * @return Returns true if the status is deleted successfully else false
     */
    boolean isExpired(final Date time);
}