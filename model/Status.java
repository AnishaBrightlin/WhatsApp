package com.whatsapp.model;

import com.whatsapp.exception.FormatException;

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
    private String uploadedTime;
    private long id;
    private Format format;
    private long userId;
    private List<User> viewersList;

    /**
     * Describes the status format.
     */
    public enum Format {

        TEXT(1), LINK(2), GIF(3), PHOTO(4), VIDEO(5), VOICE(6);
        private int value;

        Format(final int value) {
            this.value = value;
        }

        public static Format get(int userChoice) throws FormatException {

            for (final Format format : Format.values()) {

                if (format.value == userChoice) {
                    return format;
                }
            }
            throw new FormatException("Invalid format choice.");
        }
    }

    public void setFormat(final int userChoice) {
        this.format = Format.get(userChoice);
    }

    public void setCaption(final String caption) {
        this.caption = caption;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public void setUploadedTime(final String uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public void setStatusId(final long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public void setViewersList(final List<User> viewersList) {
        this.viewersList = viewersList;
    }

    public Format getFormat() {
        return format;
    }

    public String getCaption() {
        return caption;
    }

    public String getStatusTime() {
        return uploadedTime;
    }

    public List<User> getViewersList() {
        return viewersList;
    }

    public String toString() {
        return String.format("StatusId: %x Caption: %s UploadedTime: %s", id, caption, uploadedTime);
    }
}