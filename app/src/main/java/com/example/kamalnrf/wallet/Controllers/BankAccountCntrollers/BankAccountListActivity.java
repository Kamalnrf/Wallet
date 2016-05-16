package com.example.kamalnrf.wallet.Controllers.BankAccountCntrollers;

//Layer Level :- controller

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by kamalnrf on 8/4/16.
 */
public class BankAccountListActivity extends SingleFragmentActivity
{
    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, BankAccountListActivity.class);
        return i;
    }

    @Override
    protected Fragment createFragment()
    {
        return new BankAccountListFragment();
    }


}
