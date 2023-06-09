package com.whatsapp.model;

import java.util.Date;
import java.util.List;

/**
 * Represents the user status.
 *
 * @author Anisha Brightlin
 * @version 0.1
 */
public class Status {

    private List<String> message;
    private Date time;
    private int id;

    public void setStatus(final List<String> message) {
        this.message = message;
    }

    public void setTime(final Date time) {
        this.time = time;
    }

    public void setStatusId(final int id) {
        this.id = id;
    }

    public List<String> getStatus() {
        return message;
    }

    public Date getStatusTime() {
        return time;
    }

    public int getId() {
        return id;
    }
}