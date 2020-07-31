package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
//
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    TextView scannedPersons;
    TextView elevatedPersons;
    TextView nonElevatedPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        configureNextButton();
        scannedPersons = findViewById(R.id.textView_screenings);
        elevatedPersons = findViewById(R.id.textView_Elevated);
        nonElevatedPersons = findViewById(R.id.textView_nonElevated);


    }

    public void setMap() {
        if(infoActivity.city.equals("Gambrills")){
            // Add a marker in Sydney and move the camera
            LatLng location = new LatLng(Float.parseFloat(Requests.coordinates[1]), Float.parseFloat(Requests.coordinates[0]));
            mMap.addMarker(new MarkerOptions().position(location).title(infoActivity.city));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));

        } else {
            LatLng center = new LatLng( 36.961816, -98.067161);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(center));
        }
    }

    private void configureNextButton(){
        Button mapButton = findViewById(R.id.returnButton);
        mapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        if(infoActivity.city.equals("Gambrills")){
            // Add a marker in Sydney and move the camera
            LatLng location = new LatLng(Float.parseFloat(Requests.coordinates[1]), Float.parseFloat(Requests.coordinates[0]));
            mMap.addMarker(new MarkerOptions().position(location).title(infoActivity.city).icon(BitmapDescriptorFactory.fromResource(R.drawable.target)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
            scannedPersons.setText("People Scanned: " + (Integer.parseInt(Requests.readings[0])+Integer.parseInt(Requests.readings[1])));
            elevatedPersons.setText("Elevated Temperatures: " + Requests.readings[0]);
            nonElevatedPersons.setText("Nonelevated Temperatures: " + Requests.readings[1]);

        } else {
            LatLng center = new LatLng( 36.961816, -98.067161);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(center));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, -100));

        }
    }
}