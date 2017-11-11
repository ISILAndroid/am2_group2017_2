package com.isil.am2template.storage.request.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emedinaa on 10/11/17.
 */
/*
{
    "updated": 1510343508518,
    "ownerId": "B0254EE8-CC3E-EDD8-FF5A-423577F08F00",
    "email": "admin@admin.com",
    "created": 1510343190008,
    "objectId": "B0254EE8-CC3E-EDD8-FF5A-423577F08F00",
    "name": "Admin",
    "userStatus": "ENABLED",
    "lastLogin": 1510343514314,
    "___class": "Users",
    "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"password\",\"updated\",\"ownerId\",\"email\",\"created\",\"objectId\",\"name\",\"userStatus\",\"lastLogin\",\"__updated__meta\",\"___class\"],\"relatedObjects\":{}}",
    "user-token": "5E6732BF-CFF9-72E6-FF19-1C0145061A00"
}
 */
public class LogInBLResponse {
    private String ownerId;
    private String email;
    private String name;

    @SerializedName("user-token")
    private String token;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
