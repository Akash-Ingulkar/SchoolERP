package com.esparse_matrix.schoolerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esparse_matrix.schoolerp.Services.Interface;
import com.esparse_matrix.schoolerp.model.Admin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class SignInActivity extends AppCompatActivity {
    private static final String KEY_EMPTY = "";
    public String email1,pass1;
    Button signin;
    EditText email,password;
    public static SharedPreferences prefs;
    public static SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signin = findViewById(R.id.btn_signin);
        email = findViewById(R.id.useremail);
        password = findViewById(R.id.userpassword);

        prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        editor = prefs.edit();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email1 = email.getText().toString().trim();
                pass1 = password.getText().toString().trim();

                if(validateInputs()) {
                    login();
                }
            }
        });

    }

    private void login() {

        final String username = email.getText().toString().trim();
        // final int phone = Integer.parseInt(phone1);
        final String pass = password.getText().toString().trim();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Interface api = retrofit.create(Interface.class);

        Call<Admin> call = api.AdminLogin(username, pass);

        call.enqueue(new Callback<Admin>() {
            @Override
            public void onResponse(Call<Admin> call, Response<Admin> response) {
                if(response.body().getStatus().equals("true")) {

                    Admin users = response.body();

                    editor.putString("email", users.getAdminemail());
                    editor.putString("id", users.getId());
                    editor.commit();
                    parseLoginData(users);
                }
                else{
                    Toast.makeText(SignInActivity.this, "Invalid user name", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Admin> call, Throwable t) {

                Toast.makeText(SignInActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void parseLoginData(Admin response) {
        try {

            Toast.makeText(SignInActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(SignInActivity.this,NavigationDrawerActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            this.finish();
            Intent intent = new Intent(SignInActivity.this, Dashboard.class);
            startActivity(intent);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateInputs() {
        if (KEY_EMPTY.equals(email1)) {
            email.setError("username cannot be empty");
              email.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(pass1)) {
            password.setError("Password cannot be empty");
            password.requestFocus();
            return false;
        }
        return true;
    }
}