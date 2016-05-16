package com.example.kamalnrf.wallet.Model.BankAccountModel;

import java.util.UUID;

/**
 * Created by kamalnrf on 7/5/16.
 */
public class Identity
{
    private UUID mUUID;
    private String mIdentity = "Identity";
    private String mFirstName;
    private String mLastName;
    private String mSex;
    private String mBirthDate;
    private String mOccupation;
    private String mCompany;
    private String mDepartMent;
    private String mJobTitle;
    private String mStreet;
    private String mCity;
    private String mZip;
    private String mProvince;
    private String mCountry;
    private String mHomePhone;
    private String mCellPhone;
    private String mBussinessPhone;
    private String mUserName;
    private String mReminderQuestion;
    private String mReminderAnswer;
    private String mEmail;
    private String mWebSite;
    private String mICQ;
    private String mSkype;
    private String mForumSignature;

    public Identity ()
    {
        this(UUID.randomUUID());
    }

    public Identity(UUID uuid) {
        mUUID = uuid;
    }


    public String getForumSignature() {
        return mForumSignature;
    }

    public void setForumSignature(String forumSignature) {
        mForumSignature = forumSignature;
    }

    public String getSkype() {

        return mSkype;
    }

    public void setSkype(String skype) {
        mSkype = skype;
    }

    public String getICQ() {

        return mICQ;
    }

    public void setICQ(String ICQ) {
        mICQ = ICQ;
    }

    public String getWebSite() {

        return mWebSite;
    }

    public void setWebSite(String webSite) {
        mWebSite = webSite;
    }

    public String getEmail() {

        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getReminderAnswer() {

        return mReminderAnswer;
    }

    public void setReminderAnswer(String reminderAnswer) {
        mReminderAnswer = reminderAnswer;
    }

    public String getReminderQuestion() {

        return mReminderQuestion;
    }

    public void setReminderQuestion(String reminderQuestion) {
        mReminderQuestion = reminderQuestion;
    }

    public String getUserName() {

        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getBussinessPhone() {

        return mBussinessPhone;
    }

    public void setBussinessPhone(String bussinessPhone) {
        mBussinessPhone = bussinessPhone;
    }

    public String getCellPhone() {

        return mCellPhone;
    }

    public void setCellPhone(String cellPhone) {
        mCellPhone = cellPhone;
    }

    public String getHomePhone() {

        return mHomePhone;
    }

    public void setHomePhone(String homePhone) {
        mHomePhone = homePhone;
    }

    public String getCountry() {

        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getProvince() {

        return mProvince;
    }

    public void setProvince(String province) {
        mProvince = province;
    }

    public String getZip() {

        return mZip;
    }

    public void setZip(String zip) {
        mZip = zip;
    }

    public String getCity() {

        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getStreet() {

        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getJobTitle() {

        return mJobTitle;
    }

    public void setJobTitle(String jobTitle) {
        mJobTitle = jobTitle;
    }

    public String getDepartMent() {

        return mDepartMent;
    }

    public void setDepartMent(String departMent) {
        mDepartMent = departMent;
    }

    public String getCompany() {

        return mCompany;
    }

    public void setCompany(String company) {
        mCompany = company;
    }

    public String getOccupation() {

        return mOccupation;
    }

    public void setOccupation(String occupation) {
        mOccupation = occupation;
    }

    public String getBirthDate() {

        return mBirthDate;
    }

    public void setBirthDate(String birthDate) {
        mBirthDate = birthDate;
    }

    public String getSex() {

        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    public String getLastName() {

        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getFirstName() {

        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getIdentity() {

        return mIdentity;
    }

    public void setIdentity(String identity) {
        mIdentity = identity;
    }

    public String getPhotoFileName ()
    {
        return "IMG_" + getUUID().toString() + ".jpg";
    }

    public UUID getUUID() {
        return mUUID;
    }
}
