package com.example.kamalnrf.wallet.Model.BankAccountModel;

import java.util.UUID;

/**
 * Created by kamalnrf on 7/5/16.
 */
public class WirelessRouter
{
    private UUID mUUID;
    private String mWirelessRouter = "Wireless Router";
    private String mBaseStationName;
    private String mBaseStationPassword;
    private String mServer;
    private String mAirPort;
    private String mNetWorkName;
    private String mWireLessSecurity;
    private String mWirelessNetworkPassword;
    private String mWirelessStoragePasssword;

    public String getWirelessRouter() {
        return mWirelessRouter;
    }

    public void setWirelessRouter(String wirelessRouter) {
        mWirelessRouter = wirelessRouter;
    }

    public WirelessRouter()
    {
        this(UUID.randomUUID());
    }

    public WirelessRouter(UUID uuid)
    {
        mUUID = uuid;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getWirelessStoragePasssword() {

        return mWirelessStoragePasssword;
    }

    public void setWirelessStoragePasssword(String wirelessStoragePasssword) {
        mWirelessStoragePasssword = wirelessStoragePasssword;
    }

    public String getWirelessNetworkPassword() {

        return mWirelessNetworkPassword;
    }

    public void setWirelessNetworkPassword(String wirelessNetworkPassword) {
        mWirelessNetworkPassword = wirelessNetworkPassword;
    }

    public String getWireLessSecurity() {

        return mWireLessSecurity;
    }

    public void setWireLessSecurity(String wireLessSecurity) {
        mWireLessSecurity = wireLessSecurity;
    }

    public String getNetWorkName() {

        return mNetWorkName;
    }

    public void setNetWorkName(String netWorkName) {
        mNetWorkName = netWorkName;
    }

    public String getAirPort() {

        return mAirPort;
    }

    public void setAirPort(String airPort) {
        mAirPort = airPort;
    }

    public String getServer() {

        return mServer;
    }

    public void setServer(String server) {
        mServer = server;
    }

    public String getBaseStationPassword() {

        return mBaseStationPassword;
    }

    public void setBaseStationPassword(String baseStationPassword) {
        mBaseStationPassword = baseStationPassword;
    }

    public String getBaseStationName() {

        return mBaseStationName;
    }

    public void setBaseStationName(String baseStationName) {
        mBaseStationName = baseStationName;
    }

    public String getPhotoFileName() {
        return "IMG_" + getUUID().toString() + ".jpg";
    }
}
