package com.whatsapp.view;

import com.whatsapp.controller.StatusController;
import com.whatsapp.controller.UserController;
import com.whatsapp.controller.ViewersController;

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
        user.setStatus(STATUS_CONTROLLER.getStatusList(userId));
    }

    /**
     * <p>
     * Gets the format.
     * </p>
     *
     * @return the format number
     */
    private int getFormat() {
        System.out.println("Enter the status format:\n1.Text\n2.Links\n3.Gif\n4.Photo\n5.Video\n6.Voice");

        return SCANNER.nextInt();
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
        System.out.println(STATUS_CONTROLLER.getStatus(userId));
        System.out.println("The Status viewers are");

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

        System.out.println("Whose status do you want to view");
        final List<Long> userStatus = STATUS_CONTROLLER.getStatusIdList(userId);

        for (final Long statusId : userStatus) {
            System.out.println("User id: " + statusId);
        }
        System.out.println("Enter the user id that you want to view");
        final long othersId = SCANNER.nextLong();

        System.out.println("The status ids are" + STATUS_CONTROLLER.getStatusId(othersId));
        System.out.println("Enter the status id ");
        final long statusId = SCANNER.nextLong();

        System.out.println("The status is" + STATUS_CONTROLLER.getOthersStatus(statusId));
        viewers.setCurrentUserId(userId);
        viewers.setStatusId(statusId);
        viewers.setTime(calender.getTime());
        viewers.setViewersId(viewersId++);
        viewers.setOtherUser(othersId);

        if (VIEWERS_CONTROLLER.isStatusViewed(viewers)) {
            System.out.println("Viewed..");
        } else {
            System.out.println("Something went wrong retry");
            viewOthersStatus(userId);
        }
    }

    //TODO move these below statements to another method
    //Status status = new Status();

    //if (STATUS_CONTROLLER.isExpired(status.getStatusTime())) {
    //status = null;

    //System.out.println("Status has expired and has been deleted.");
    // } else {
    //System.out.println(status);
    //System.out.println("Status is still within the 24-hour limit.");
    //}


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