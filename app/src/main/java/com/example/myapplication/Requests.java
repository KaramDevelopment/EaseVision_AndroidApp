package com.example.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Requests {
    public static String[] coordinates;
    public static String[] readings;
    public static  ArrayList<String> cities = new ArrayList<String>();
    public static  ArrayList<String> states = new ArrayList<String>();
    public static  ArrayList<String> countries = new ArrayList<String>();

    public static void requestApi(String url, final String requestType) {
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Basic YS1tbzl2Y3ItNWhxY2lsY3dzNjpiZkg/Zys4SEtaR3N4ailTdEY=")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        JSONObject obj = new JSONObject(response.body().string());
                        if (requestType.equals("locationData")) {
                            String longitude = "";
                            String latitude = "";
                            latitude = obj.getString("latitude");
                            longitude = obj.getString("longitude");
                            coordinates = new String[]{latitude, longitude};
                        }
                        else if (requestType.equals("tempData")) {
                            String elevatedPerson = "";
                            String nonElevatedPersons = "";
                            elevatedPerson = obj.getJSONObject("state").getString("elevatedPersons");
                            nonElevatedPersons = obj.getJSONObject("state").getString("nonElevatedPersons");
                            readings = new String[]{elevatedPerson, nonElevatedPersons};
                        }
                        else if ((requestType.equals("geoData"))) {
                            String temp = "";
                            temp = obj.getJSONObject("state").getString("City");
                            cities.add(temp);
                            temp = obj.getJSONObject("state").getString("Country");
                            countries.add(temp);
                            temp = obj.getJSONObject("state").getString("State");
                            states.add(temp);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
 /*
    public String[] jsonToCoordinates (JSONObject obj) {
        String longitude = "";
        String latitude = "";
        String[] temp = {latitude,longitude};
        try {
            latitude = obj.getString("latitude");
            longitude = obj.getString("longitude");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
    public ArrayList<String> jsonToCities (JSONObject obj) {
        String city = "";
        ArrayList<String> temp = new ArrayList<String>();
        try {
            city = obj.getJSONObject("state").getString("City:");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        temp.add(city);
        return temp;
    }

    public String[] jsonToReadings (JSONObject obj) {
        String elevatedPerson = "";
        String nonElevatedPersons = "";
        try {
            elevatedPerson = obj.getJSONObject("state").getString("elevatedPersons");
            nonElevatedPersons = obj.getJSONObject("state").getString("nonElevatedPersons");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] temp = {elevatedPerson,nonElevatedPersons};
        return temp;
    }*/
