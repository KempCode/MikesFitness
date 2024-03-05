package com.example.mikesfitnessapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class Monday extends AppCompatActivity {
    private static final String SHARED_PREF = "shared_pref_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        //Not using appbar or action bar.
        // Using Material Design Toolbar!!
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        //Changing status bar colour
        //https://stackoverflow.com/questions/57571793/unable-to-change-the-color-of-the-status-bar-in-the-tablayout
        getWindow().setStatusBarColor(ContextCompat.getColor(Monday.this, R.color.lightBlue));

        //Load in and save edit texts / inputted workout kg and reps.
        init();

    }

    private void init(){
        //Load in and save edit texts / inputted workout kg and reps.

        //Get all of the Edit Texts
        EditText mondayWO1Edit = findViewById(R.id.mondayWO1Edit);
        EditText mondayWO2Edit = findViewById(R.id.mondayWO2Edit);
        EditText mondayWO3Edit = findViewById(R.id.mondayWO3Edit);
        EditText mondayWO4Edit = findViewById(R.id.mondayWO4Edit);
        EditText mondayWO5Edit = findViewById(R.id.mondayWO5Edit);
        EditText mondayWO6Edit = findViewById(R.id.mondayWO6Edit);
        EditText mondayWO7Edit = findViewById(R.id.mondayWO7Edit);
        EditText mondayWO8Edit = findViewById(R.id.mondayWO8Edit);
        EditText mondayWO9Edit = findViewById(R.id.mondayWO9Edit);
        EditText mondayWO10Edit = findViewById(R.id.mondayWO10Edit);

        // An array of the EditTexts
        EditText[] editTextArray = {mondayWO1Edit, mondayWO2Edit, mondayWO3Edit, mondayWO4Edit,
                mondayWO5Edit, mondayWO6Edit, mondayWO7Edit, mondayWO8Edit, mondayWO9Edit, mondayWO10Edit};

        //Setup Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // load in the workouts saved.
        //mondayWO1Edit.setText(sharedPreferences.getString("mondayWO1Edit", ""));
        for (int i = 0; i < editTextArray.length; i++){
            String workoutKey = "mon" +  (i + 1);
            editTextArray[i].setText(sharedPreferences.getString(workoutKey, ""));
        }


        // Save workouts button listener
        Button mondaySave = findViewById(R.id.mondaySave);
        mondaySave.setOnClickListener(view -> {
            for (int i = 0; i < editTextArray.length; i++){
                String workoutKey = "mon" +  (i + 1);
                editor.putString(workoutKey,editTextArray[i].getText().toString());
            }
            editor.apply();
            Toast.makeText(this, "Saved Workout", Toast.LENGTH_SHORT).show();
        });
    }


    // BACK BUTTON
    //https://stackoverflow.com/questions/42824094/how-to-go-back-to-previous-activites
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // presss up/back button
        if (item.getItemId() == android.R.id.home) {
            //exit current activity and enter previous one i.e. homepage.
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

