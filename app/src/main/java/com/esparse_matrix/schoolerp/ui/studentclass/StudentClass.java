package com.esparse_matrix.schoolerp.ui.studentclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esparse_matrix.schoolerp.MainActivity;
import com.esparse_matrix.schoolerp.R;
import com.esparse_matrix.schoolerp.model.StudentClassList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentClass extends AppCompatActivity {

    private static final String KEY_EMPTY = "";
    public String class1,section1;
    Button addclass;
    EditText classname,section;
    String[] classattendance = new String[5];


    public static SharedPreferences prefs;
    public static SharedPreferences.Editor editor ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_class);

        addclass = findViewById(R.id.crr_button1);
        classname = findViewById(R.id.crr_classname);
        section = findViewById(R.id.crr_section);

        addclass.setOnClickListener((View.OnClickListener) this);
        classname.setOnClickListener((View.OnClickListener) this);
        section.setOnClickListener((View.OnClickListener) this);

        prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        editor = prefs.edit();

addclass.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        createreceipt();
        Log.e("gen button", "clicked");
    }

    private void createreceipt() {
        class1 = classname.getText().toString().trim();
        section1 = section.getText().toString().trim();

        private boolean validateInputs()
    {
            if (KEY_EMPTY.equals(class1)) {
                classname.setError("classname cannot be empty");
                classname.requestFocus();
            }
            if (KEY_EMPTY.equals(section1)) {
                section.setError("section cannot be empty");
                section.requestFocus();
            } else {
                Call<StudentClassList> rentReceiptCall = MainActivity.serviceApiStudentclass.uploadclass(classname, section);
                rentReceiptCall.enqueue(new Callback<StudentClassList>() {
                    @Override
                    public void onResponse(Call<StudentClassList> call, Response<StudentClassList> response) {
                        if (response.body() != null) {
                            switch (response.body().getResponse()) {
                                case "inserted":
                                    Log.e("response", response.body().getResponse());
                                    classname.setText("");
                                    section.setText("");

                                    MainActivity.appPreference.showToast("Rent-Receipt Created Successfully");
                                    break;
                                case "error":
                                    MainActivity.appPreference.showToast("Oops! something went wrong.");
                                    break;
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<StudentClassList> call, Throwable t) {
                    }
                });
            }

        }


    }
