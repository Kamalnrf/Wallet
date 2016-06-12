package com.app.kamalnrf.wallet;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.app.kamalnrf.wallet.DataBase.WalletDbSchema;

import java.util.UUID;

/**
 * Created by kamalnrf on 12/6/16.
 */
public class Passwor
{
    private static String mPassword;
    private String mUuid;

    public Passwor ()
    {
        mUuid = "1";
    }


    public String getmUuid() {
        return mUuid;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password)
    {
        mPassword = password;

    }

}
