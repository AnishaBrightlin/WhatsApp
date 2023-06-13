package com.whatsapp.view;

import com.whatsapp.controller.StatusController;
import com.whatsapp.controller.UserController;
import com.whatsapp.model.Status;
import com.whatsapp.model.User;
import com.whatsapp.view.validation.StatusValidation;
import com.whatsapp.view.validation.UserValidation;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the functionality related to status. It supports various operations such as uploading status,
 * viewing own status, viewing others' status and navigating back to the home screen.
 */
public class StatusView {

    private static final StatusValidation STATUS_VALIDATION = new StatusValidation();
    private static final UserValidation USER_VALIDATION = new UserValidation();
    private static final StatusController STATUS_CONTROLLER = new StatusController();
    private static final UserController USER_CONTROLLER = new UserController();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static long statusId = 1;

    /**
     * Displays the status options menu for a user and handles the navigation based on the user's choice.
     *
     * @param userId the ID of the user accessing the status menu
     */
    public void goToStatus(final long userId) {
        System.out.println("Enter your choice:\n1.Upload status\n2.View status\n3.View other status\n4.Homepage");

        switch (getUserChoice()) {
            case 1:
                upLoadStatus(userId);
                goToStatus(userId);
                break;
            case 2:
                viewStatus(userId);
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
     * Uploads the user status
     */
    private void upLoadStatus(final long userId) {
        final User user = USER_CONTROLLER.getUserDetail(userId);
        final Status status = new Status();
        final Calendar calender = Calendar.getInstance();

        status.setFormat(getFormat());
        status.setStatusId(statusId++);
        status.setUserId(userId);
        System.out.println("Want to add caption if yes press y");

        if (getUserOption().equalsIgnoreCase("y")) {
            status.setCaption(getCaption());
        }
        status.setTime(calender.getTime());

        if (STATUS_CONTROLLER.isUpload(status)) {
            System.out.println("Uploaded");
        } else {
            System.out.println("Something went wrong retry");
            upLoadStatus(userId);
        }
        user.setStatus(STATUS_CONTROLLER.getStatus(userId));
    }

    /**
     * Gets the format of the user.
     *
     * @return the format of the status
     */
    private Status.Format getFormat() {
        System.out.println("Enter the status format:\n1.Text\n2.Links\n3.Gif\n4.Photo\n5.Video\n.6.Voice");

        switch (getUserChoice()) {
            case 1:
                return Status.Format.TEXT;
            case 2:
                return Status.Format.LINK;
            case 3:
                return Status.Format.GIF;
            case 4:
                return Status.Format.PHOTO;
            case 5:
                return Status.Format.VIDEO;
            case 6:
                return Status.Format.VOICE;
            default:
                System.out.println("Enter the valid choice between 1-6");
                getFormat();
        }
        return null;
    }

    /**
     * Gets the caption from the user.
     *
     * @return caption if the caption is valid else again get the caption
     */
    private String getCaption() {
        System.out.println("Enter the caption");
        final String caption = SCANNER.nextLine().trim();

        return STATUS_VALIDATION.checkValidCaption(caption) ? caption : getCaption();
    }

    /**
     * Displays the user status
     */
    private void viewStatus(final long userId) {
        final List<Status> userStatus = STATUS_CONTROLLER.getStatus(userId);

        for (Status status : userStatus) {
            System.out.println("Status id: " + status.getId());
            System.out.println("Caption: " + status.getCaption());
            System.out.println("Format: " + status.getFormat());
            System.out.println("Date: " + status.getStatusTime());
        }
    }

    /**
     * Views the other's status
     */
    private void viewOthersStatus(final long userId) {
        System.out.println("Whose status do you want to view");
        final List<Long> userStatus = STATUS_CONTROLLER.getStatusList(userId);

        for (Long status : userStatus) {
            System.out.println("Status id: " + status);
        }
        System.out.println("Enter the other user id");
        final int choice = SCANNER.nextInt();

        Status status = new Status();

        if (STATUS_CONTROLLER.isExpired(status.getStatusTime())) {
            status = null;

            System.out.println("Status has expired and has been deleted.");
        } else {
            System.out.println(status);
            //System.out.println("Status is still within the 24-hour limit.");
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
}