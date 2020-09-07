package com.esparse_matrix.schoolerp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.SyncStateContract;

import com.esparse_matrix.schoolerp.Constants.ApiUtils;
import com.esparse_matrix.schoolerp.Constants.Constant;
import com.esparse_matrix.schoolerp.Services.ServiceApiStudentclass;

public class MainActivity extends AppCompatActivity implements MyInterface {
    public static ServiceApiStudentclass serviceApiStudentclass;
    public static AppPreference appPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceApiStudentclass = RetrofitClient.getClient(Constant.baseUrl.BASE_URL).create(ServiceApiStudentclass.class);

    }

    @Override
    public void register() {

    }

    @Override
    public void registerL() {

    }

    @Override
    public void login(String name, String email, String created_at) {

    }

    @Override
    public void logout() {

    }
}