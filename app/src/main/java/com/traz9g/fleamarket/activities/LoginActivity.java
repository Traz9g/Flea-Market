package com.traz9g.fleamarket.activities;

import android.app.Activity;
import android.content.Intent;
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
import com.traz9g.fleamarket.defines.AppDefines;
import com.traz9g.fleamarket.defines.LocalStorageDefines;
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

        //todo: create request with timeout
        Backendless.UserService.login(username, password, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {
                Log.i(TAG, backendlessUser.toString());

                LocalStorage.setBoolean(LocalStorageDefines.SIGN_UP, true);
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Log.e(TAG, backendlessFault.toString());
            }
        }, true);
    }

    public void signUp(View view) {
        startActivityForResult(new Intent(this, SignUpActivity.class),
                AppDefines.SIGN_UP_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AppDefines.SIGN_UP_CODE && resultCode == Activity.RESULT_OK) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
