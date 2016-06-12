package com.app.kamalnrf.wallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.kamalnrf.wallet.DataBase.WalletBaseHelper;
import com.app.kamalnrf.wallet.DataBase.WalletCursorWrapper;
import com.app.kamalnrf.wallet.DataBase.WalletDbSchema;
import com.app.kamalnrf.wallet.Model.BankAccountModel.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 12/6/16.
 */
public class PasswordC
{
    private static PasswordC sPasswor;

    private Context mContext;
    private static SQLiteDatabase mDatabase;

    public PasswordC(Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new WalletBaseHelper(mContext)
                .getWritableDatabase();
    }

    public static PasswordC get (Context context)
    {
        if (sPasswor == null)
        {
            sPasswor = new PasswordC(context);
        }
        return sPasswor;
    }


    public static ContentValues getContentValues (Passwor passwor)
    {
        ContentValues values = new ContentValues();

        values.put(WalletDbSchema.Password.Cols.PASSWORD, passwor.getPassword());
        values.put(WalletDbSchema.Password.Cols.UUID, passwor.getmUuid());

        return values;
    }

    public List<Passwor> getPasswords ()
    {
        List<Passwor> passwors = new ArrayList<>();

        WalletCursorWrapper cursorWrapper = queryCrime(null, null);

        try
        {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast())
            {
                passwors.add(cursorWrapper.getPassword());
               cursorWrapper.moveToNext();
            }
        }
        finally {
            cursorWrapper.close();
        }

        return passwors;
    }

    public Passwor getPasswords (String id)
    {
        WalletCursorWrapper cursor = queryCrime(
                WalletDbSchema.Password.Cols.UUID + " =? "
                , new String[]
                        {
                                id
                        }
        );

        try
        {
            if (cursor.getCount() == 0)
            {
                Passwor passwor = new Passwor();
                addCrime(passwor);

                return getPasswords(passwor.getmUuid());
            }

            cursor.moveToFirst();
            return cursor.getPassword();
        }
        finally {
            cursor.close();
        }
    }


    public void upDate (Passwor passwor)
    {
        String uuid = passwor.getmUuid().toString();
        ContentValues values = getContentValues(passwor);

        mDatabase.update(WalletDbSchema.Password.NAME, values,
                WalletDbSchema.Password.Cols.UUID
                        + " =? "
        , new String[]{uuid});
    }

    //Add Crime
    public void addCrime (Passwor c)
    {
        ContentValues values = getContentValues(c);

        mDatabase.insert(WalletDbSchema.Password.NAME, null, values);
    }

    private WalletCursorWrapper queryCrime (String whereClause, String[] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                WalletDbSchema.Password.NAME,
                null, // Colums - null select all colums
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null // order

        );

        return new WalletCursorWrapper(cursor);
    }
}
