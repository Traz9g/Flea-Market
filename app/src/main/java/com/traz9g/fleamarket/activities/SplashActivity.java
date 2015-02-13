package com.traz9g.fleamarket.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.traz9g.fleamarket.defines.LocalStorageDefines;
import com.traz9g.fleamarket.util.LocalStorage;

public class SplashActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isSignedUp = LocalStorage.getBoolean(LocalStorageDefines.SIGN_UP, false);
        if (isSignedUp) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }

        finish();
    }
}
