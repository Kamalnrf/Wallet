package com.app.kamalnrf.wallet.Controllers.IdentityControllers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.app.kamalnrf.wallet.Controllers.BankAccountCntrollers.SingleFragmentActivity;

/**
 * Created by kamalnrf on 7/5/16.
 */
public class IndentityListActivity extends SingleFragmentActivity
{
    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, IndentityListActivity.class);
        return i;
    }

    @Override
    protected Fragment createFragment() {
        return new IdentityListFragment();
    }
}
