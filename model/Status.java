package com.whatsapp.model;

import java.util.Set;
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
    private int viewsCount;
    private Set<String> viewers;

    public void setStatus(final String status) {
        this.message = status;
    }

    public void setTime(final Date time) {
        this.time = time;
    }

    public void setViewers(final Set<String> viewers) {
        this.viewers = viewers;
    }

    public void setViewsCount(final int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getStatus() {
        return message.toString();
    }

    public Date getStatusTime() {
        return time;
    }
}




