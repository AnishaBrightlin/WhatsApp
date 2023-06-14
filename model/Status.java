package com.whatsapp.model;

import java.util.Date;

/**
 * Denotes the status of a user.
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
        TEXT(1), LINK(2), GIF(3), PHOTO(4), VIDEO(5), VOICE(6);
        private int value;

        Format(final int value) {
            this.value = value;
        }
    }

    public void setFormat(final int userChoice) {
        this.format = getFormatFromUser(userChoice);
    }

    private Format getFormatFromUser(final int userChoice) {

        switch (userChoice) {
            case 1:
                return Format.TEXT;
            case 2:
                return Format.LINK;
            case 3:
                return Format.GIF;
            case 4:
                return Format.PHOTO;
            case 5:
                return Format.VIDEO;
            case 6:
                return Format.VOICE;
            default:
                return null;
        }
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