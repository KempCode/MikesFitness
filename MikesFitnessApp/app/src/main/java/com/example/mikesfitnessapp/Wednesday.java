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

public class Wednesday extends AppCompatActivity {
    private static final String SHARED_PREF = "shared_pref_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);

        //Not using appbar or action bar.
        // Using Material Design Toolbar!!
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        //Changing status bar colour
        //https://stackoverflow.com/questions/57571793/unable-to-change-the-color-of-the-status-bar-in-the-tablayout
        getWindow().setStatusBarColor(ContextCompat.getColor(Wednesday.this, R.color.lightBlue));

        // load in the workouts saved. use init method. that can be use in onCreate() and onResume()
        //Load in and save edit texts / inputted workout kg and reps.
        init();



    }
    private void init(){
        //Load in and save edit texts / inputted workout kg and reps.

        //Get all of the Edit Texts
        EditText wednesdayWO1Edit = findViewById(R.id.wednesdayWO1Edit);
        EditText wednesdayWO2Edit = findViewById(R.id.wednesdayWO2Edit);
        EditText wednesdayWO3Edit = findViewById(R.id.wednesdayWO3Edit);
        EditText wednesdayWO4Edit = findViewById(R.id.wednesdayWO4Edit);
        EditText wednesdayWO5Edit = findViewById(R.id.wednesdayWO5Edit);
        EditText wednesdayWO6Edit = findViewById(R.id.wednesdayWO6Edit);
        EditText wednesdayWO7Edit = findViewById(R.id.wednesdayWO7Edit);
        EditText wednesdayWO8Edit = findViewById(R.id.wednesdayWO8Edit);

        // An array of the EditTexts
        EditText[] editTextArray = {wednesdayWO1Edit, wednesdayWO2Edit, wednesdayWO3Edit, wednesdayWO4Edit,
        wednesdayWO5Edit, wednesdayWO6Edit, wednesdayWO7Edit, wednesdayWO8Edit};

        //Setup Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // load in the workouts saved.
        //mondayWO1Edit.setText(sharedPreferences.getString("mondayWO1Edit", ""));
        for (int i = 0; i < editTextArray.length; i++){
            String workoutKey = "wed" +  (i + 1);
            editTextArray[i].setText(sharedPreferences.getString(workoutKey, ""));
        }


        // Save workouts button listener
        Button wednesdaySave = findViewById(R.id.wednesdaySave);
        wednesdaySave.setOnClickListener(view -> {
            for (int i = 0; i < editTextArray.length; i++){
                String workoutKey = "wed" +  (i + 1);
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