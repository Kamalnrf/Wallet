package com.app.kamalnrf.wallet.Controllers.BankAccountCntrollers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.kamalnrf.wallet.AnalyticsApplication;
import com.app.kamalnrf.wallet.Model.BankAccountModel.Crime;
import com.app.kamalnrf.wallet.Model.BankAccountModel.CrimeLab;
import com.app.kamalnrf.wallet.R;
import com.google.android.gms.analytics.Tracker;

import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 13/4/16.
 */
public class BankAccountPagetActivity extends AppCompatActivity
{
    private static final String EXTRA_CRIME_ID = "com.app.kamalnrf.wallet.Controllers.BankAccountCntrollers;";
    private ViewPager mViewPager;
    private List<Crime> mCrimes;
    private Tracker mTracker;

    public static Intent newIntent (Context packageContext, UUID crimeId)
    {
        Intent intent = new Intent(packageContext, BankAccountPagetActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_crime_pager);

        //Adapters for view pager
        mViewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);

        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position)
            {
                Crime crime = mCrimes.get(position);
                return BankAccountFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        for (int i = 0; i < mCrimes.size(); i++)
        {
            if (mCrimes.get(i).getId().equals(crimeId))
            {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}

