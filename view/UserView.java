package com.whatsapp.view;

import com.whatsapp.controller.StatusController;
import com.whatsapp.controller.UserController;
import com.whatsapp.model.Status;
import com.whatsapp.model.User;
import com.whatsapp.view.validation.StatusValidation;
import com.whatsapp.view.validation.UserValidation;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Allows users to sign up, sign in, view and update their profiles, and delete their accounts.
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class UserView {

    private static final UserController USER_CONTROLLER = new UserController();
    private static final StatusController STATUS_CONTROLLER = new StatusController();
    private static final UserValidation USER_VALIDATION = new UserValidation();
    private static final StatusValidation STATUS_VALIDATION = new StatusValidation();
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Gets and sets the values of the user
     */
    private void signUp() {
        System.out.println("Enter 1 for sign up and 2 for exit");

        switch (getUserChoice()) {
            case 1:
                final User user = new User();

                user.setMobileNumber(getMobileNumber());
                user.setDateOfBirth(getDateOfBirth());
                user.setName(getName());
                user.setAbout(getAbout());
                USER_CONTROLLER.signUp(user);
                break;
            case 2:
                getChoice();
                break;
            default:
                System.out.println("Enter the valid choice 1 or 2");
                signUp();
        }
    }

    /**
     * Verifies the mobile number and allow them to perform the required action
     */
    private void signIn() {
        if (verifyMobileNumber()) {
            System.out.println("Sign in successfully");
            viewHomeScreen();
        } else {
            System.out.println("The mobile number is not exist please sign up");
            signIn();
        }
    }

    /**
     * Views profiles and status of the user.
     */
    private void viewHomeScreen() {
        System.out.println("Enter your choice:\n1.Go to profile\n2.Put status\n3.Get contact list\n4.Exit");

        switch (getUserChoice()) {
            case 1:
                viewProfile();
                viewHomeScreen();
                break;
            case 2:
                viewStatus();
                viewHomeScreen();
                break;
            case 4:
                signUp();
                break;
            default:
                System.out.println("Enter the valid choice between 1-3");
                viewHomeScreen();
        }
    }

    /**
     * Displays, updates and deletes the user details
     */
    private void viewProfile() {
        System.out.println("Enter your choice:\n1.Display profile\n2.Update profile\n3.Delete account\n4.Home page");

        switch (getUserChoice()) {
            case 1:
                displayProfileDetails();
                viewProfile();
                break;
            case 2:
                updateProfile();
                viewProfile();
                break;
            case 3:
                deleteAccount();
                viewProfile();
                break;
            case 4:
                viewHomeScreen();
                break;
            default:
                System.out.println("Enter the valid choice between 1-4");
                viewProfile();
        }
    }

    /**
     * Puts and view the other's status.
     */
    private void viewStatus() {
        System.out.println("Enter your choice:\n1.Put status\n2.View other's status\n3.Exit");

        switch (getUserChoice()) {
            case 1:
                putStatus();
                viewStatus();
                break;
            case 2:
                viewOthersStatus();
                viewStatus();
                break;
            case 3:
                viewHomeScreen();
                break;
            default:
                System.out.println("Enter the valid choice between 1-3");
                viewStatus();
        }
    }

    /**
     * Appends the status of the user
     */
    private void putStatus() {
        System.out.println("Enter your choice:\n1.Put status\n2.Exit");
        final Status status = new Status();

        switch (getUserChoice()) {
            case 1:
                System.out.println("Enter the status");
                final String UserStatus = SCANNER.nextLine().trim();

                if (STATUS_VALIDATION.checkStatusLength(UserStatus)) {
                    status.setStatus(UserStatus);
                } else {
                    System.out.println("The status length should be within 30 characters");
                    putStatus();
                }
                putStatus();
                break;
            case 2:
                viewStatus();
                break;
            default:
                System.out.println("Enter the valid choice 1 or 2");
                putStatus();
        }
        final Calendar calender = Calendar.getInstance();

        status.setTime(calender.getTime());
        STATUS_CONTROLLER.putStatus(status);
    }

    /**
     * Views the other's status
     */
    private void viewOthersStatus() {
        Status status = new Status();

        if (STATUS_CONTROLLER.isExpired(status.getStatusTime())) {
            status = null;

            System.out.println("Post has expired and has been deleted.");
        } else {
            System.out.println(status);
            //System.out.println("Post is still within the 24-hour limit.");
        }
    }

    /**
     * Sets about the user.
     *
     * @return the user about
     */
    private String getAbout() {
        System.out.println("Press 1 for predefined about and press 2 for custom about");
        String about = null;

        switch (getUserChoice()) {
            case 1:
                System.out.println("Enter you choice:\n1.Online class\n2.Available\n3.Busy\n4.At school\n5.At movies");

                switch (getUserChoice()) {
                    case 1:
                        about = "Online class";
                        break;
                    case 2:
                        about = "Available";
                        break;
                    case 3:
                        about = "Busy";
                        break;
                    case 4:
                        about = "At school";
                        break;
                    case 5:
                        about = "At movies";
                        break;
                    default:
                        System.out.println("Enter the valid choice between 1-5");
                        getAbout();
                }
                break;
            case 2:
                System.out.println("Enter your about");
                about = SCANNER.nextLine();

                break;
            default:
                System.out.println("Enter the valid choice 1 or 2");
                getAbout();
        }
        return about;
    }

    /**
     * Displays the user details
     */
    private void displayProfileDetails() {
        System.out.println("Enter the mobile number");
        System.out.println(USER_CONTROLLER.getUserDetail(getMobileNumber()));
    }

    /**
     * Deletes the user account
     */
    private void deleteAccount() {
        System.out.println("Deleting your account is permanent. Your data cannot recovered. Press 1 to delete 2 to exit");

        switch (getUserChoice()) {
            case 1:

                if (USER_CONTROLLER.deleteAccount(getMobileNumber())) {
                    System.out.println("Account is deleted");
                    getChoice();
                } else {
                    System.out.println("Enter the valid mobile number");
                    deleteAccount();
                }
                break;
            case 2:
                viewProfile();
                break;
            default:
                System.out.println("Enter the valid choice 1 or 2");
                deleteAccount();
        }
    }

    /**
     * Updates the user details
     */
    private void updateProfile() {
        final User user = new User();

        System.out.println("Enter your choice:\n1.Update name\n2.Date of birth\n3.Exit");
        displayProfileDetails();

        switch (getUserChoice()) {
            case 1:
                user.setName(getName());
                updateProfile();
                break;
            case 2:
                user.setDateOfBirth(getDateOfBirth());
                updateProfile();
                break;
            case 3:
                viewProfile();
                break;
            default:
                System.out.println("Enter the valid choice between 1-3");
                updateProfile();
        }
        System.out.println(user);

        if (USER_CONTROLLER.updateProfile(user)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Retry");
            updateProfile();
        }
    }

    /**
     * Gets the choice from the user
     *
     * @return Return the choice
     */
    private int getUserChoice() {
        System.out.println("Enter your choice:");
        final String choice = SCANNER.nextLine().trim();

        return USER_VALIDATION.checkValidChoice(choice) ? Integer.parseInt(choice) : getUserChoice();
    }

    /**
     * Gets the country code
     *
     * @return the country code
     */
    private String getCountryCode() {
        System.out.println("Enter the country code (must include +)");
        final String countryCode = SCANNER.nextLine().trim();

        return USER_VALIDATION.isValidCountryCode(countryCode) ? countryCode : getCountryCode();
    }

    /**
     * Gets the valid mobile number of the user
     *
     * @return the mobile number
     */
    private String getValidMobileNumber() {
        System.out.println("Enter the mobile number (must be a digit)");
        final String mobileNumber = SCANNER.nextLine().trim();

        return mobileNumber;
    }

    /**
     * Validates the mobile number with respect to country code.
     *
     * @return the valid mobile number
     */
    private String getMobileNumber() {
        final String countryCode = getCountryCode();
        final String mobileNumber = getValidMobileNumber();

        return USER_VALIDATION.isValidMobileNumber(countryCode, mobileNumber) ? mobileNumber : getMobileNumber();
    }

    /**
     * Gets the Date of birth of the user
     *
     * @return Returns the date of birth
     */
    private String getDateOfBirth() {
        System.out.println("Enter the date Of birth(DD-MM-YYYY)");
        final String dateOfBirth = SCANNER.nextLine().trim();

        return USER_VALIDATION.isDateOfBirthValid(dateOfBirth) ? dateOfBirth : getDateOfBirth();
    }

    /**
     * Gets the name of the user
     *
     * @return Returns the name
     */
    private String getName() {
        System.out.println("Enter user name");
        final String name = SCANNER.nextLine().trim();

        return USER_VALIDATION.checkName(name) ? name : getName();
    }

    /**
     * Verifies the mobile number that's already sign up or not
     *
     * @return true if the mobile number is already sign up else false
     */
    private boolean verifyMobileNumber() {
        return USER_CONTROLLER.signIn(getMobileNumber());
    }

    public static void main(String[] args) {
        System.out.println("WhatsApp from Meta");
        final UserView view = new UserView();

        view.getChoice();
    }

    /**
     * Allows the user to perform the signUp or signIn process.
     */
    private void getChoice() {
        System.out.println("Enter the choice:\n1.Sign up\n2.Sign in\n3.Exit");

        switch (getUserChoice()) {
            case 1:
                signUp();
                signIn();
                break;
            case 2:
                signIn();
                break;
            case 3:
                SCANNER.close();
                System.exit(0);
                break;
            default:
                System.out.println("Enter the valid choice between 1-3");
                getChoice();
        }
    }
}