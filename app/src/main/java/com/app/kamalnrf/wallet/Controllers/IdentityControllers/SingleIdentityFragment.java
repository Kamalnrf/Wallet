package com.app.kamalnrf.wallet.Controllers.IdentityControllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.app.kamalnrf.wallet.R;

/**
 * Created by kamalnrf on 7/5/16.
 */
public abstract class SingleIdentityFragment extends AppCompatActivity
{
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //restores the data from savedInstanceState...
        super.onCreate(savedInstanceState);

        //Displays the content in activity_fragment.xmlxml ..
        setContentView(R.layout.identity_fragment);

        //Calling FragmentManager to add fragments into activity code..
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_identity);

        /*
        CrimeFragment is a controller that interacts with model and view objects.
        Its job is to present the details of a specific crime and update those
        details as the user changes them.
         */

        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_identity, fragment)
                    .commit();
        }
    }
}
