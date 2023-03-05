package com.example.shared_preference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutId);

        if (loadColor()!=getResources().getColor(com.google.android.material.R.color.design_default_color_on_primary)){

            linearLayout.setBackgroundColor(loadColor());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.redMenuId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            storeColor(getResources().getColor(R.color.red));
        }
           if (item.getItemId()==R.id.greenMenuId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            storeColor(getResources().getColor(R.color.green));
        }
           if (item.getItemId()==R.id.yellowMenuId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
            storeColor(getResources().getColor(R.color.yellow));
        }
           if (item.getItemId()==R.id.blueMenuId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            storeColor(getResources().getColor(R.color.blue));
        }


        return super.onOptionsItemSelected(item);
    }

    private void storeColor (int color){

        SharedPreferences sharedPreferences = getSharedPreferences("bgColor",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor", color);
        editor.commit();

    }

    private int loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("bgColor",Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("myColor", getResources().getColor(com.google.android.material.R.color.design_default_color_on_primary));
        return selectedColor;
            }
}