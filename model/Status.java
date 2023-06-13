package com.whatsapp.model;

import java.util.Date;

/**
 * Denotes the status of a user. It encompasses details such as id, status caption, timestamp and an optional
 * accompanying message.
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class Status {

    private String caption;
    private Date time;
    private long id;
    private Format format;
    private long userId;

    /**
     * Describes the status format.
     */
    public enum Format {
        TEXT, LINK, GIF, PHOTO, VIDEO, VOICE
    }

    public void setFormat(final Format format) {
        this.format = format;
    }

    public void setCaption(final String caption) {
        this.caption = caption;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public void setTime(final Date time) {
        this.time = time;
    }

    public void setStatusId(final long id) {
        this.id = id;
    }

    public Format getFormat() {
        return format;
    }

    public String getCaption() {
        return caption;
    }

    public Date getStatusTime() {
        return time;
    }

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String toString() {
        return String.format("%x %s %s %s", id, format, caption, time);
    }
}