package com.whatsapp.view.validation;

/**
 * Validates the user status
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class StatusValidation {

    private static final StatusValidation STATUS_VALIDATION = new StatusValidation();

    private StatusValidation() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link StatusValidation} instance.
     */
    public static StatusValidation getInstance() {
        return STATUS_VALIDATION;
    }

    /**
     * Validates the status caption
     *
     * @param caption Represents the caption
     * @return true if the caption is valid else false
     */
    public boolean checkValidCaption(final String caption) {
        return caption.matches("^[\\sA-Za-z0-9!@#$%^&*()_+=-]{1,3000}$");
    }
}