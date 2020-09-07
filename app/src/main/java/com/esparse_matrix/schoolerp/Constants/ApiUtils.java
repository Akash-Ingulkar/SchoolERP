package com.esparse_matrix.schoolerp.Constants;

import com.esparse_matrix.schoolerp.RetrofitClient;
import com.esparse_matrix.schoolerp.Services.Interface;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://erp.sparsematrix.co.in/SchoolERP/Admin/";

    public static Interface getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(Interface.class);


    }
}
