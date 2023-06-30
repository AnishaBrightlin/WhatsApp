package com.whatsapp.service;

import com.whatsapp.model.Status;

import java.util.List;

/**
 * <p>
 * Provides the functionalities of {@link Status} service
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface StatusService {

    /**
     * <p>
     * Checks all the {@link Status} are uploaded.
     * </p>
     *
     * @param status Represents the user's {@link Status}
     * @return true if the status is uploaded else false
     */
    boolean isStatusUploaded(final Status status);

    /**
     * <p>
     * Gets the {@link Status}
     * </p>
     *
     * @param id Represents the user id
     * @return the {@link List} of {@link Status}
     */
    List<Status> getStatusList(final long id);

    /**
     * <p>
     * Gets the {@link List} of {@link Status} id.
     * </p>
     *
     * @param id Represents the user id
     * @return {@link List} of {@link Status} id
     */
    List<Long> getStatusIdList(final long id);

    /**
     * <p>
     * Checks the provided id is existed or not.
     * </p>
     *
     * @param id Represents the user
     * @return true if the id is present else false.
     */
    boolean isIdExist(final long id);
}