package com.example.kamalnrf.wallet.Model.BankAccountModel;

import java.util.UUID;

/**
 * Created by kamalnrf on 18/5/16.
 */
public class Licence
{
    public UUID mUUID;
    private String mTitle = "Licence";
    public String mFullName;
    public String mAddress;
    public String mDateOfBirth;
    public String mSex;
    public String mHeight;
    public String mNumber;
    public String mLicenceClass;
    public String mState;
    public String mCountry;
    public String mExpiryDate;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Licence ()
    {
        this(UUID.randomUUID());
    }

    public Licence (UUID uuid)
    {
        mUUID = uuid;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getExpiryDate() {

        return mExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        mExpiryDate = expiryDate;
    }

    public String getCountry() {

        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getState() {

        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getLicenceClass() {

        return mLicenceClass;
    }

    public void setLicenceClass(String licenceClass) {
        mLicenceClass = licenceClass;
    }

    public String getNumber() {

        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public String getHeight() {

        return mHeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getSex() {

        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    public String getDateOfBirth() {

        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getAddress() {

        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getFullName() {

        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }
}
