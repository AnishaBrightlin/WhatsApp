package com.whatsapp.model;

/**
 * Get and set the user's detail.
 *
 * @version 0.1
 * @author Anisha brightlin
 */
public class User {

    private String mobileNumber;
    private String dateOfBirth;
    private String name;
    private String about;
    private Status status;

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAbout(final String about) {
        this.about = about;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        return String.format("%s %s %s %s ", name, mobileNumber, dateOfBirth, about);
    }
}