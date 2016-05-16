package com.example.kamalnrf.wallet.Model.BankAccountModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.kamalnrf.wallet.DataBase.WalletBaseHelper;
import com.example.kamalnrf.wallet.DataBase.WalletCursorWrapper;
import com.example.kamalnrf.wallet.DataBase.WalletDbSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 7/5/16.
 */
public class WalletIdentity
{
    private static WalletIdentity sWalletIdentity;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public WalletIdentity(Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new WalletBaseHelper(mContext)
                .getWritableDatabase();
    }

    public static WalletIdentity get (Context context)
    {
        if (sWalletIdentity == null)
        {
            sWalletIdentity = new WalletIdentity(context);
        }
        return sWalletIdentity;
    }

    public static ContentValues getContentValues (Identity identity)
    {
        ContentValues values = new ContentValues();

        values.put(WalletDbSchema.IdentityTable.Cols.UUID,identity.getUUID().toString());
        values.put(WalletDbSchema.IdentityTable.Cols.TITLE, identity.getIdentity());
        values.put(WalletDbSchema.IdentityTable.Cols.FIRSTNAME, identity.getFirstName());
        values.put(WalletDbSchema.IdentityTable.Cols.LASTNAME, identity.getLastName());
        values.put(WalletDbSchema.IdentityTable.Cols.SEX, identity.getSex());
        values.put(WalletDbSchema.IdentityTable.Cols.BIRTHDATE, identity.getBirthDate());
        values.put(WalletDbSchema.IdentityTable.Cols.OCCUPATION, identity.getOccupation());
        values.put(WalletDbSchema.IdentityTable.Cols.COMPANY, identity.getCompany());
        values.put(WalletDbSchema.IdentityTable.Cols.DEPARTMENT, identity.getDepartMent());
        values.put(WalletDbSchema.IdentityTable.Cols.JOBTITLE, identity.getJobTitle());
        values.put(WalletDbSchema.IdentityTable.Cols.STREET, identity.getStreet());
        values.put(WalletDbSchema.IdentityTable.Cols.CITY, identity.getCity());
        values.put(WalletDbSchema.IdentityTable.Cols.ZIP, identity.getZip());
        values.put(WalletDbSchema.IdentityTable.Cols.PROVINCE, identity.getProvince());
        values.put(WalletDbSchema.IdentityTable.Cols.COUNTRY, identity.getCountry());
        values.put(WalletDbSchema.IdentityTable.Cols.HOMEPHONE, identity.getHomePhone());
        values.put(WalletDbSchema.IdentityTable.Cols.CELLPHONE, identity.getCellPhone());
        values.put(WalletDbSchema.IdentityTable.Cols.BUSSINESSPHONE, identity.getBussinessPhone());
        values.put(WalletDbSchema.IdentityTable.Cols.USERNAME, identity.getUserName());
        values.put(WalletDbSchema.IdentityTable.Cols.REMINDERQ, identity.getReminderQuestion());
        values.put(WalletDbSchema.IdentityTable.Cols.REMINDERA, identity.getReminderAnswer());
        values.put(WalletDbSchema.IdentityTable.Cols.EMAIL, identity.getEmail());
        values.put(WalletDbSchema.IdentityTable.Cols.WEBSITE, identity.getWebSite());
        values.put(WalletDbSchema.IdentityTable.Cols.ICQ, identity.getICQ());
        values.put(WalletDbSchema.IdentityTable.Cols.SKYPE, identity.getSkype());
        values.put(WalletDbSchema.IdentityTable.Cols.FORUM, identity.getForumSignature());


        return values;
    }

    public List<Identity> getIdentity()
    {
        List<Identity> identity = new ArrayList<>();

        WalletCursorWrapper cursor = queryIdentity(null, null);

        try
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                identity.add(cursor.getIdentity());
                cursor.moveToNext();
            }

        }
        finally
        {
            cursor.close();
        }

        return identity;
    }

    //returns data bassed on id
    public Identity getWalletIdentity(UUID id)
    {
        WalletCursorWrapper cursor = queryIdentity(
                WalletDbSchema.IdentityTable.Cols.UUID + " =? "
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
            return cursor.getIdentity();
        }
        finally
        {
            cursor.close();
        }
    }

    private WalletCursorWrapper queryIdentity (String whereClause, String[] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                WalletDbSchema.IdentityTable.NAME,
                null, // Colums - null select all colums
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null // order

        );

        return new WalletCursorWrapper(cursor);
    }

    public File getPhotoFile (Identity identity)
    {
        File externalFileDir = mContext
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFileDir == null)
        {
            return null;
        }
        return new File(externalFileDir, identity.getPhotoFileName());
    }


    public void upDateIdentity(Identity identity)
    {
        String uuidString = identity.getUUID().toString();
        ContentValues values = getContentValues(identity);

        mDatabase.update(WalletDbSchema.IdentityTable.NAME, values,
                WalletDbSchema.CrimeTable.Cols.UUID + " =?"
                , new String[]{uuidString});
    }

    //Add Crime
    public void addIdentity (Identity i)
    {
        ContentValues values = getContentValues(i);

        mDatabase.insert(WalletDbSchema.IdentityTable.NAME, null, values);
    }

    //Delete Crime
    public void deleteCrime(UUID uuid)
    {
        String uuidString = uuid.toString();

        mDatabase.delete(WalletDbSchema.IdentityTable.NAME, WalletDbSchema.IdentityTable.Cols.UUID + " = ?", new String[]{uuidString});
    }

}
