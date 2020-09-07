package com.esparse_matrix.schoolerp.Services;

import com.esparse_matrix.schoolerp.model.Admin;
import com.esparse_matrix.schoolerp.model.StudentClassList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Interface {

    @FormUrlEncoded
    @POST("admin_login.php")
    Call<Admin> AdminLogin(
            @Field("adminemail") String email,
            @Field("adminpassword") String password
    );

    @FormUrlEncoded
    @POST("Create_class.php")
    Call<StudentClassList> Createclass(
            @Field("class_name") String classname,
            @Field("section") String section
    );
}
