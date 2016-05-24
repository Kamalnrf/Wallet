package com.app.kamalnrf.wallet.Controllers.BankAccountCntrollers;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.kamalnrf.wallet.Controllers.DatePickerFragment;
import com.app.kamalnrf.wallet.Controllers.PictureUtils;
import com.app.kamalnrf.wallet.Model.BankAccountModel.Crime;
import com.app.kamalnrf.wallet.Model.BankAccountModel.CrimeLab;
import com.app.kamalnrf.wallet.R;

import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * Created by kamalnrf on 8/4/16.
 */
public class BankAccountFragment extends Fragment
{
    private static final String TAG = "Data";
    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";
    private static final int REQUEST_DATE = 0;
    private static final int REQUEST_PHOTO = 2;
    private EditText mBankName;
    private EditText mNameOnAccount;
    private EditText mAccountType;
    private EditText mRoutingNumber;
    private EditText mAccountNumber;
    private EditText mSwiftCode;
    private EditText mIbanNumber;
    private EditText mPin;
    private EditText mPhone;
    private EditText mAddress;
    private Crime mCrime;
    private File mPhotoFile;
    private EditText mTitleField;
    private Button mDateButton;
    private ImageButton mphotoButton;
    private ImageView mphotoView;

    //Fragment On Create
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);

        mCrime = CrimeLab.get(getActivity()).getCrimeLab(crimeId);
        mPhotoFile = CrimeLab.get(getActivity()).getPhotoFile(mCrime);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        //Wiring up the EditText Widget..

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
                //Takes the input from user and sets it as the title
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

       mBankName = (EditText) v.findViewById(R.id.bank_name);
        mBankName.setText(mCrime.getBankName());
        mBankName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setBankName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNameOnAccount = (EditText) v.findViewById(R.id.name_on_account);
        mNameOnAccount.setText(mCrime.getNameOnContact());
        mNameOnAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setNameOnContact(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mAccountType = (EditText) v.findViewById(R.id.account_type);
        mAccountType.setText(mCrime.getAccountType());
        mAccountType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setAccountType(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRoutingNumber = (EditText) v.findViewById(R.id.routing_number_hint);
        mRoutingNumber.setText(mCrime.getRoutingNumber());
        mRoutingNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setRoutingNumber(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mAccountNumber = (EditText) v.findViewById(R.id.account_number);
        mAccountNumber.setText(mCrime.getAccountNumber());
        mAccountNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setAccountNumber(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSwiftCode = (EditText) v.findViewById(R.id.swift_code);
        mSwiftCode.setText(mCrime.getSWIFTCode());
        mSwiftCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setSWIFTCode(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mIbanNumber = (EditText) v.findViewById(R.id.iban_number);
        mIbanNumber.setText(mCrime.getIBANNumber());
        mIbanNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setIBANNumber(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPin = (EditText) v.findViewById(R.id.pin);
        mPin.setText(mCrime.getPin());
        mPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setPin(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPhone = (EditText) v.findViewById(R.id.phone);
        mPhone.setText(mCrime.getPhone());
        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setPhone(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mAddress = (EditText) v.findViewById(R.id.address);
        mAddress.setText(mCrime.getAddress());
        mAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setAddress(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);;
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstanse(mCrime.getDate());
                dialog.setTargetFragment(BankAccountFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });


        PackageManager packageManager = getActivity().getPackageManager();


       /*mphotoButton = (ImageButton) v.findViewById(R.id.crime_camera);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        boolean canTakePhoto = mPhotoFile != null &&
                captureImage.resolveActivity(packageManager) != null;
        mphotoButton.setEnabled(canTakePhoto);

        if (canTakePhoto)
        {
            Uri uri = Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }

        mphotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        mphotoView = (ImageView) v.findViewById(R.id.crime_photo);
        updatePhotoView();*/



        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode != Activity.RESULT_OK)
        {
            return;
        }

        if (requestCode == REQUEST_DATE)
        {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);

            mCrime.setDate(date);
            updateDate();
        }
        else if (requestCode == REQUEST_PHOTO )
        {
            updatePhotoView();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        CrimeLab.get(getActivity())
                .upDateCrime(mCrime);

    }

    private void updateDate() {
        mDateButton.setText(mCrime.getDate().toString());
    }

    //fragment argument
    public static BankAccountFragment newInstance (UUID crimeId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        BankAccountFragment fragment = new BankAccountFragment();
        fragment.setArguments(args);

        return fragment;
    }


    private void updatePhotoView()
    {
        if (mPhotoFile == null || !mPhotoFile.exists())
        {
            mphotoView.setImageDrawable(null);
        }
        else
        {
            Bitmap bitmap = PictureUtils.getScaleBitMap(
                    mPhotoFile.getPath(), getActivity()
            );
            mphotoView.setImageBitmap(bitmap);
        }
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
                UUID crimeId = mCrime.getId();
                CrimeLab.get(getActivity()).deleteCrime(crimeId);

                Toast.makeText(getActivity(), R.string.toast_delete_crime, Toast.LENGTH_SHORT).show();
                getActivity().finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
