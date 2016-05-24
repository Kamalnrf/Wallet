package com.example.kamalnrf.wallet.DataBase;

/**
 * Created by kamalnrf on 18/4/16.
 */
public class WalletDbSchema
{
    public static final class CrimeTable
    {
        public static final String NAME = "crimes";

        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String BANKNAME = "bank";
            public static final String NAMEONACCOUNT = "name";
            public static final String ACCOUNTTYPE = "actype";
            public static final String ROUTINGNUMBER = "routing";
            public static final String ACCOUNTNUMBER = "acnumber";
            public static final String SWIFTNUMBER = "swiftnumber";
            public static final String IBANNUMBER = "ibannumber";
            public static final String PIN = "pin";
            public static final String PHONE = "phone";
            public static final String ADDRESS = "address";
        }
    }

    public static final class IdentityTable
    {
        public static final String NAME = "identity";


        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String FIRSTNAME = "first";
            public static final String LASTNAME = "last";
            public static final String SEX = "sex";
            public static final String BIRTHDATE = "birth";
            public static final String OCCUPATION = "occupation";
            public static final String COMPANY = "company";
            public static final String DEPARTMENT = "department";
            public static final String JOBTITLE = "job";
            public static final String STREET = "street";
            public static final String CITY = "city";
            public static final String ZIP = "ZIP";
            public static final String PROVINCE = "province";
            public static final String COUNTRY = "country";
            public static final String HOMEPHONE = "home";
            public static final String CELLPHONE = "cell";
            public static final String BUSSINESSPHONE = "bussiness";
            public static final String USERNAME = "user";
            public static final String REMINDERQ = "reminderq";
            public static final String REMINDERA = "remindera";
            public static final String EMAIL = "email";
            public static final String WEBSITE = "website";
            public static final String ICQ = "icq";
            public static final String SKYPE = "skype";
            public static final String FORUM = "forum";

        }
    }

    public static final class WirelessRouter
    {
        public static final String NAME = "wireless";

        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String WIRELESSROUTER = "title";
            public static final String BASESTAIONNAME = "basestation";
            public static final String BASESTATIONPASSWORD = "basepassword";
            public static final String SERVER = "server";
            public static final String AIRPORT = "airport";
            public static final String NETWORKNAME = "network";
            public static final String WIRELESSSECURITY = "wirlesssecurity";
            public static final String WRILESSNETWORKPASSWORD = "wirelessnetwork";
            public static final String WIRELESSSTORAGEPASSWORD = "wirelessstorage";
        }
    }

    public static final class Licence
    {
        public static final String NAME = "licence";

        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String FULLNAME = "full";
            public static final String ADDRESS = "address";
            public static final String DATE = "date";
            public static final String SEX = "sex";
            public static final String HEIGHT = "height";
            public static final String NUMBER = "number";
            public static final String STATE = "state";
            public static final String COUNTRY = "country";
            public static final String EXDATE = "exdate";
            public static final String LICENCECLASS = "licenceclass";
        }
    }

}
