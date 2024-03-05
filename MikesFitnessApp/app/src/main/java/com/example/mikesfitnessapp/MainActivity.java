package com.example.mikesfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private void homeButtonListener(Class<?> dayClass, Button todaysButton){
        // Creates onclick listener for whatever day of the week is passed and is also passed
        //  class Monday.class that is used with the intent, to navigate to the Monday view!
        todaysButton.setOnClickListener(view -> {
            Intent mondayIntent = new Intent(this, dayClass);
            startActivity(mondayIntent);
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup all the buttons in Main activity / homepage.
        Button mondayButton = findViewById(R.id.mondayButton);
        Button tuesdayButton = findViewById(R.id.tuesdayButton);
        Button wednesdayButton = findViewById(R.id.wednesdayButton);
        Button thursdayButton = findViewById(R.id.thursdayButton);
        Button fridayButton = findViewById(R.id.fridayButton);
        Button saturdayButton = findViewById(R.id.saturdayButton);
        Button stretchesButton = findViewById(R.id.stretchesButton);

        // Button listeners
        homeButtonListener(Monday.class, mondayButton);
        homeButtonListener(Tuesday.class, tuesdayButton);
        homeButtonListener(Wednesday.class, wednesdayButton);
        homeButtonListener(Thursday.class, thursdayButton);
        homeButtonListener(Friday.class, fridayButton);
        homeButtonListener(Saturday.class, saturdayButton);
        homeButtonListener(Stretches.class, stretchesButton);

        //Changing status bar colour
        //https://stackoverflow.com/questions/57571793/unable-to-change-the-color-of-the-status-bar-in-the-tablayout
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.lightBlue));

    }
}