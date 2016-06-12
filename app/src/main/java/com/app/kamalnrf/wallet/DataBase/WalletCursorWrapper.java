package com.app.kamalnrf.wallet.DataBase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.app.kamalnrf.wallet.Model.BankAccountModel.Crime;
import com.app.kamalnrf.wallet.Model.BankAccountModel.Identity;
import com.app.kamalnrf.wallet.Model.BankAccountModel.Licence;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WirelessRouter;
import com.app.kamalnrf.wallet.Passwor;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kamalnrf on 18/4/16.
 */
public class WalletCursorWrapper extends CursorWrapper
{

    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public WalletCursorWrapper(Cursor cursor) {
        super(cursor);

    }

    public Crime getCrime()
    {
        String uuidString = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(WalletDbSchema.CrimeTable.Cols.DATE));
        String bankName = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.BANKNAME));
        String nameOnAccount = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.NAMEONACCOUNT));
        String accountType = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.ACCOUNTTYPE));
        String routingNUmber  = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.ROUTINGNUMBER));
        String accountNumber = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.ACCOUNTNUMBER));
        String swiftCode = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.SWIFTNUMBER));
        String ibanNumber = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.IBANNUMBER));
        String pin = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.PIN));
        String phone = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.PHONE));
        String address = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.ADDRESS));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setAccountNumber(accountNumber);
        crime.setAccountType(accountType);
        crime.setAddress(address);
        crime.setBankName(bankName);
        crime.setIBANNumber(ibanNumber);
        crime.setPhone(phone);
        crime.setNameOnContact(nameOnAccount);
        crime.setRoutingNumber(routingNUmber);
        crime.setPin(pin);
        crime.setSWIFTCode(swiftCode);
        crime.setTitle(title);
        crime.setDate(new Date(date));

        return crime;
    }

    public Identity getIdentity()
    {
        String uuidString = getString(getColumnIndex(WalletDbSchema.CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.TITLE));
        String firstName = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.FIRSTNAME));
        String lastName = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.LASTNAME));
        String sex = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.SEX));
        String birthDate = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.BIRTHDATE));
        String occupation = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.OCCUPATION));
        String company = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.COMPANY));
        String  department= getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.DEPARTMENT));
        String jobTitle = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.JOBTITLE));
        String  street = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.STREET));
        String  city = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.CITY));
        String zip = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.ZIP));
        String province = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.PROVINCE));
        String country = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.COUNTRY));
        String homePhone = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.HOMEPHONE));
        String cellPhone = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.CELLPHONE));
        String bussinessPhone = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.BUSSINESSPHONE));
        String userName = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.USERNAME));
        String reminderQ = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.REMINDERQ));
        String reminderA = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.REMINDERA));
        String email = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.EMAIL));
        String website = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.WEBSITE));
        String icq = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.ICQ));
        String skype = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.SKYPE));
        String forum = getString(getColumnIndex(WalletDbSchema.IdentityTable.Cols.FORUM));

        Identity identity = new Identity(UUID.fromString(uuidString));
        identity.setIdentity(title);
        identity.setFirstName(firstName);
        identity.setLastName(lastName);
        identity.setSex(sex);
        identity.setBirthDate(birthDate);
        identity.setOccupation(occupation);
        identity.setCompany(company);
        identity.setDepartMent(department);
        identity.setJobTitle(jobTitle);
        identity.setStreet(street);
        identity.setCity(city);
        identity.setZip(zip);
        identity.setProvince(province);
        identity.setCountry(country);
        identity.setHomePhone(homePhone);
        identity.setCellPhone(cellPhone);
        identity.setBussinessPhone(bussinessPhone);
        identity.setUserName(userName);
        identity.setReminderQuestion(reminderQ);
        identity.setReminderAnswer(reminderA);
        identity.setEmail(email);
        identity.setWebSite(website);
        identity.setICQ(icq);
        identity.setSkype(skype);
        identity.setForumSignature(forum);

        return identity;
    }

    public WirelessRouter getWirelessRouter()
    {
        String uuidString = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.UUID));
        String wirelessRouterName = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.WIRELESSROUTER));
        String baseStationName = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.BASESTAIONNAME));
        String baseStationPassword = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.BASESTATIONPASSWORD));
        String server = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.SERVER));
        String airPort = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.AIRPORT));
        String netWorkName = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.NETWORKNAME));
        String wirelessSecurity = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.WIRELESSSECURITY));
        String wirelessNetworkPassword = getString(getColumnIndexOrThrow(WalletDbSchema.WirelessRouter.Cols.WRILESSNETWORKPASSWORD));
        String wirelessStoragePassword = getString(getColumnIndex(WalletDbSchema.WirelessRouter.Cols.WIRELESSSTORAGEPASSWORD));

        WirelessRouter wirelessRouter = new WirelessRouter(UUID.fromString(uuidString));
        wirelessRouter.setWirelessRouter(wirelessRouterName);
        wirelessRouter.setAirPort(airPort);
        wirelessRouter.setBaseStationName(baseStationName);
        wirelessRouter.setBaseStationPassword(baseStationPassword);
        wirelessRouter.setServer(server);
        wirelessRouter.setNetWorkName(netWorkName);
        wirelessRouter.setWireLessSecurity(wirelessSecurity);
        wirelessRouter.setWirelessNetworkPassword(wirelessNetworkPassword);
        wirelessRouter.setWirelessStoragePasssword(wirelessStoragePassword);

        return wirelessRouter;
    }

    public Licence getLicence ()
    {
        String uuidString = getString(getColumnIndex(WalletDbSchema.Licence.Cols.UUID));
        String fullName = getString(getColumnIndex(WalletDbSchema.Licence.Cols.FULLNAME));
        String date = getString(getColumnIndex(WalletDbSchema.Licence.Cols.DATE));
        String sex = getString(getColumnIndex(WalletDbSchema.Licence.Cols.SEX));
        String height = getString(getColumnIndex(WalletDbSchema.Licence.Cols.HEIGHT));
        String number = getString(getColumnIndex(WalletDbSchema.Licence.Cols.NUMBER));
        String state = getString(getColumnIndex(WalletDbSchema.Licence.Cols.STATE));
        String country = getString(getColumnIndex(WalletDbSchema.Licence.Cols.COUNTRY));
        String exDate = getString(getColumnIndex(WalletDbSchema.Licence.Cols.EXDATE));
        String address = getString(getColumnIndex(WalletDbSchema.Licence.Cols.ADDRESS));
        String licenceClass = getString(getColumnIndex(WalletDbSchema.Licence.Cols.LICENCECLASS));

        Licence licence1 = new Licence(UUID.fromString(uuidString));
        licence1.setAddress(address);
        licence1.setCountry(country);
        licence1.setDateOfBirth(date);
        licence1.setExpiryDate(exDate);
        licence1.setFullName(fullName);
        licence1.setHeight(height);
        licence1.setLicenceClass(licenceClass);
        licence1.setNumber(number);
        licence1.setSex(sex);
        licence1.setCountry(country);
        licence1.setExpiryDate(exDate);
        licence1.setState(state);

        return licence1;
    }

    public Passwor getPassword ()
    {
        String password = getString(getColumnIndex(WalletDbSchema.Password.Cols.PASSWORD));
        String uuid = "1";

        Passwor passwor = new Passwor();
        passwor.setPassword(password);

        return passwor;
    }

}
