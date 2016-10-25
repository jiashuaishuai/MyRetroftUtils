package com.example.administrator.myretroftutils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class App extends Application {
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static App getApplication() {
        return mInstance;
    }
}
