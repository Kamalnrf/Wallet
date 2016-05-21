package com.example.kamalnrf.wallet.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kamalnrf on 18/4/16.
 */
public class WalletBaseHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public WalletBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table "+ WalletDbSchema.CrimeTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        WalletDbSchema.CrimeTable.Cols.UUID +", " +
                        WalletDbSchema.CrimeTable.Cols.TITLE + ", "+
                        WalletDbSchema.CrimeTable.Cols.DATE +
                        " ,"+
                        WalletDbSchema.CrimeTable.Cols.ACCOUNTNUMBER + ", "+
                        WalletDbSchema.CrimeTable.Cols.ACCOUNTTYPE + ", "+
                        WalletDbSchema.CrimeTable.Cols.ADDRESS + ", " +
                        WalletDbSchema.CrimeTable.Cols.BANKNAME + ", " +
                        WalletDbSchema.CrimeTable.Cols.IBANNUMBER + ", "+
                        WalletDbSchema.CrimeTable.Cols.NAMEONACCOUNT + ", "+
                        WalletDbSchema.CrimeTable.Cols.PHONE +", " +
                        WalletDbSchema.CrimeTable.Cols.PIN + ", "+
                        WalletDbSchema.CrimeTable.Cols.ROUTINGNUMBER + ", " +
                        WalletDbSchema.CrimeTable.Cols.SWIFTNUMBER + ")"
        );

        db.execSQL("create table "+ WalletDbSchema.IdentityTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                WalletDbSchema.IdentityTable.Cols.UUID + ", "+
                WalletDbSchema.IdentityTable.Cols.BIRTHDATE + ", "+
                WalletDbSchema.IdentityTable.Cols.BUSSINESSPHONE + ", "+
                WalletDbSchema.IdentityTable.Cols.CELLPHONE + ", "+
                WalletDbSchema.IdentityTable.Cols.CITY + ", "+
                WalletDbSchema.IdentityTable.Cols.COMPANY + ", "+
                WalletDbSchema.IdentityTable.Cols.COUNTRY + ", "+
                WalletDbSchema.IdentityTable.Cols.DEPARTMENT + ", "+
                WalletDbSchema.IdentityTable.Cols.EMAIL + ", "+
                WalletDbSchema.IdentityTable.Cols.FIRSTNAME + ", "+
                WalletDbSchema.IdentityTable.Cols.FORUM + ", "+
                WalletDbSchema.IdentityTable.Cols.HOMEPHONE + ", "+
                WalletDbSchema.IdentityTable.Cols.ICQ + ", "+
                WalletDbSchema.IdentityTable.Cols.JOBTITLE + ", "+
                WalletDbSchema.IdentityTable.Cols.LASTNAME + ", "+
                WalletDbSchema.IdentityTable.Cols.OCCUPATION + ", "+
                WalletDbSchema.IdentityTable.Cols.PROVINCE + ", "+
                WalletDbSchema.IdentityTable.Cols.REMINDERA + ", "+
                WalletDbSchema.IdentityTable.Cols.SEX + ", "+
                WalletDbSchema.IdentityTable.Cols.SKYPE  + ", "+
                WalletDbSchema.IdentityTable.Cols.TITLE + ", "+
                WalletDbSchema.IdentityTable.Cols.STREET + ", "+
                WalletDbSchema.IdentityTable.Cols.ZIP + ", "+
                WalletDbSchema.IdentityTable.Cols.USERNAME + ", "+
                WalletDbSchema.IdentityTable.Cols.REMINDERQ + ", "+
                WalletDbSchema.IdentityTable.Cols.WEBSITE + ")"
        );

        db.execSQL("create table "+ WalletDbSchema.WirelessRouter.NAME + "(" +
                " _id integer primary key autoincrement, " +
                WalletDbSchema.WirelessRouter.Cols.UUID + ", " +
                        WalletDbSchema.WirelessRouter.Cols.WIRELESSROUTER + ", " +
                        WalletDbSchema.WirelessRouter.Cols.AIRPORT + ", "+
                        WalletDbSchema.WirelessRouter.Cols.BASESTAIONNAME + ", "+
                        WalletDbSchema.WirelessRouter.Cols.BASESTATIONPASSWORD + ", "+
                        WalletDbSchema.WirelessRouter.Cols.SERVER + ", "+
                        WalletDbSchema.WirelessRouter.Cols.NETWORKNAME + ", "+
                        WalletDbSchema.WirelessRouter.Cols.WRILESSNETWORKPASSWORD + ", "+
                        WalletDbSchema.WirelessRouter.Cols.WIRELESSSTORAGEPASSWORD + ", "+
                        WalletDbSchema.WirelessRouter.Cols.WIRELESSSECURITY + ")"
        );

        db.execSQL("create table "+ WalletDbSchema.Licence.NAME + "(" +
                " _id integer primary key autoincrement, " +
                WalletDbSchema.WirelessRouter.Cols.UUID + ", " +
                WalletDbSchema.Licence.Cols.ADDRESS + ", " +
                WalletDbSchema.Licence.Cols.COUNTRY + ", " +
                WalletDbSchema.Licence.Cols.DATE + ", " +
                WalletDbSchema.Licence.Cols.EXDATE +", " +
                WalletDbSchema.Licence.Cols.FULLNAME + ", " +
                WalletDbSchema.Licence.Cols.HEIGHT + ", " +
                WalletDbSchema.Licence.Cols.NUMBER + ", " +
                WalletDbSchema.Licence.Cols.SEX + ", " +
                WalletDbSchema.Licence.Cols.STATE + ", " +
                        WalletDbSchema.Licence.Cols.LICENCECLASS+")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
