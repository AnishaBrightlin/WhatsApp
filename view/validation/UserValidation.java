package com.whatsapp.view.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Validates the user details
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class UserValidation {

    /**
     * Validates the user mobile number
     *
     * @param mobileNumber the mobile number to validate
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
     * Validates the user choice
     *
     * @param choice the choice to validate
     * @return true if the choice is valid else false
     */
    public boolean checkValidChoice(final String choice) {
        return choice.matches("[\\d]");
    }

    /**
     * Validates the user option
     *
     * @param option the choice to validate
     * @return true if the choice is valid else false
     */
    public boolean isValidOption(final String option) {
        return option.matches("^[Y|y]|[N|n]");
    }

    /**
     * Validates the userName
     *
     * @param name the name to validate
     * @return true if the name is valid else false
     */
    public boolean checkName(final String name) {
        return name.matches("^[A-Za-z0-9\\s]+$");
    }

    /**
     * Validates the user date of birth
     *
     * @param dateOfBirth the date of birth to validate (in the format DD-MM-YYYY)
     * @return true if the date of birth is valid else false
     */
    public boolean isDateOfBirthValid(final String dateOfBirth) {

        try {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);
            final LocalDate date = LocalDate.parse(dateOfBirth, dateFormatter);
            final int currentYear = LocalDate.now().getYear();

            if (date.getYear() < 1940 || date.getYear() > currentYear) {
                return false;
            }
            return true;
        } catch (final DateTimeParseException exception) {
            return false;
        }

    }
}