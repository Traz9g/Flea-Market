package com.traz9g.fleamarket.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.traz9g.fleamarket.R;
import com.traz9g.fleamarket.util.LocalStorage;

public class LoginActivity extends ActionBarActivity {
    private final String TAG = LoginActivity.class.getSimpleName();

    private EditText mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText) findViewById(R.id.login_editEmail);
        mPassword = (EditText) findViewById(R.id.login_editPassword);
    }

    public void login(View view) {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if (username.equals("") || password.equals("")) {
            Toast.makeText(this, "Fields can not be empty", Toast.LENGTH_SHORT).show();

            return;
        }

        Backendless.UserService.login(username, password, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {
                Log.i(TAG, backendlessUser.toString());

                LocalStorage.setBoolean(LocalStorage.SIGN_UP, true);
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });
    }
}
