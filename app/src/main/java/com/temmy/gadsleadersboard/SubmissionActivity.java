package com.temmy.gadsleadersboard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SubmissionActivity extends AppCompatActivity {

    EditText Firstname, Surname, Email, Git;
    String mFirstname, mSurname, mEmail, mGit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar toolaction = getSupportActionBar();
        toolaction.setHomeButtonEnabled(true);
        toolaction.setDisplayHomeAsUpEnabled(true);
        toolaction.setIcon(R.drawable.gads2);
        toolaction.setTitle("");

        Firstname = findViewById(R.id.firstname);
        Surname = findViewById(R.id.surname);
        Email = findViewById(R.id.email);
        Git = findViewById(R.id.gitlink);

        Button button = findViewById(R.id.submit);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mFirstname = String.valueOf(Firstname.getText());
                mSurname = String.valueOf(Surname.getText());
                mEmail = String.valueOf(Email.getText());
                mGit = String.valueOf(Git.getText());

                if(mFirstname.isEmpty()){
                    Firstname.setError("Firstname required");
                    Firstname.requestFocus();
                    return;
                }

                if(mSurname.isEmpty()){
                    Surname.setError("Surname required");
                    Surname.requestFocus();
                    return;
                }
                if(mEmail.isEmpty()){
                    Email.setError("Email required");
                    Email.requestFocus();
                    return;
                }
                if(mGit.isEmpty()){
                    Git.setError("GitHub Link required");
                    Git.requestFocus();
                    return;
                }

                ConfirmDialog mdialog = new ConfirmDialog(mEmail,mSurname,mFirstname,mGit);
                mdialog.show(getSupportFragmentManager(), "confirm");
            }
        };
        button.setOnClickListener(listener);
    }

}

