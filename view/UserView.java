package com.whatsapp.view;

import com.whatsapp.controller.UserController;
import com.whatsapp.model.User;
import com.whatsapp.view.validation.UserValidation;

import java.util.Scanner;

/**
 * Allows, users to sign up, sign in, view and update their profiles, and delete their accounts.
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class UserView {

    private static final UserController USER_CONTROLLER = new UserController();
    private static final UserValidation USER_VALIDATION = new UserValidation();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String YES = "y";
    private static long id = 1;
    private static final String[] PREDEFINED_ABOUT_OPTIONS = {
            "Online class",
            "Available",
            "Busy",
            "At school",
            "At movies"
    };

    /**
     * Prompts the user for sign up or exit and performs the corresponding action.
     * This method uses recursion to handle invalid choices.
     */
    private void signUp() {
        System.out.println("Enter 1 for sign up and 2 for exit");

        switch (getUserChoice()) {
            case 1:
                final User user = new User();

                user.setId(id++);
                user.setMobileNumber(getMobileNumber());
                user.setDateOfBirth(getDateOfBirth());
                user.setName(getName());
                user.setAbout(setAbout());

                if (USER_CONTROLLER.signUp(user)) {
                    System.out.println("Sign up successfully");
                    viewHomeScreen(user.getId());
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
     * Performs the sign-in operation if the mobile number is existing.
     */
    private void signIn() {
        System.out.println("For mobile number verification");
        final String mobileNumber = getMobileNumber();

        if (isExistingMobileNumber(mobileNumber)) {
            System.out.println("Sign in successfully");
            viewHomeScreen(USER_CONTROLLER.getUserId(mobileNumber));
        } else {
            System.out.println("The mobile number is not exist please sign up");
            signUp();
        }
    }

    /**
     * Views profiles and status of the user.
     *
     * @param id of the current user
     */
    public void viewHomeScreen(final long id) {
        System.out.println("Enter your choice:\n1.Go to profile\n2.Upload status\n3.Get contact list\n4.Exit");

        switch (getUserChoice()) {
            case 1:
                viewProfile(id);
                viewHomeScreen(id);
                break;
            case 2:
                goToStatus(id);
                viewHomeScreen(id);
                break;
            case 4:
                getMenuChoice();
                break;
            default:
                System.out.println("Enter the valid choice between 1-3");
                viewHomeScreen(id);
        }
    }

    /**
     * Navigates to the status view and displays the status screen.
     * After viewing the status, returns to the home screen.
     *
     * @param id of the current user
     */
    private void goToStatus(final long id) {
        final StatusView statusView = new StatusView();

        statusView.goToStatus(id);
        viewHomeScreen(id);
    }

    /**
     * Displays, updates and deletes the user details
     *
     * @param id of the current user
     */
    private void viewProfile(final long id) {
        System.out.println("Enter your choice:\n1.Display profile\n2.Update profile\n3.Delete account\n4.Home page");

        switch (getUserChoice()) {
            case 1:
                displayProfileDetails(id);
                viewProfile(id);
                break;
            case 2:
                updateProfile(id);
                viewProfile(id);
                break;
            case 3:
                deleteAccount(id);
                viewProfile(id);
                break;
            case 4:
                viewHomeScreen(id);
                break;
            default:
                System.out.println("Enter the valid choice between 1-4");
                viewProfile(id);
        }
    }

    /**
     * Sets about the user.
     *
     * @return the user about
     */
    private String setAbout() {
        System.out.println("Press 1 for predefined about and press 2 for custom about");
        String about = null;

        switch (getUserChoice()) {
            case 1:
                System.out.println("Enter your choice:\n1.Online class\n2.Available\n3.Busy\n4.At school\n5.At movies");
                final int choice = getUserChoice();

                if (choice >= 1 && choice <= PREDEFINED_ABOUT_OPTIONS.length) {
                    about = PREDEFINED_ABOUT_OPTIONS[choice - 1];
                } else {
                    System.out.println("Enter a valid choice between 1-" + PREDEFINED_ABOUT_OPTIONS.length);
                    setAbout();
                }
                break;
            case 2:
                System.out.println("Enter your about");
                about = SCANNER.nextLine();
                break;
            default:
                System.out.println("Enter a valid choice 1 or 2");
                setAbout();
        }
        return about;
    }

    /**
     * Displays the user details
     *
     * @param id of the current user
     */
    private void displayProfileDetails(final long id) {
        System.out.println(USER_CONTROLLER.getUserDetail(id));
    }

    /**
     * Deletes the user account
     *
     * @param id of the current user
     */
    private void deleteAccount(final long id) {
        System.out.println("Deleting your account is permanent. Your data cannot recovered. Press 1 to delete 2 to exit");

        switch (getUserChoice()) {
            case 1:

                if (USER_CONTROLLER.deleteAccount(id)) {
                    System.out.println("Account is deleted");
                    getMenuChoice();
                } else {
                    System.out.println("Enter the valid mobile number");
                    deleteAccount(id);
                }
                break;
            case 2:
                viewProfile(id);
                break;
            default:
                System.out.println("Enter the valid choice 1 or 2");
                deleteAccount(id);
        }
    }

    /**
     * Updates the user details
     *
     * @param id of the current user
     */
    private void updateProfile(final long id) {
        final User user = USER_CONTROLLER.getUserDetail(id);

        System.out.println("If you want to update the name enter Y/y else N/n");
        user.setName(getUserOption().equalsIgnoreCase(YES) ? getName() : user.getName());
        System.out.println("If you want to update the date of birth enter Y/y else N/n");
        user.setDateOfBirth(getUserOption().equalsIgnoreCase(YES) ? getDateOfBirth() : user.getDateOfBirth());

        if (USER_CONTROLLER.isUpdateProfile(user)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Retry");
            updateProfile(id);
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

        return SCANNER.nextLine().trim();
    }

    /**
     * Gets the valid mobile number of the user
     *
     * @return the mobile number
     */
    private String getValidMobileNumber() {
        System.out.println("Enter the mobile number (must be a digit)");
        System.out.println("Press * to terminate the current process");

        return SCANNER.nextLine().trim();
    }

    /**
     * Validates the mobile number with respect to country code.
     *
     * @return the mobile number
     */
    private String getMobileNumber() {
        final String countryCode = getCountryCode();
        final String mobileNumber = getValidMobileNumber();

        if (backToMenu(mobileNumber) || backToMenu(countryCode)) {
            getMenuChoice();
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
        System.out.println("Press * to terminate the current process");
        final String dateOfBirth = SCANNER.nextLine().trim();

        if (backToMenu(dateOfBirth)) {
            getMenuChoice();
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
        System.out.println("Press * to terminate the current process");
        final String name = SCANNER.nextLine().trim();

        if (backToMenu(name)) {
            getMenuChoice();
        }
        return USER_VALIDATION.checkName(name) ? name : getName();
    }

    /**
     * Exits the current process.
     *
     * @return true if the input contains the exit string, else false
     */
    private boolean backToMenu(final String detail) {
        return detail.contains("*");
    }

    /**
     * Verifies the mobile number that's already sign up or not
     *
     * @param mobileNumber of the user
     * @return true if the mobile number is already sign up else false
     */
    private boolean isExistingMobileNumber(final String mobileNumber) {
        return USER_CONTROLLER.isSignIn(mobileNumber);
    }

    public static void main(String[] args) {
        System.out.println("WhatsApp from Meta");
        final UserView view = new UserView();

        view.getMenuChoice();
    }

    /**
     * Allows the user to perform the signUp or signIn process.
     */
    private void getMenuChoice() {
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
                getMenuChoice();
        }
    }
}