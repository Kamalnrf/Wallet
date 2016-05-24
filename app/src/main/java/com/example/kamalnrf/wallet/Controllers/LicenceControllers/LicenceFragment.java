package com.example.kamalnrf.wallet.Controllers.LicenceControllers;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kamalnrf.wallet.Model.BankAccountModel.Licence;
import com.example.kamalnrf.wallet.Model.BankAccountModel.WalletLicence;
import com.example.kamalnrf.wallet.Model.BankAccountModel.WalletWirelessRouter;
import com.example.kamalnrf.wallet.Model.BankAccountModel.WirelessRouter;
import com.example.kamalnrf.wallet.R;

import java.io.File;
import java.util.UUID;

/**
 * Created by kamalnrf on 24/5/16.
 */
public class LicenceFragment extends Fragment
{
    private static final String ARG_ID = "licence_id";
    private static final int REQUEST_PHOTO = 2;
    private Licence mLicence;
    private File mPhotoFile;
    private ImageView mphotoView;
    private ImageButton mphotoButton;
    private EditText mTitle;
    private EditText mFullName;
    private EditText mAddress;
    private EditText mDate;
    private EditText mSex;
    private EditText mHeight;
    private EditText mNumber;
    private EditText mState;
    private EditText mCountry;
    private EditText mExDate;
    private EditText mLicenceClass;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        UUID uuid = (UUID) getArguments().getSerializable(ARG_ID);

        mLicence = WalletLicence.get(getActivity()).getWalletLicence(uuid);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_licence, container, false);

        PackageManager packageManager = getActivity().getPackageManager();

        mTitle = (EditText) v.findViewById(R.id.crime_title);
        mTitle.setText(mLicence.getmTitle());
        mTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mFullName = (EditText) v.findViewById(R.id.full_name);
        mFullName.setText(mLicence.getFullName());
        mFullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setFullName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mAddress = (EditText) v.findViewById(R.id.address);
        mAddress.setText(mLicence.getAddress());
        mAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mDate = (EditText) v.findViewById(R.id.birth_date);
        mDate.setText(mLicence.getDateOfBirth());
        mDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setDateOfBirth(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mSex = (EditText) v.findViewById(R.id.sex);
        mSex.setText(mLicence.getSex());
        mSex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setSex(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mHeight = (EditText) v.findViewById(R.id.height);
        mHeight.setText(mLicence.getHeight());
        mHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setHeight(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mNumber = (EditText) v.findViewById(R.id.number);
        mNumber.setText(mLicence.getHeight());
        mNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mLicenceClass = (EditText) v.findViewById(R.id.licence_class);
        mLicenceClass.setText(mLicence.getLicenceClass());
        mLicenceClass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setLicenceClass(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mState = (EditText) v.findViewById(R.id.province);
        mState.setText(mLicence.getState());
        mState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setState(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mCountry = (EditText) v.findViewById(R.id.country);
        mCountry.setText(mLicence.getCountry());
        mCountry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setCountry(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        mExDate = (EditText) v.findViewById(R.id.expiry_date);
        mExDate.setText(mLicence.getExpiryDate());
        mExDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLicence.setExpiryDate(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK)
        {
            return;
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();

        WalletLicence.get(getActivity())
                .upDateLicence(mLicence);
    }

    //fragment argument
    public static LicenceFragment newInstance (UUID uuid)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, uuid);

        LicenceFragment fragment = new LicenceFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.fragment_delete, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.delete_crime_action:
                UUID id = mLicence.getUUID();
                WalletLicence.get(getActivity()).deleteCrime(id);

                Toast.makeText(getActivity(), R.string.toast_delete_crime, Toast.LENGTH_SHORT).show();
                getActivity().finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
