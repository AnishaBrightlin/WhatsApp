package com.whatsapp.service;

import com.whatsapp.model.User;
import com.whatsapp.model.Viewers;

import java.util.List;

/**
 * <p>
 * Provides the functionalities of {@link Viewers} service
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public interface ViewersService {

    /**
     * <p>
     * Checks if the status is viewed.
     * </p>
     *
     * @param viewers Represents the {@link Viewers}
     * @return true if the status is viewed else false
     */
    boolean isStatusViewed(final Viewers viewers);

    /**
     * <p>
     * Gets the {@link Viewers} for the provided status id.
     * </p>
     *
     * @param userId Represents the {@link User}
     * @return the {@link List} of {@link Viewers}
     */
    List<Viewers> getStatusViewers(final long userId);
}
