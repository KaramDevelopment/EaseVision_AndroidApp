package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class infoActivity extends AppCompatActivity {
    private String dataURL = "https://mo9vcr.internetofthings.ibmcloud.com/api/v0002/device/types/Arduino/devices/Arduino-1/state/5f2397c3ac00880008afb468";
    private String coordinatesURL = "https://mo9vcr.internetofthings.ibmcloud.com/api/v0002/device/types/Arduino/devices/Arduino-1/location";
    public static String city = "";
    public static String state = "";
    public static String country = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getData();
        configureNextButton();
        final Spinner city_spinner = findViewById(R.id.city_spinner);
        final Spinner state_spinner = findViewById(R.id.state_spinner);
        final Spinner country_spinner = findViewById(R.id.country_spinner);

        ArrayAdapter<String> arrayAdapterCity = new ArrayAdapter<String>(this, R.layout.spinner_item, Requests.cities);
        //arrayAdapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city_spinner.setAdapter(arrayAdapterCity);

        ArrayAdapter<String> arrayAdapterCountry = new ArrayAdapter<String>(this, R.layout.spinner_item, Requests.countries);
        //arrayAdapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country_spinner.setAdapter(arrayAdapterCountry);

        ArrayAdapter<String> arrayAdapterState = new ArrayAdapter<String>(this, R.layout.spinner_item, Requests.states);
        //arrayAdapterState.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state_spinner.setAdapter(arrayAdapterState);

        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                city = city_spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        state_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                state = state_spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                country = country_spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

    }

    private void configureNextButton(){
        Button mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(infoActivity.this, MapsActivity.class));
            }
        });
    }
    public void getData() {
        Requests.requestApi(coordinatesURL, "locationData");
        Requests.requestApi(dataURL, "tempData");
        Requests.requestApi(dataURL, "geoData");
        Requests.cities.add("City");
        Requests.states.add("State");
        Requests.countries.add("Country");
    }
}