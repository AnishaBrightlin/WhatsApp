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
    private long viewersId;
    private Date time;
    private long otherUser;

    public void setCurrentUserId(final long userId) {
        this.currentUserId = userId;
    }

    public void setViewersId(final long viewersId) {
        this.viewersId = viewersId;
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
        return viewersId;
    }

    public long getOtherUser() {
        return otherUser;
    }

    public String toString() {
        return String.format("%s %s %s %s %s", currentUserId, viewersId, statusId, otherUser, time);
    }
}