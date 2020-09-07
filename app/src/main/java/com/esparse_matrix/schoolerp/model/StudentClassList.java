package com.esparse_matrix.schoolerp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentClassList {
    @SerializedName("response")
    @Expose
    private String response;


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("class_name")
    @Expose
    private String class_name;

    @SerializedName("section")
    @Expose
    private String section;

    public String getResponse() {
        return response;
    }


    public StudentClassList(String status, String class_name, String message, String section) {
        this.status = status;
        this.class_name = class_name;
        this.message = message;
        this.section = section;
    }

    public void setclass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_name() {
        return class_name;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void section(String password) {
        this.section = password;
    }

    public String getsection() {
        return section;
    }



}
