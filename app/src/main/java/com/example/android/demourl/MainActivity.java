package com.example.android.demourl;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String AUTHORITY = "developer.android.com";
    private static final String PATH_GUIDE = "guide/components/intents-common.html";
    private static final String PARAM_SOURCE = "utm_source";
    private static final String PARAM_MEDIUM = "utm_medium";
    private static final String PARAM_CAMPAIGN = "utm_campaign";
    private static final String FRAGMENT = "Phone";
    private String sourceQuery = "udacity";
    private String mediumQuery = "course";
    private String campaignQuery = "android_basics";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView urlTextView = findViewById(R.id.tv_url);
        urlTextView.setText(buildUrl().toString());
    }

    private URL buildUrl() {
        Uri builtUri = Uri.parse("https://" + AUTHORITY).buildUpon()
                .appendEncodedPath(PATH_GUIDE)
                .appendQueryParameter(PARAM_SOURCE, sourceQuery)
                .appendQueryParameter(PARAM_MEDIUM, mediumQuery)
                .appendQueryParameter(PARAM_CAMPAIGN, campaignQuery)
                .fragment(FRAGMENT)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
