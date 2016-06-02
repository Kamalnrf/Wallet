package com.app.kamalnrf.wallet;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.app.kamalnrf.wallet.Controllers.BankAccountCntrollers.BankAccountListActivity;
import com.app.kamalnrf.wallet.Controllers.IdentityControllers.IndentityListActivity;
import com.app.kamalnrf.wallet.Controllers.LicenceControllers.LicenceListActivity;
import com.app.kamalnrf.wallet.Controllers.WireLessController.WirelessRouterListActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WalletActivity extends AppCompatActivity
{
    private Button mBankAccount;
    private Button mCreditCard;
    private Button mPassport;
    private Button mLicence;
    private Button mIdentity;
    private Button mWifiRouter;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);


        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mBankAccount = (Button) findViewById(R.id.bank_account);
        mBankAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = BankAccountListActivity.newIntent(WalletActivity.this);
                startActivity(intent);

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Fields")
                        .setAction("BankAccount")
                        .setLabel("Bank Account")
                        .setValue(1)
                        .build());
            }
        });

        mIdentity = (Button) findViewById(R.id.identity);
        mIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = IndentityListActivity.newIntent(WalletActivity.this);
                startActivity(intent);

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Fields")
                        .setAction("Identity")
                        .setLabel("Identity")
                        .setValue(1)
                        .build());
            }
        });

        mWifiRouter = (Button) findViewById(R.id.wifi_router);
        mWifiRouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = WirelessRouterListActivity.newIntent(WalletActivity.this);
                startActivity(intent);

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Fields")
                        .setAction("Wifi")
                        .setLabel("wifi")
                        .setValue(1)
                        .build());
            }
        });

        mLicence = (Button) findViewById(R.id.licence);
        mLicence.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = LicenceListActivity.newIntent(WalletActivity.this);
                startActivity(intent);

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Fields")
                        .setAction("Licence")
                        .setLabel("licence")
                        .setValue(1)
                        .build());
            }
        });
    }
}
