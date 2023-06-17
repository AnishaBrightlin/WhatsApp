package com.whatsapp.model;

import com.whatsapp.exception.FormatException;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Represents the status of a user.
 * </p>
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
    private List<Viewers> viewersList;

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

    private Format getFormatFromUser(final int userChoice) throws FormatException {

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
                try {
                    throw new FormatException("Enter the choice between 1-6");
                } catch (FormatException formatException) {
                    System.out.println(formatException);
                }
        }
        return null;
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

    public void setViewersList(final List<Viewers> viewersList) {
        this.viewersList = viewersList;
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

    public List<Viewers> getViewersList() {
        return viewersList;
    }

    public String toString() {
        return String.format("%x %s %s %s", id, format, caption, time);
    }
}