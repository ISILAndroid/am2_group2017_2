package com.isil.am2template.model.entity;

import java.io.Serializable;

/**
 * Created by emedinaa on 15/09/15.
 */
public class NoteBLEntity implements Serializable {

    private String objectId;
    private String title;
    private String description;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
