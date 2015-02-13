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

public class RegistrationActivity extends ActionBarActivity {
    private final String TAG = RegistrationActivity.class.getSimpleName();

    private EditText mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mEmail = (EditText) findViewById(R.id.registration_editEmail);
        mPassword = (EditText) findViewById(R.id.registration_editPassword);
    }

    public void register(View view) {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if (email.equals("") || password.equals("")) {
            Toast.makeText(this, "Fields can not be empty", Toast.LENGTH_SHORT).show();

            return;
        }

        BackendlessUser backendlessUser = new BackendlessUser();
        backendlessUser.setEmail(email);
        backendlessUser.setPassword(password);

        Backendless.UserService.register(backendlessUser, new AsyncCallback<BackendlessUser>() {
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
