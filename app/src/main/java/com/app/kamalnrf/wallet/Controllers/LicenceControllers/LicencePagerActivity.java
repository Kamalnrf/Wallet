package com.app.kamalnrf.wallet.Controllers.LicenceControllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.kamalnrf.wallet.Model.BankAccountModel.Licence;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WalletLicence;
import com.app.kamalnrf.wallet.R;

import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 24/5/16.
 */
public class LicencePagerActivity extends AppCompatActivity
{
    private static final String EXTRA_ID = "com.app.kamalnrf.wallet.Controllers.LicenceControllers.LicencePagerActivity";
    private ViewPager mViewPager;
    private List<Licence> mLiceneList;

    public static Intent newIntent (Context packageContext, UUID uuid)
    {
        Intent intent = new Intent(packageContext, LicencePagerActivity.class);
        intent.putExtra(EXTRA_ID, uuid);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activty_licence_pager);

        //Adapters for view pager
        mViewPager = (ViewPager) findViewById(R.id.activity_licence_pager_view_pager);

        mLiceneList = WalletLicence.get(this).getLicence();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Licence licence = mLiceneList.get(position);
                return LicenceFragment.newInstance(licence.getUUID());
            }

            @Override
            public int getCount() {
                return mLiceneList.size();
            }
        });

        UUID uuid = (UUID) getIntent().getSerializableExtra(EXTRA_ID);

        for (int i = 0; i < mLiceneList.size(); i++)
        {
            if (mLiceneList.get(i).getUUID().equals(uuid))
            {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }

}
