package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper databaseHelper;

    private Button signinbutton, signupbutton;
    private EditText usernametext, passwordtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernametext = (EditText) findViewById(R.id.signinusernameedittextid);
        passwordtext = (EditText) findViewById(R.id.signinpasswordedittextid);

        signinbutton = (Button) findViewById(R.id.signinbuttonid);
        signupbutton = (Button) findViewById(R.id.signupherebuttonid);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signinbutton.setOnClickListener(this);

        signupbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String username = usernametext.getText().toString();
        String password = passwordtext.getText().toString();

        if (v.getId() == R.id.signinbuttonid) {

            if (username.equals("") || password.equals("")) {
                Toast.makeText(getApplicationContext(), "Please fill the all fields", Toast.LENGTH_LONG).show();

            }



        } else if (v.getId() == R.id.signupherebuttonid) {


            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);


        }
    }


}

