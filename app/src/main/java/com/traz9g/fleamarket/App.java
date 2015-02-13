package com.traz9g.fleamarket;

import android.app.Application;
import android.content.Context;

import com.backendless.Backendless;
import com.traz9g.fleamarket.defines.BackendlessDefines;

public class App extends Application {
    public static Context appContext;
    public static String appName;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();
        appName = getPackageName();

        initBaas();
    }

    private void initBaas() {
        Backendless.initApp(appContext, BackendlessDefines.APP_ID, BackendlessDefines.SECRET_KEY,
                BackendlessDefines.APP_VERSION);
    }
}