package com.example.kamalnrf.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kamalnrf.wallet.Controllers.BankAccountCntrollers.BankAccountListActivity;
import com.example.kamalnrf.wallet.Controllers.IdentityControllers.IndentityListActivity;
import com.example.kamalnrf.wallet.Controllers.WireLessController.WirelessRouterListActivity;

public class WalletActivity extends AppCompatActivity
{
    private Button mBankAccount;
    private Button mCreditCard;
    private Button mPassport;
    private Button mLicence;
    private Button mIdentity;
    private Button mWifiRouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        mBankAccount = (Button) findViewById(R.id.bank_account);
        mBankAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = BankAccountListActivity.newIntent(WalletActivity.this);
                startActivity(intent);
            }
        });

        mIdentity = (Button) findViewById(R.id.identity);
        mIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = IndentityListActivity.newIntent(WalletActivity.this);
                startActivity(intent);
            }
        });

        mWifiRouter = (Button) findViewById(R.id.wifi_router);
        mWifiRouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = WirelessRouterListActivity.newIntent(WalletActivity.this);
                startActivity(intent);
            }
        });
    }
}
