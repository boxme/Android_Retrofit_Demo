package com.desmond.android_retrofit_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.desmond.android_retrofit_demo.rest.VehicleAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onClick(final View view) {
        VehicleAPI.getInstance().getUsedVeicle(0, 10, "bike");
    }
}
