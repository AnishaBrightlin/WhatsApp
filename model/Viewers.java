package com.whatsapp.model;

import java.util.Date;

/**
 * <p>
 * Represents the Views for each status
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class Viewers {

    private long currentUserId;
    private long id;
    private Date time;
    private long otherUser;

    public void setCurrentUserId(final long userId) {
        this.currentUserId = userId;
    }

    public void setViewersId(final long viewersId) {
        this.id = viewersId;
    }

    public void setTime(final Date time) {
        this.time = time;
    }

    public void setOtherUser(final long otherUser) {
        this.otherUser = otherUser;
    }

    public long getOtherUser() {
        return otherUser;
    }

    public long getCurrentUserId() {
        return currentUserId;
    }

    public Date getTime() {
        return time;
    }

    public long getViewersId() {
        return id;
    }

    public String toString() {
        return String.format("No: %s ViewerId: %s Time: %s", id, currentUserId, time);
    }
}