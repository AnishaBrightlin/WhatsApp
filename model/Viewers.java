package com.whatsapp.model;

import java.util.List;

/**
 * Denotes the Views for each status
 */
public class Viewers {

    private List<Long> viewersList;
    private long statusId;

    public void setStatusId(final long statusId) {
        this.statusId = statusId;
    }

    public void setViewersList(final List<Long> viewersList) {
        this.viewersList = viewersList;
    }

    public long getStatusId() {
        return statusId;
    }
    public List<Long> getViewersList() {
        return viewersList;
    }
}