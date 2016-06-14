package com.app.kamalnrf.wallet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by kamalnrf on 5/6/16.
 */
public class Password extends AppCompatActivity
{
    private EditText mPassword;
    private TextView mTextView;
    private Button mSubmit;
    private Passwor mPasswordVerifier;
    private static String mUuid = "1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final int[] a = {0};

        mPasswordVerifier = PasswordC.get(this).getPasswords(mUuid);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false))
        {
            final String password = mPasswordVerifier.getPassword();
            final String[] enPass = new String[1];

           setContentView(R.layout.password_enter);
            mTextView = (TextView) findViewById(R.id.wrong_password);
            mPassword = (EditText) findViewById(R.id.password_enter);
            mPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                    enPass[0] = s.toString();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

                mSubmit = (Button) findViewById(R.id.submit);
                mSubmit.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if (enPass[0] != null) {
                            if (enPass[0].equals(password)) {
                                Intent intent = new Intent(Password.this, WalletActivity.class);
                                startActivity(intent);
                                finish();
                            } else
                                mTextView.setText("Enter correct password");
                        }
                        else
                        {
                            if (a[0] == 0) {
                                mTextView.setText("Enter the password");
                                a[0]++;
                            }
                            else if (a[0] == 1)
                            {
                                mTextView.setText("Are you serious...?");
                                a[0]++;
                            }
                            else if (a[0] > 5)
                            {
                                mTextView.setText("Are you drunk...?");
                                a[0]++;
                            }
                        }
                    }

                });



        } else {
            setContentView(R.layout.create_password);

            mPassword = (EditText) findViewById(R.id.create_password);
            mPassword.setText(mPasswordVerifier.getPassword());
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
                mSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Password.this, WalletActivity.class);
                        startActivity(intent);
                        finish();
                    }

                });

            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.commit();

        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        PasswordC.get(this)
                .upDate(mPasswordVerifier);
    }
}
