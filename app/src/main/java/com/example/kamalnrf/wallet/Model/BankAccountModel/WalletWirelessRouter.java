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
public class WalletWirelessRouter
{
    private static WalletWirelessRouter sWalletWirelessRouter;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public WalletWirelessRouter (Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new WalletBaseHelper(mContext)
                .getWritableDatabase();

    }

    public static WalletWirelessRouter get (Context context)
    {
        if (sWalletWirelessRouter == null)
        {
            sWalletWirelessRouter = new WalletWirelessRouter(context);
        }
        return sWalletWirelessRouter;
    }

    private static ContentValues getContentValues (WirelessRouter wirelessRouter)
    {
        ContentValues values = new ContentValues();

        values.put(WalletDbSchema.WirelessRouter.Cols.UUID, wirelessRouter.getUUID().toString());
        values.put(WalletDbSchema.WirelessRouter.Cols.WIRELESSROUTER, wirelessRouter.getWirelessRouter());
        values.put(WalletDbSchema.WirelessRouter.Cols.BASESTAIONNAME, wirelessRouter.getBaseStationName());
        values.put(WalletDbSchema.WirelessRouter.Cols.BASESTATIONPASSWORD, wirelessRouter.getBaseStationPassword());
        values.put(WalletDbSchema.WirelessRouter.Cols.SERVER, wirelessRouter.getServer());
        values.put(WalletDbSchema.WirelessRouter.Cols.AIRPORT, wirelessRouter.getAirPort());
        values.put(WalletDbSchema.WirelessRouter.Cols.NETWORKNAME, wirelessRouter.getNetWorkName());
        values.put(WalletDbSchema.WirelessRouter.Cols.WIRELESSSECURITY, wirelessRouter.getWireLessSecurity());
        values.put(WalletDbSchema.WirelessRouter.Cols.WRILESSNETWORKPASSWORD, wirelessRouter.getWirelessNetworkPassword());
        values.put(WalletDbSchema.WirelessRouter.Cols.WIRELESSSTORAGEPASSWORD, wirelessRouter.getWirelessStoragePasssword());


        return values;
    }

    public List<WirelessRouter> getWirelessRouter()
    {
        List<WirelessRouter> wirelessRouters = new ArrayList<>();

        WalletCursorWrapper cursor = queryWireless(null, null);

        try
        {
           cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                wirelessRouters.add(cursor.getWirelessRouter());
                cursor.moveToNext();
            }

        }
        finally
        {
            cursor.close();
        }

        return wirelessRouters;
    }

    //returns data bassed on id
    public WirelessRouter getWirelessRouter(UUID id)
    {
        WalletCursorWrapper cursor = queryWireless(
                WalletDbSchema.WirelessRouter.Cols.UUID + " =? "
                , new String[]
                        {
                                id.toString()
                        }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getWirelessRouter();
        } finally {
            cursor.close();
        }
    }

    public void addWireless (WirelessRouter w)
    {
        long d;
        ContentValues values = getContentValues(w);

        mDatabase.insert(WalletDbSchema.WirelessRouter.NAME, null, values);

    }

    //Delete Crime
    public void deleteWirless(UUID wirelessId)
    {
        String uuidString = wirelessId.toString();

        mDatabase.delete(WalletDbSchema.WirelessRouter.NAME, WalletDbSchema.WirelessRouter.Cols.UUID + " = ?", new String[]{uuidString});
    }


    private WalletCursorWrapper queryWireless (String whereClause, String[] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                WalletDbSchema.WirelessRouter.NAME,
                null, // Colums - null select all colums
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null // order

        );

        return new WalletCursorWrapper(cursor);
    }

    public void upDateWireless(WirelessRouter wirelessRouter)
    {
        String uuidString = wirelessRouter.getUUID().toString();
        ContentValues values = getContentValues(wirelessRouter);

        mDatabase.update(WalletDbSchema.WirelessRouter.NAME, values,
                WalletDbSchema.WirelessRouter.Cols.UUID + " =?"
                , new String[]{uuidString});
    }


    public File getPhotoFile (WirelessRouter wirelessRouter)
    {
        File externalFileDir = mContext
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFileDir == null)
        {
            return null;
        }
        return new File(externalFileDir, wirelessRouter.getPhotoFileName());
    }
}
