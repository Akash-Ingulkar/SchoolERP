package com.esparse_matrix.schoolerp.Services;

import com.esparse_matrix.schoolerp.model.StudentClassList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceApiStudentclass {

    @FormUrlEncoded
    @POST("agreement.php")
    Call<StudentClassList> uploadclass(
            @Field("class_name") String class_name, @Field("section") String section);

}
