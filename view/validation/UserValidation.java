package com.whatsapp.view.validation;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * <p>
 * Validates the user details
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class UserValidation {

    private static final UserValidation USER_VALIDATION = new UserValidation();

    private UserValidation() {
    }

    /**
     * <p>
     * Gets the instance of the class.
     * </p>
     *
     * @return the {@link UserValidation} instance.
     */
    public static UserValidation getInstance() {
        return USER_VALIDATION;
    }

    /**
     * <p>
     * Validates the mobile number
     * </p>
     *
     * @param mobileNumber Represents the user mobile number
     * @return true if the mobile number is valid else false
     */
   public boolean isValidMobileNumber(final String countryCode, final String mobileNumber) {

        if (countryCode.matches("^\\+\\d{1,3}$")) {

            switch (countryCode) {
                case "+93":
                    return mobileNumber.matches("^0\\d{9}$");
                case "+91":
                    return mobileNumber.matches("[6-9]\\d{9}");
                case "+61":
                    return mobileNumber.matches("04\\d{8}");
                case "+1":
                    return mobileNumber.matches("[4-8]\\d{9}");
                case "+299":
                    return mobileNumber.matches("[0-9]{6}");
            }
            return false;
        }
        return false;
    }

    /**
     * <p>
     * Validates the user choice
     * </p>
     *
     * @param choice Represents the user choice
     * @return true if the choice is valid else false
     */
    public boolean isValidChoice(final String choice) {
        return choice.matches("[\\d]");
    }

    /**
     * <p>
     * Validates the user option
     * </p>
     *
     * @param option Represents the user option
     * @return true if the option is valid else false
     */
    public boolean isValidOption(final String option) {
        return option.matches("(?i)^(yes|no|y|n)$");//[Y|y]|[N|n]$");
    }

    /**
     * <p>
     * Validates the userName
     * </p>
     *
     * @param name Represents the username
     * @return true if the name is valid else false
     */
    public boolean isValidateName(final String name) {
        return name.matches("^[A-Za-z0-9\\s]+$");
    }

    /**
     * <p>
     * Validates the user date of birth
     * </p>
     *
     * @param dateOfBirth Represents the user date of birth
     * @return true if the date of birth is valid else false
     */
    public boolean isValidDateOfBirth(final String dateOfBirth) {

        try {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);
            final LocalDate date = LocalDate.parse(dateOfBirth, dateFormatter);
            final LocalDate currentDate = LocalDate.now();

            if (date.getYear() < 1940 || date.isAfter(currentDate)) {
                return false;
            }
            return true;
        } catch (final DateTimeParseException exception) {
            return false;
        }
    }
}