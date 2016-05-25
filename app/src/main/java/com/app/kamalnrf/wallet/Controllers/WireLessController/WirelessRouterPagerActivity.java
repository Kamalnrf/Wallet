package com.app.kamalnrf.wallet.Controllers.WireLessController;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.kamalnrf.wallet.Model.BankAccountModel.WalletWirelessRouter;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WirelessRouter;
import com.app.kamalnrf.wallet.R;

import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 8/5/16.
 */
public class WirelessRouterPagerActivity extends AppCompatActivity
{
    private static final String EXTRA_ID = "com.app.kamalnrf.wallet.Controllers.WireLessController";
    private ViewPager mViewPager;
    private List<WirelessRouter> mWirelessRouters;

    public static Intent newIntent (Context packageContext, UUID uuid)
    {
        Intent intent = new Intent(packageContext, WirelessRouterPagerActivity.class);
        intent.putExtra(EXTRA_ID, uuid);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wireless_pager);

        //Adapters for view pager
        mViewPager = (ViewPager) findViewById(R.id.wireless_view_pager);

        mWirelessRouters = WalletWirelessRouter.get(this).getWirelessRouter();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                WirelessRouter wirelessRouter = mWirelessRouters.get(position);
                return WirelessRouterFragment.newInstance(wirelessRouter.getUUID());
            }

            @Override
            public int getCount() {
                return mWirelessRouters.size();
            }
        });

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_ID);

        for (int i = 0; i < mWirelessRouters.size(); i++)
        {
            if (mWirelessRouters.get(i).getUUID().equals(crimeId))
            {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
