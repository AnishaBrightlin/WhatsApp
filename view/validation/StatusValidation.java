package com.whatsapp.view.validation;

/**
 * Validates the user status
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class StatusValidation {

    /**
     * Validates the status caption
     *
     * @param caption to validate
     * @return true if the caption is valid else false
     */
    public boolean checkValidCaption(final String caption) {
        return caption.matches("^[\\sA-Za-z0-9!@#$%^&*()_+=-]{1,3000}$");
    }
}