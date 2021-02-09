package com.example.parsestagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TcFzVT3NXw51bdgr8ROEttP0Mzs3mDui2NFq2Ukc")
                .clientKey("qcMJIHXw8J7V6V591iq0ILdnTTj7hXQyQfcZLjKb")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
