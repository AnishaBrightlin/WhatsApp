package com.whatsapp.service;

import com.whatsapp.model.Status;

import java.util.Date;
import java.util.List;

/**
 * Defines the behavior of status service
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface StatusService {

    /**
     * Appends all the status into the list.
     *
     * @param status object containing the user status
     * @return the status of the user
     */
    boolean isStatusUploaded(final Status status);

    /**
     * Gets the Status of the individual user.
     *
     * @param id contains the user id
     * @return list of status
     */
    List<Status> getStatus(final long id);

    /**
     * Gets the list of id who have the status
     *
     * @param id contains the user id
     * @return list of id
     */
    List<Long> getStatusList(final long id);

    /**
     * Deletes the status associated with the provided time.
     *
     * @param time represents the status uploaded time
     * @return true if the status is deleted successfully else false
     */
    boolean isExpired(final Date time);
}