package com.whatsapp.view.validation;

/**
 * Validates the user status
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class StatusValidation {

    /**
     * Validates the status length
     *
     * @param status the status to validate
     * @return true if the status is valid else false
     */
    public boolean checkStatusLength(final String status) {
        return status.matches("^{1,30}$");
    }
}
