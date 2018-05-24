package com.example.android.newsapp.neworking;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.models.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Util {

    private static String queryString = "http://content.guardianapis.com/search" +
            "?from-date=2018-05-01" +
            "&order-by=newest" +
            "&use-date=published" +
            "&show-fields=headline%2Cthumbnail%2Cbyline&q=science%20AND%20technology" +
            "&show-tags=contributor" +
            "&page-size=10" +
            "&page=1" +
            "&api-key=bd09ce5f-11d5-4568-9306-aa47f10335b7";

    public static final String SIMPLE_NAME = Util.class.getSimpleName();

    public static ArrayList<News> getNewsList(){

        ArrayList<News> news = new ArrayList<News>();
        String jsonString = resultJsonString(queryURL(queryString)).toString();

        try {
            JSONObject root = new JSONObject(jsonString);
            JSONObject rootResponse = root.getJSONObject("response");
            JSONArray resultArray = rootResponse.getJSONArray("results");

            for (int i = 0; i < resultArray.length(); i++){
                JSONObject resultArrayObject = resultArray.getJSONObject(i);

                String webPubDate = resultArrayObject.getString("webPublicationDate");
                String headline = resultArrayObject.getJSONObject("fields").getString("headline");
                String section = resultArrayObject.getString("sectionName");
                String author = resultArrayObject.getJSONObject("fields").getString("byline");
                String webUrl = resultArrayObject.getString("webUrl");

                Log.v(SIMPLE_NAME, "Array Length: " + resultArray.length());

                news.add(new News(webPubDate, headline, section, author, webUrl));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return news;
    }

    private static URL queryURL(String queryString){
        URL queryURL = null;
        try {
            queryURL = new URL(queryString);
        } catch (MalformedURLException e) {
            Log.v(SIMPLE_NAME, "The Query String is not a waled urel" + e.getMessage());
        }
        return queryURL;
    }

    private static StringBuilder resultJsonString(URL queryURL){
        HttpURLConnection httpReques = null;
        int dateStream;
        StringBuilder resultJsonString = new StringBuilder();

        try {
            httpReques = (HttpURLConnection) queryURL.openConnection();
            InputStream stream = httpReques.getInputStream();
            dateStream = stream.read();
            while (dateStream != -1){
                resultJsonString.append((char)dateStream);
                dateStream = stream.read();
            }
        } catch (IOException e) {
            Log.v(SIMPLE_NAME, "Can not connect to URL: " + e.getMessage());
        }
        return resultJsonString;
    }
}
