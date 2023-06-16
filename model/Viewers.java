package com.whatsapp.model;

import java.util.Date;

/**
 * Represents the Views for each status
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class Viewers {

    private long statusId;
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

    public void setStatusId(final long statusId) {
        this.statusId = statusId;
    }

    public void setTime(final Date time) {
        this.time = time;
    }

    public void setOtherUser(final long otherUser) {
        this.otherUser = otherUser;
    }

    public long getStatusId() {
        return statusId;
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

    public long getOtherUser() {
        return otherUser;
    }

    public String toString() {
        return String.format("%s %s %s %s %s", currentUserId, id, statusId, otherUser, time);
    }
}