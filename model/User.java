package com.whatsapp.model;

import java.util.List;

/**
 * Represents a basic entity for storing information about a user. It contains the user details such as id,
 * mobile number, name and status. Providing getters and setters for accessing and modifying its properties.
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class User {

    private String mobileNumber;
    private String dateOfBirth;
    private String name;
    private String about;
    private List<Status> status;
    private long id;

    public void setId(final long id) {
        this.id = id;
    }

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

    public long getId() {
        return id;
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

    public void setStatus(final List<Status> status) {
        this.status = status;
    }

    public List<Status> getStatus() {
        return status;
    }

    public String toString() {
        return String.format("%s %s %s %s ", name, mobileNumber, dateOfBirth, about);
    }
}