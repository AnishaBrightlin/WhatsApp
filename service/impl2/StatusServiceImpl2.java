package com.whatsapp.service.impl2;

import com.whatsapp.DAO.DAOStatusService;
import com.whatsapp.DAO.impl.DAOStatusServiceImpl;

import com.whatsapp.model.Status;
import com.whatsapp.service.StatusService;

import java.util.List;

/**
 * <p>
 * Provides the status functionality.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 * @see com.whatsapp.service.StatusService
 */
public class StatusServiceImpl2 implements StatusService {

    private static final StatusService STATUS_SERVICE = new StatusServiceImpl2();
    private static final DAOStatusService DAO_STATUS_SERVICE = DAOStatusServiceImpl.getInstance();

    private StatusServiceImpl2() {
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
        return DAO_STATUS_SERVICE.isStatusUploaded(status);
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user id
     * @return the {@link List} of {@link Status}
     */
    public List<Status> getStatusList(final long id) {
        return DAO_STATUS_SERVICE.getStatusList(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user id
     * @return the {@link List} of {@link Status}id
     */
    public List<Long> getStatusIdList(final long id) {
        return DAO_STATUS_SERVICE.getStatusIdList(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param id Represents the user
     * @return true if the id is present else false.
     */
    public boolean isIdExist(final long id) {
        return DAO_STATUS_SERVICE.isIdExist(id);
    }
}