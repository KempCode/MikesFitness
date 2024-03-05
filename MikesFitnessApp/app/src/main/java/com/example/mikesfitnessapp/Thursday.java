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

public class Thursday extends AppCompatActivity {
    private static final String SHARED_PREF = "shared_pref_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);

        //Not using appbar or action bar.
        // Using Material Design Toolbar!!
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        //Changing status bar colour
        //https://stackoverflow.com/questions/57571793/unable-to-change-the-color-of-the-status-bar-in-the-tablayout
        getWindow().setStatusBarColor(ContextCompat.getColor(Thursday.this, R.color.lightBlue));

        // load in the workouts saved. use init method. that can be use in onCreate() and onResume()
        //Load in and save edit texts / inputted workout kg and reps.
        init();

    }

    private void init(){
        //Load in and save edit texts / inputted workout kg and reps.

        //Get all of the Edit Texts
        EditText thursdayWO1Edit = findViewById(R.id.thursdayWO1Edit);
        EditText thursdayWO2Edit = findViewById(R.id.thursdayWO2Edit);
        EditText thursdayWO3Edit = findViewById(R.id.thursdayWO3Edit);
        EditText thursdayWO4Edit = findViewById(R.id.thursdayWO4Edit);
        EditText thursdayWO5Edit = findViewById(R.id.thursdayWO5Edit);
        EditText thursdayWO6Edit = findViewById(R.id.thursdayWO6Edit);
        EditText thursdayWO7Edit = findViewById(R.id.thursdayWO7Edit);
        EditText thursdayWO8Edit = findViewById(R.id.thursdayWO8Edit);
        EditText thursdayWO9Edit = findViewById(R.id.thursdayWO9Edit);


        // An array of the EditTexts
        EditText[] editTextArray = {thursdayWO1Edit, thursdayWO2Edit, thursdayWO3Edit, thursdayWO4Edit,
        thursdayWO5Edit, thursdayWO6Edit, thursdayWO7Edit, thursdayWO8Edit, thursdayWO9Edit};

        //Setup Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // load in the workouts saved.
        //mondayWO1Edit.setText(sharedPreferences.getString("mondayWO1Edit", ""));
        for (int i = 0; i < editTextArray.length; i++){
            String workoutKey = "thurs" +  (i + 1);
            editTextArray[i].setText(sharedPreferences.getString(workoutKey, ""));
        }


        // Save workouts button listener
        Button thursdaySave = findViewById(R.id.thursdaySave);
        thursdaySave.setOnClickListener(view -> {
            for (int i = 0; i < editTextArray.length; i++){
                String workoutKey = "thurs" +  (i + 1);
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