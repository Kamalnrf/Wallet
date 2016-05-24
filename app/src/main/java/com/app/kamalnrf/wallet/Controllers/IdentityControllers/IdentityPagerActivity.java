package com.app.kamalnrf.wallet.Controllers.IdentityControllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.kamalnrf.wallet.Model.BankAccountModel.Identity;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WalletIdentity;
import com.app.kamalnrf.wallet.R;

import java.util.List;
import java.util.UUID;

/**
 * Created by kamalnrf on 7/5/16.
 */
public class IdentityPagerActivity extends AppCompatActivity
{
    private static final String EXTRA_ID = "com.example.kamalnrf.wallet.Controllers.IdentityControllers";
    private ViewPager mViewPager;
    private List<Identity> mIdentities;

    public static Intent newIntent (Context packageContext, UUID uuid)
    {
        Intent intent = new Intent(packageContext, IdentityPagerActivity.class);
        intent.putExtra(EXTRA_ID, uuid);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_identity_pager);

        //Adapters for view pager
        mViewPager = (ViewPager) findViewById(R.id.identity_view_pager);

        mIdentities = WalletIdentity.get(this).getIdentity();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Identity identity = mIdentities.get(position);
                return IdentityFragment.newInstance(identity.getUUID());
            }

            @Override
            public int getCount() {
                return mIdentities.size();
            }
        });

        UUID uuid = (UUID) getIntent().getSerializableExtra(EXTRA_ID);

        for (int i = 0; i < mIdentities.size(); i++)
        {
            if (mIdentities.get(i).getUUID().equals(uuid))
            {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
