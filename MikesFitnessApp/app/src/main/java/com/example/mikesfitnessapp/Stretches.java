package com.example.mikesfitnessapp;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class Stretches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretches);

        //Not using appbar or action bar.
        // Using Material Design Toolbar!!
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        //Changing status bar colour
        //https://stackoverflow.com/questions/57571793/unable-to-change-the-color-of-the-status-bar-in-the-tablayout
        getWindow().setStatusBarColor(ContextCompat.getColor(Stretches.this, R.color.lightBlue));

        // load in the workouts saved. use init method. that can be use in onCreate() and onResume()





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