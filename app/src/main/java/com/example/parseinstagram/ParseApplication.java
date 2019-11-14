package com.example.parseinstagram;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    public static final String TAG = "ParseApplication";
    @Override
    public void onCreate() {
        super.onCreate();

        // initialize parse object
        ParseObject.registerSubclass(Post.class);

        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("foong-instagram-codepath") // should correspond to APP_ID env variable
                .clientKey("CodepathInstagramMoveFast")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://foong-instagram-codepath.herokuapp.com/parse").build());

        Log.i(TAG, "success");
    }

}
