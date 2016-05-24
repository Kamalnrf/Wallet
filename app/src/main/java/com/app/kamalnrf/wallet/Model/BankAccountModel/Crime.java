package com.app.kamalnrf.wallet.Model.BankAccountModel;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kamalnrf on 8/4/16.
 *
 * Layer Level :- Model;
 */
public class Crime
{
    //UUID means universal unique identifier
    private UUID mId;
    private String mTitle = "Bank Account";
    private Date mDate;
    private String mAccountNumber;
    private String mAccountType;
    private String mBankName;
    private String mIBANNumber;
    private String mPhone;
    private String mAddress;
    private String mNameOnAccount;
    private String mRoutingNumber;
    private String mPin;
    private String mSWIFTCode;



    public Crime()
    {
        this(UUID.randomUUID());
    }

    public Crime(UUID id)
    {
        mId = id;
        mDate = new Date();
    }


    public UUID getId()
    {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getSWIFTCode() {
        return mSWIFTCode;
    }

    public void setSWIFTCode(String SWIFTCode) {
        mSWIFTCode = SWIFTCode;
    }

    public String getPin() {
    
        return mPin;
    }

    public void setPin(String pin) {
        mPin = pin;
    }

    public String getRoutingNumber() {
    
        return mRoutingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        mRoutingNumber = routingNumber;
    }

    public String getNameOnContact() {
    
        return mNameOnAccount;
    }

    public void setNameOnContact(String nameOnContact) {
        mNameOnAccount = nameOnContact;
    }

    public String getPhone() {
    
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getIBANNumber() {
    
        return mIBANNumber;
    }

    public void setIBANNumber(String IBANNumber) {
        mIBANNumber = IBANNumber;
    }

    public String getBankName() {
    
        return mBankName;
    }

    public void setBankName(String bankName) {
        mBankName = bankName;
    }

    public String getAccountType() {
    
        return mAccountType;
    }

    public void setAccountType(String accountType) {
        mAccountType = accountType;
    }

    public String getAccountNumber() {
    
        return mAccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        mAccountNumber = accountNumber;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPhotoFileName ()
    {
        return "IMG_" + getId().toString() + ".jpg";
    }
}

