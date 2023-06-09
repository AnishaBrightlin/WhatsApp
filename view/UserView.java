package com.whatsapp.view;

import com.whatsapp.controller.StatusController;
import com.whatsapp.controller.UserController;
import com.whatsapp.model.Status;
import com.whatsapp.model.User;
import com.whatsapp.view.validation.StatusValidation;
import com.whatsapp.view.validation.UserValidation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    private static int userId = 0;
    private static int statusId = 0;


    /**
     * Sets the values of the user
     */
    private void signUp() {
        System.out.println("Enter 1 for sign up and 2 for exit");

        switch (getUserChoice()) {
            case 1:
                final User user = new User();

                user.setId(++userId);
                user.setMobileNumber(getMobileNumber());
                user.setDateOfBirth(getDateOfBirth());
                user.setName(getName());
                user.setAbout(getAbout());

                if (USER_CONTROLLER.signUp(user)) {
                    System.out.println("Sign up successfully");
                } else {
                    System.out.println("Something went wrong retry");
                    signUp();
                }
                break;
            case 2:
                SCANNER.close();
                System.exit(0);
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
        System.out.println("For mobile number verification");

        if (verifyMobileNumber()) {
            System.out.println("Sign in successfully");
            viewHomeScreen();
        } else {
            System.out.println("The mobile number is not exist please sign up");
            signUp();
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
                SCANNER.close();
                System.exit(0);
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
        System.out.println("Enter your choice:\n1.Put status\n2.View other's status\n3.Homepage");

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
     * Puts the status of the user
     */
    private void putStatus() {
        System.out.println("Enter your choice:\n1.Put status\n2.Back to view status");
        final Status status = new Status();
        final List<String> userStatus = new ArrayList<>();

        switch (getUserChoice()) {
            case 1:
                userStatus.add(getMessage());
                System.out.println("Again you want to add a status if yes enter Y/y else N/n");
                final String option = getUserOption();

                if ("y".equals(option) || "Y" .equals(option)) {
                    userStatus.add(getMessage());;
                }
                break;
            case 2:
                viewStatus();
                break;
            default:
                System.out.println("Enter the valid choice 1 or 2");
                putStatus();
        }
        final Calendar calender = Calendar.getInstance();

        status.setStatus(userStatus);
        status.setTime(calender.getTime());
        status.setStatusId(++statusId);

        if (STATUS_CONTROLLER.putStatus(status)) {
            System.out.println("Uploaded");
        } else {
            System.out.println("Something went wrong retry");
            putStatus();
        }
    }

    /**
     * Gets the status message from the user
     *
     * @return the message
     */
    private String getMessage() {
        System.out.println("Enter the status message");
        final String message = SCANNER.nextLine().trim();

        return STATUS_VALIDATION.isValidStatus(message) ? message : getMessage();
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
     * Gets about the user.
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
        System.out.println("Enter the id");
        final int id = SCANNER.nextInt();

        System.out.println(USER_CONTROLLER.getUserDetail(id));
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
        final User user = USER_CONTROLLER.getUserDetail(1);

        System.out.println("If you want to update the name enter Y/y else N/n");
        String option = getUserOption();

        if ("y".equals(option) || "Y".equals(option)) {
            user.setName(getName());
        } else {
            user.setName(user.getName());
        }
        System.out.println("If you want to update the date of birth enter Y/y else N/n");
        option = getUserOption();

        if ("y".equals(option) || "Y".equals(option)) {
            user.setDateOfBirth(getDateOfBirth());
        } else {
            user.setDateOfBirth(user.getDateOfBirth());
        }

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
     * @return the choice
     */
    private int getUserChoice() {
        System.out.println("Enter your choice:");
        final String choice = SCANNER.nextLine().trim();

        return USER_VALIDATION.checkValidChoice(choice) ? Integer.parseInt(choice) : getUserChoice();
    }

    /**
     * Gets the option from the user
     *
     * @return the option
     */
    private String getUserOption() {
        System.out.println("Enter your choice:");
        final String option = SCANNER.nextLine().trim();

        return USER_VALIDATION.isValidOption(option) ? option : getUserOption();
    }

    /**
     * Gets the country code
     *
     * @return the country code
     */
    private String getCountryCode() {
        System.out.println("Enter the country code (must include +)");
        final String countryCode = SCANNER.nextLine().trim();

        return countryCode;
    }

    /**
     * Gets the valid mobile number of the user
     *
     * @return the mobile number
     */
    private String getValidMobileNumber() {
        System.out.println("Enter the mobile number (must be a digit)");
        System.out.println("Press * to terminate the entire process");
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

        if (runtimeExitStatus(mobileNumber) || runtimeExitStatus(countryCode)) {
            SCANNER.close();
            System.exit(0);
        }
        return USER_VALIDATION.isValidMobileNumber(countryCode, mobileNumber) ? mobileNumber : getMobileNumber();
    }

    /**
     * Gets the Date of birth of the user
     *
     * @return Returns the date of birth
     */
    private String getDateOfBirth() {
        System.out.println("Enter the date Of birth(DD-MM-YYYY)");
        System.out.println("Press * to terminate the entire process");
        final String dateOfBirth = SCANNER.nextLine().trim();

        if (runtimeExitStatus(dateOfBirth)) {
            SCANNER.close();
            System.exit(0);
        }
        return USER_VALIDATION.isDateOfBirthValid(dateOfBirth) ? dateOfBirth : getDateOfBirth();
    }

    /**
     * Gets the name of the user
     *
     * @return Returns the name
     */
    private String getName() {
        System.out.println("Enter user name");
        System.out.println("Press * to terminate the entire process");
        final String name = SCANNER.nextLine().trim();

        if (runtimeExitStatus(name)) {
            SCANNER.close();
            System.exit(0);
        }
        return USER_VALIDATION.checkName(name) ? name : getName();
    }

    /**
     * Exits form the entire process.
     */
    private boolean runtimeExitStatus(final String detail) {
        return detail.contains("*");
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