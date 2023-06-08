package com.whatsapp.model;

import java.util.Set;
import java.util.Calendar;
import java.util.Date;

/**
 * Gets and sets the user's status.
 *
 * @version 0.1
 * @author Anisha Brightlin
 */
public class Status {

    private String message;
    private Date time;
    private int viwersCount;
    private Set<String> viewers;
    private Date deleteTime;

    public void setStatus(final String status) {
        this.message = status;
    }

    public void setTime(final Date time) {
        this.time = time;
    }

    public void setViewers(final Set<String> viewers) {
        this.viewers = viewers;
    }

    public void setViwersCount(final int viwersCount) {
        this.viwersCount = viwersCount;
    }

    public String getStatus() {
        return message.toString();
    }

    public Date getStatusTime() {
        return time;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }
}




