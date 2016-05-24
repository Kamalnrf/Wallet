package com.example.kamalnrf.wallet.Controllers.LicenceControllers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

/**
 * Created by kamalnrf on 24/5/16.
 */
public class LicenceListActivity extends SingleLicenceActivity
{
    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, LicenceListActivity.class);
        return i;
    }


    @Override
    protected Fragment createFragment() {
        return new LicenceListFragment();
    }
}
