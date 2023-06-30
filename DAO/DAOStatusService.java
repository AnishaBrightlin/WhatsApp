package com.whatsapp.DAO;

import com.whatsapp.model.Status;
import com.whatsapp.model.User;

import java.util.List;

/**
 * <p>
 * Provides the functionalities of DAO status service
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface DAOStatusService {

    /**
     * <p>
     * Uploads the new {@link Status}.
     * </p>
     *
     * @param status Represents the {@link Status}
     * @return true if status is uploaded else false
     */
    boolean isStatusUploaded(final Status status);

    /**
     * <p>
     * Gets the list of {@link Status}.
     * </p>
     *
     * @param id Represents the {@link User}
     * @return list of status
     */
    List<Status> getStatusList(final long id);

    /**
     * <p>
     * Gets the list of {@link Status} id.
     * </p>
     *
     * @param id Represents the user
     * @return list of status id
     */
    List<Long> getStatusIdList(final long id);

    /**
     * <p>
     * Checks the given id is exiting.
     * </p>
     *
     * @param id Represents the user
     * @return true if the id is existing else false
     */
    boolean isIdExist(final long id);
}