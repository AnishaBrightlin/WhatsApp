package com.whatsapp.service;

import com.whatsapp.model.Status;

import java.util.Date;

/**
 * defines the behavior of status service
 *
 * @author Anisha Brightlin
 * @version 1.00
 */
public interface StatusService {

    /**
     * Append all the user details into the list
     *
     * @param status the status object containing the user status
     * @return the status of the user
     */
    String putStatus(final Status status);

    /**
     * Deletes the user account associated with the provided mobile number.
     *
     * @param time the status object to be delete
     * @return Returns true if the status is deleted successfully else false
     */
    boolean isExpired(final Date time);
}