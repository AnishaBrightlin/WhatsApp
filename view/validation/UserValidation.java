package com.whatsapp.view.validation;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

/**
 * Validates the user details
 *
 * @version 1.0
 * @author Anisha Brightlin
 */
public class UserValidation {

    /**
     * Validates the user mobile number
     *
     * @param mobileNumber the mobile number to validate
     * @return true if the mobile number is valid else false
     */
    public boolean checkMobileNumber(final String mobileNumber) {
        return mobileNumber.matches("^[6-9]\\d{9}$");
    }

    /**
     * Validates the user's choice
     *
     * @param choice the choice to validate
     * @return true if the choice is valid else false
     */
    public boolean checkValidChoice(final String choice) {
        return choice.matches("[\\d]");
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
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            final LocalDate date = LocalDate.parse(dateOfBirth, dateFormatter);
            final int currentYear = LocalDate.now().getYear();

            if (date.getYear() < 1940 || date.getYear() > currentYear) {
                return false;
            }
            final int maxDayOfMonth = date.getMonth().maxLength();

            if (date.getMonth().equals(Month.FEBRUARY)) {
                final boolean isLeapYear = Year.isLeap(date.getYear());

                if (isLeapYear && date.getDayOfMonth() >= 29) {
                    return false;
                } else if (!isLeapYear && date.getDayOfMonth() > maxDayOfMonth) {
                    return false;
                }
            }

            if (date.getDayOfMonth() > maxDayOfMonth) {
                return false;
            }

            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}



