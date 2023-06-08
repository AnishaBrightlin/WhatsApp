package com.whatsapp.view.validation;

public class StatusValidation {

    /**
     * Validates the user's status
     *
     * @param status the status to validate
     * @return true if the status is valid else false
     */
    public boolean checkStatusLength(final String status) {
        return status.matches("^{1,30}$");
    }
}
