package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView detailsTextView;
    private EditText usernameEditText, passwordEditText;
    private Button saveButton, loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailsTextView = (TextView) findViewById(R.id.detailsTextViewId);
        usernameEditText = (EditText) findViewById(R.id.usernameEdittextId);
        passwordEditText = (EditText) findViewById(R.id.passwordEdittextId);
        saveButton = (Button) findViewById(R.id.saveButtonId);
        loadButton = (Button) findViewById(R.id.loadButtonId);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.saveButtonId){

            //get data from user
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.equals("") && password.equals("")) {

                Toast.makeText(getApplicationContext(),"Please enter some data", Toast.LENGTH_SHORT).show();
            }
            else {

                //writing data
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey", username);
                editor.putString("passwordKey",password);
                editor.commit();

                usernameEditText.setText("");
                passwordEditText.setText("");

                Toast.makeText(getApplicationContext(),"Data is stored successfully", Toast.LENGTH_SHORT).show();

            }

        }

     if (view.getId()==R.id.loadButtonId){

         //to read data
         SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);

         if (sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey"));{

             String username = sharedPreferences.getString("usernameKey","Data not found");
             String password = sharedPreferences.getString("passwordKey","Data not found");

             detailsTextView.setText(username+"\n"+password);
         }
        }

    }
}