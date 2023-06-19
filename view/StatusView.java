package com.whatsapp.view;

import com.whatsapp.controller.StatusController;
import com.whatsapp.controller.UserController;
import com.whatsapp.controller.ViewersController;

import com.whatsapp.exception.FormatException;

import com.whatsapp.model.Status;
import com.whatsapp.model.User;
import com.whatsapp.model.Viewers;

import com.whatsapp.view.validation.StatusValidation;
import com.whatsapp.view.validation.UserValidation;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * Handles the functionality related to {@link Status}.
 * </p>
 *
 * @author Anisha Brightlin
 * @version 1.0
 */
public class StatusView {

    private static final StatusValidation STATUS_VALIDATION = StatusValidation.getInstance();
    private static final UserValidation USER_VALIDATION = UserValidation.getInstance();
    private static final StatusController STATUS_CONTROLLER = StatusController.getInstance();
    private static final UserController USER_CONTROLLER = UserController.getInstance();
    private static final ViewersController VIEWERS_CONTROLLER = ViewersController.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String YES = "yes";
    private static long statusId = 1;
    private static long viewersId = 1;

    /**
     * <p>
     * Displays the status menu for a user.
     * </p>
     *
     * @param userId Represents the {@link User} id
     */
    public void goToStatus(final long userId) {
        System.out.println("Enter your choice:\n1.Upload status\n2.View status\n3.View other status\n4.Homepage");

        switch (getUserChoice()) {
            case 1:
                upLoadStatus(userId);
                goToStatus(userId);
                break;
            case 2:
                displayStatus(userId);
                goToStatus(userId);
                break;
            case 3:
                viewOthersStatus(userId);
                goToStatus(userId);
                break;
            case 4:
                final UserView userView = new UserView();

                userView.viewHomeScreen(userId);
                break;
            default:
                System.out.println("Enter the valid choice between 1-3");
                goToStatus(userId);
        }
    }

    /**
     * <p>
     * Uploads the user {@link Status}
     * </p>
     *
     * @param userId Represents the {@link User} id
     */
    private void upLoadStatus(final long userId) {

        final User user = USER_CONTROLLER.getUserDetail(userId);
        final Status status = new Status();
        final Calendar calender = Calendar.getInstance();

        status.setFormat(getFormat());
        status.setStatusId(statusId++);
        status.setUserId(userId);
        status.setUploadedTime(calender.getTime());
        System.out.println("Want to add caption if yes press y or yes else no or n");
        String userOption = getUserOption();

        if (userOption.equalsIgnoreCase(YES) || userOption.equalsIgnoreCase("y")) {
            status.setCaption(getCaption());
        }

        if (STATUS_CONTROLLER.isUpload(status)) {
            System.out.println("Uploaded");
        } else {
            System.out.println("Something went wrong retry");
            upLoadStatus(userId);
        }
        user.setStatus(STATUS_CONTROLLER.getStatusList(userId));
    }

    /**
     * <p>
     * Gets the format.
     * </p>
     *
     * @return the format number
     */
    private int getFormat() throws FormatException {

        try {
            System.out.println("Enter the status format:\n1.Text\n2.Links\n3.Gif\n4.Photo\n5.Video\n6.Voice");
            final String format = SCANNER.nextLine().trim();

            if (USER_VALIDATION.isValidChoice(format)) {
                final int choice = Integer.parseInt(format);

                if (choice >= 1 && choice <= 6) {
                    return choice;
                } else {
                    throw new FormatException("Invalid format choice. Please enter a choice between 1-6.");
                }
            } else {
                throw new FormatException("Invalid format choice. Enter the valid format");
            }
        } catch (FormatException formatException) {
            System.out.println(formatException.getMessage());
        }
        return getFormat();
    }

    /**
     * <p>
     * Gets the caption.
     * </p>
     *
     * @return the caption
     */
    private String getCaption() {
        System.out.println("Enter the caption");
        final String caption = SCANNER.nextLine().trim();

        return STATUS_VALIDATION.checkValidCaption(caption) ? caption : getCaption();
    }

    /**
     * <p>
     * Displays the {@link Status} for the provided user id
     * </p>
     *
     * @param userId Represents the user id
     */
    private void displayStatus(final long userId) {

        final User user = USER_CONTROLLER.getUserDetail(userId);

        if (user == null || user.getStatus() == null) {
            System.out.println("No status found for the user.");
            goToStatus(userId);
        }
        System.out.println("The statuses are:");

        for (final Status status : user.getStatus()) {

            try {
                Thread.sleep(2000);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            System.out.println(status);
        }

        if (VIEWERS_CONTROLLER.getViewers(userId).isEmpty()) {
            System.out.println("No viewers");
        } else {
            System.out.println("The status viewers are");
            System.out.println(VIEWERS_CONTROLLER.getViewers(userId));
        }
    }

    /**
     * <p>
     * Views the other's status
     * </p>
     *
     * @param userId Represents the {@link User} id
     */
    private void viewOthersStatus(final long userId) {

        final Viewers viewers = new Viewers();
        final Calendar calender = Calendar.getInstance();
        final List<Long> userStatus = STATUS_CONTROLLER.getStatusIdList(userId);

        if (userStatus.isEmpty()) {
            System.out.println("There is no status");
            goToStatus(userId);
        }
        System.out.println("Whose status do you want to view");

        for (final Long statusId : userStatus) {
            System.out.println("User id: " + statusId);
        }
        System.out.println("Enter the user id that you want to view");
        final String othersId = SCANNER.nextLine();

        if (STATUS_CONTROLLER.isIdExist(Long.parseLong(othersId))) {
            System.out.println("There are " + STATUS_CONTROLLER.getStatusId(Long.parseLong(othersId)) + " status");
            final List<Status> otherStatus = STATUS_CONTROLLER.getStatusList(Long.parseLong(othersId));

            System.out.println("The Status are");

            for (final Status status : otherStatus) {

                try {
                    Thread.sleep(2000);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                System.out.println(status);
            }
        } else {
            System.out.println("Enter the valid user id");
            viewOthersStatus(userId);
        }
        viewers.setCurrentUserId(userId);
        viewers.setTime(calender.getTime());
        viewers.setViewersId(viewersId++);
        viewers.setOtherUser(Long.parseLong(othersId));

        if (VIEWERS_CONTROLLER.isStatusViewed(viewers)) {
            System.out.println("Viewed..");
        } else {
            System.out.println("Something went wrong retry");
            viewOthersStatus(userId);
        }
    }

    /**
     * <p>
     * Gets the choice.
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
     * @return the option
     */
    private String getUserOption() {
        System.out.println("Enter your choice:");
        final String option = SCANNER.nextLine().trim();

        return USER_VALIDATION.isValidOption(option) ? option : getUserOption();
    }
}