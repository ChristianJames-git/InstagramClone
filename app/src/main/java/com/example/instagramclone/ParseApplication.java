package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("6KHL2qJs7GzRf9dF4ILjpjUOqcJP8Vso3yJ1qQEJ")
                .clientKey("lQM2gFR7CIJyXPKxz2SIDYbAT9BOS7lt6gQFwjhQ")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}
