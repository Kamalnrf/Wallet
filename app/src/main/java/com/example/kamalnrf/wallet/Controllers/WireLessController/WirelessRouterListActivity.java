package com.example.kamalnrf.wallet.Controllers.WireLessController;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by kamalnrf on 8/5/16.
 */
public class WirelessRouterListActivity extends SingleWirelessActivity
{
    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, WirelessRouterListActivity.class);
        return i;
    }

    @Override
    protected Fragment createFragment() {
        return new WirelessRouterListFragment();
    }
}
