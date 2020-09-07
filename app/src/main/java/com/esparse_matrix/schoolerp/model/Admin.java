package com.esparse_matrix.schoolerp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Admin {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("adminemail")
    @Expose
    private String adminemail;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("adminpassword")
    @Expose
    private String password;

    public Admin(String status, String adminemail, String message, String id,String password) {
        this.status = status;
        this.adminemail = adminemail;
        this.message = message;
        this.id = id;
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdminemail() {
        return adminemail;
    }

    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
