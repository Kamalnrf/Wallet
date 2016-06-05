package com.app.kamalnrf.wallet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kamalnrf on 5/6/16.
 */
public class Password extends AppCompatActivity
{
    private EditText mPassword;
    private Button mSubmit;
    private Passwor mPasswordVerifier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if(isFirstRun)
        {
            setContentView(R.layout.create_password);
            mPassword = (EditText) findViewById(R.id.create_password);
            mPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mPasswordVerifier.setPassword(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            mSubmit = (Button) findViewById(R.id.create_password_button);
            /*mSubmit.setOnClickListener(new View.OnClickListener() {
            });*/
        }

    }

    public class Passwor
    {
        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
