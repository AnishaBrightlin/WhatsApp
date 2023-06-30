package com.whatsapp.view;

import com.whatsapp.controller.UserController;
import com.whatsapp.model.User;
import com.whatsapp.view.validation.UserValidation;

import java.util.Scanner;

/**
 * <p>
 * Handles the functionality related to {@link User}.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class UserView {

    private static final UserController USER_CONTROLLER = UserController.getInstance();
    private static final UserValidation USER_VALIDATION = UserValidation.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String YES = "yes";
    private static final String[] PREDEFINED_ABOUT_OPTIONS = {
            "Online class",
            "Available",
            "Busy",
            "At school",
            "At movies"
    };

    /**
     * <p>
     * Prompts the user to sign up
     * </p>
     */
    private void signUp() {

        final User user = new User();

        user.setMobileNumber(getMobileNumber());
        user.setDateOfBirth(getDateOfBirth());
        user.setName(getName());
        user.setAbout(getAbout());

        if (USER_CONTROLLER.signUp(user)) {
            System.out.println("Sign up successfully");
            user.setId(USER_CONTROLLER.getUserId(user.getMobileNumber()));
            viewHomeScreen(USER_CONTROLLER.getUserId(user.getMobileNumber()));
        } else {
            System.out.println("Something went wrong retry or the user is  already exist");
            System.out.println("If you had an account already please sign in or sign up with another mobile number");
            getMenuChoice();
        }
    }

    /**
     * <p>
     * Performs the sign-in operation.
     * </p>
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
     * <p>
     * Views the home screen.
     * </p>
     *
     * @param id Represents the user id
     */
    public void viewHomeScreen(final long id) {
        System.out.println("Enter your choice:\n1.View profile\n2.Go to status page\n3.Menu");

        switch (getUserChoice()) {
            case 1:
                viewProfile(id);
                viewHomeScreen(id);
                break;
            case 2:
                goToStatusPage(id);
                viewHomeScreen(id);
                break;
            case 3:
                getMenuChoice();
                break;
            default:
                System.out.println("Enter the valid choice between 1-3");
                viewHomeScreen(id);
        }
    }

    /**
     * <p>
     * Views the profile page
     * </p>
     *
     * @param id Represents the user id
     */
    private void viewProfile(final long id) {
        System.out.println("Enter your choice:\n1.Display profile details\n2.Update profile\n3.Delete account\n4.Home screen");

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
     * <p>
     * Displays the profile details
     * </p>
     *
     * @param id Represents the user id
     */
    private void displayProfileDetails(final long id) {
        System.out.println(USER_CONTROLLER.getUserDetail(id));
    }

    /**
     * <p>
     * Updates the profile.
     * </p>
     *
     * @param id Represents the user id
     */
    private void updateProfile(final long id) {
        final User user = USER_CONTROLLER.getUserDetail(id);

        System.out.println("If you want to update the name enter yes/y else No/n");
        String userOption = getUserOption();

        user.setName(((userOption.equalsIgnoreCase(YES)) || userOption.equalsIgnoreCase("y"))
                ? getName() : user.getName());
        System.out.println("If you want to update the date of birth enter yes/y else no/n");
        userOption = getUserOption();

        user.setDateOfBirth(((userOption.equalsIgnoreCase(YES)) || (userOption.equalsIgnoreCase("y")))
                ? getDateOfBirth() : user.getDateOfBirth());
        System.out.println("If you want to update the about enter yes/y else no/n");
        userOption = getUserOption();

        user.setAbout(((userOption.equalsIgnoreCase(YES)) || (userOption.equalsIgnoreCase("y")))
                ? getAbout() : user.getAbout());

        if (USER_CONTROLLER.isUpdateProfile(user)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Retry");
            updateProfile(id);
        }
    }

    /**
     * <p>
     * Deletes the account with the provided id.
     * </p>
     *
     * @param id Represents the user id
     */
    private void deleteAccount(final long id) {
        System.out.println("Deleting your account is permanent. Your data cannot recovered. Press 1 to delete 2 to exit");

        switch (getUserChoice()) {
            case 1:

                if (USER_CONTROLLER.isAccountDeleted(id)) {
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
     * <p>
     * Navigates to the status page.
     * </p>
     *
     * @param id Represents the user id
     */
    private void goToStatusPage(final long id) {
        final StatusView statusView = new StatusView();

        statusView.goToStatus(id);
        viewHomeScreen(id);
    }

    /**
     * <p>
     * Gets the user about.
     * </p>
     *
     * @return the {@link User} about
     */
    private String getAbout() {
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
                    about = getAbout();
                }
                break;
            case 2:
                System.out.println("Enter your about");
                about = SCANNER.nextLine();

                break;
            default:
                System.out.println("Enter a valid choice 1 or 2");
                about = getAbout();
        }
        return about;
    }

    /**
     * <p>
     * Gets the {@link User} choice
     * </p>
     *
     * @return the choice
     */
    private int getUserChoice() {
        System.out.println("Enter your choice:");
        final String choice = SCANNER.nextLine().trim();

        return USER_VALIDATION.isValidChoice(choice) ? Integer.parseInt(choice) : getUserChoice();
    }

    /**
     * <p>
     * Gets the option.
     * </p>
     *
     * @return the {@link String} option
     */
    private String getUserOption() {
        System.out.println("Enter your choice:");
        final String option = SCANNER.nextLine().trim();

        return USER_VALIDATION.isValidOption(option) ? option : getUserOption();
    }

    /**
     * <p>
     * Gets the country code.
     * </p>
     *
     * @return the {@link String} country code
     */
    private String getCountryCode() {
        System.out.println("Enter the country code (must include +)");

        return SCANNER.nextLine().trim();
    }

    /**
     * <p>
     * Gets the valid mobile number.
     * </p>
     *
     * @return the {@link String} mobile number
     */
    private String getValidMobileNumber() {
        System.out.println("Enter the mobile number (must be a digit)");
        System.out.println("Press * to terminate the current process");

        return SCANNER.nextLine().trim();
    }

    /**
     * <p>
     * Gets the mobile number.
     * </p>
     *
     * @return the {@link String} mobile number
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
     * <p>
     * Gets the Date of birth of the user
     * </p>
     *
     * @return the date of birth
     */
    private String getDateOfBirth() {
        System.out.println("Enter the date Of birth(DD-MM-YYYY)");
        System.out.println("Press * to terminate the current process");
        final String dateOfBirth = SCANNER.nextLine().trim();

        if (backToMenu(dateOfBirth)) {
            getMenuChoice();
        }
        return USER_VALIDATION.isValidDateOfBirth(dateOfBirth) ? dateOfBirth : getDateOfBirth();
    }

    /**
     * <p>
     * Gets the name of the user
     * </p>
     *
     * @return the name
     */
    private String getName() {
        System.out.println("Enter user name");
        System.out.println("Press * to terminate the current process");
        final String name = SCANNER.nextLine().trim();

        if (backToMenu(name)) {
            getMenuChoice();
        }
        return USER_VALIDATION.isValidateName(name) ? name : getName();
    }

    /**
     * <p>
     * Exits the current process.
     * </p>
     *
     * @return true if the input contains the exit string, else false
     */
    private boolean backToMenu(final String detail) {
        return detail.contains("*");
    }

    /**
     * <p>
     * Checks the mobile number is already exist with the provided mobile number
     * </p>
     *
     * @param mobileNumber Represents the user mobile number
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
     * <p>
     * Gets the menu choice from the user.
     * </p>
     */
    private void getMenuChoice() {
        System.out.println("Enter the choice:\n1.Sign up\n2.Sign in\n3.Exit");

        switch (getUserChoice()) {
            case 1:
                signUp();
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