package com.example.kamalnrf.wallet.Model.BankAccountModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kamalnrf.wallet.DataBase.WalletBaseHelper;
import com.example.kamalnrf.wallet.DataBase.WalletCursorWrapper;
import com.example.kamalnrf.wallet.DataBase.WalletDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 18/5/16.
 */
public class WalletLicence
{
    private static WalletLicence sWalletLicence;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public WalletLicence(Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new WalletBaseHelper(mContext)
                .getWritableDatabase();
    }

    public static WalletLicence get (Context context)
    {
        if (sWalletLicence == null)
        {
            sWalletLicence = new WalletLicence(context);
        }
        return sWalletLicence;
    }

    public static ContentValues getContentValues (Licence licence)
    {
        ContentValues values = new ContentValues();

        values.put(WalletDbSchema.Licence.Cols.UUID, licence.getUUID().toString());
        values.put(WalletDbSchema.Licence.Cols.ADDRESS, licence.getAddress());
        values.put(WalletDbSchema.Licence.Cols.COUNTRY, licence.getCountry());
        values.put(WalletDbSchema.Licence.Cols.DATE, licence.getDateOfBirth());
        values.put(WalletDbSchema.Licence.Cols.EXDATE, licence.getExpiryDate());
        values.put(WalletDbSchema.Licence.Cols.FULLNAME, licence.getFullName());
        values.put(WalletDbSchema.Licence.Cols.HEIGHT, licence.getHeight());
        values.put(WalletDbSchema.Licence.Cols.LICENCECLASS, licence.getLicenceClass());
        values.put(WalletDbSchema.Licence.Cols.NUMBER, licence.getNumber());
        values.put(WalletDbSchema.Licence.Cols.STATE, licence.getState());
        values.put(WalletDbSchema.Licence.Cols.SEX, licence.getSex());

        return values;
    }

    private WalletCursorWrapper queryLicence (String whereClause, String[] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                WalletDbSchema.Licence.NAME,
                null, // Colums - null select all colums
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null // order

        );

        return new WalletCursorWrapper(cursor);
    }

    public List<Licence> getLicence ()
    {
        List<Licence> licences = new ArrayList<>();

        WalletCursorWrapper cursor = queryLicence(null, null);

        try
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                licences.add(cursor.getLicence());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return licences;
    }

    public Licence getWalletLicence (UUID uuid)
    {
        WalletCursorWrapper cursor = queryLicence(
                WalletDbSchema.Licence.Cols.UUID + " =? "
                , new String[]
                        {
                                uuid.toString()
                        }
        );

        try
        {
            if (cursor.getCount() == 0)
            {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getLicence();
        }
        finally
        {
            cursor.close();
        }
    }

    public void addLicence (Licence l)
    {
        ContentValues values = getContentValues(l);

        mDatabase.insert(WalletDbSchema.Licence.NAME, null, values);
    }

    public void deleteCrime(UUID uuid)
    {
        String uuidString = uuid.toString();

        mDatabase.delete(WalletDbSchema.Licence.NAME, WalletDbSchema.Licence.Cols.UUID + " = ?", new String[]{uuidString});
    }
}
