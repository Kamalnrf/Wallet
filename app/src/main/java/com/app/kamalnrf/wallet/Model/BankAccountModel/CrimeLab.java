package com.app.kamalnrf.wallet.Model.BankAccountModel;

//Layer Level :- Model

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.app.kamalnrf.wallet.DataBase.WalletBaseHelper;
import com.app.kamalnrf.wallet.DataBase.WalletCursorWrapper;
import com.app.kamalnrf.wallet.DataBase.WalletDbSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 8/4/16.
 */
public class CrimeLab
{
    private static CrimeLab sCrimeLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;


    public static CrimeLab get (Context context)
    {
        if (sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public static ContentValues getContentValues (Crime crime)
    {
        ContentValues values = new ContentValues();

        values.put(WalletDbSchema.CrimeTable.Cols.UUID,crime.getId().toString());
        values.put(WalletDbSchema.CrimeTable.Cols.TITLE,crime.getTitle());
        values.put(WalletDbSchema.CrimeTable.Cols.DATE,crime.getDate().toString());
        values.put(WalletDbSchema.CrimeTable.Cols.ACCOUNTNUMBER, crime.getAccountNumber());
        values.put(WalletDbSchema.CrimeTable.Cols.ACCOUNTTYPE, crime.getAccountType());
        values.put(WalletDbSchema.CrimeTable.Cols.ADDRESS, crime.getAddress());
        values.put(WalletDbSchema.CrimeTable.Cols.BANKNAME, crime.getBankName());
        values.put(WalletDbSchema.CrimeTable.Cols.IBANNUMBER, crime.getIBANNumber());
        values.put(WalletDbSchema.CrimeTable.Cols.NAMEONACCOUNT, crime.getNameOnContact());
        values.put(WalletDbSchema.CrimeTable.Cols.PHONE, crime.getPhone());
        values.put(WalletDbSchema.CrimeTable.Cols.PIN, crime.getPin());
        values.put(WalletDbSchema.CrimeTable.Cols.ROUTINGNUMBER, crime.getRoutingNumber());
        values.put(WalletDbSchema.CrimeTable.Cols.SWIFTNUMBER, crime.getSWIFTCode());

        return values;
    }

    public CrimeLab(Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new WalletBaseHelper(mContext)
                .getWritableDatabase();
    }

    public List<Crime> getCrimes()
    {
        List<Crime> crimes = new ArrayList<>();

        WalletCursorWrapper cursor = queryCrime(null, null);

        try
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }

        }
        finally
        {
            cursor.close();
        }

        return crimes;
    }

    //returns data bassed on id
    public Crime getCrimeLab(UUID id)
    {
        WalletCursorWrapper cursor = queryCrime(
                WalletDbSchema.CrimeTable.Cols.UUID + " =? "
                , new String[]
                        {
                                id.toString()
                        }
        );

        try
        {
            if (cursor.getCount() == 0)
            {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCrime();
        }
        finally
        {
            cursor.close();
        }
    }

    //Add Crime
    public void addCrime (Crime c)
    {
        ContentValues values = getContentValues(c);

        mDatabase.insert(WalletDbSchema.CrimeTable.NAME, null, values);
    }

    //Delete Crime
    public void deleteCrime(UUID crimeId)
    {
        String uuidString = crimeId.toString();

        mDatabase.delete(WalletDbSchema.CrimeTable.NAME, WalletDbSchema.CrimeTable.Cols.UUID + " = ?", new String[]{uuidString});
    }

    public void upDateCrime(Crime crime)
    {
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);

        mDatabase.update(WalletDbSchema.CrimeTable.NAME, values,
                WalletDbSchema.CrimeTable.Cols.UUID + " =?"
                , new String[]{uuidString});
    }

    private WalletCursorWrapper queryCrime (String whereClause, String[] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                WalletDbSchema.CrimeTable.NAME,
                null, // Colums - null select all colums
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null // order

        );

        return new WalletCursorWrapper(cursor);
    }

    public File getPhotoFile (Crime crime)
    {
        File externalFileDir = mContext
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFileDir == null)
        {
            return null;
        }
        return new File(externalFileDir, crime.getPhotoFileName());
    }
}
