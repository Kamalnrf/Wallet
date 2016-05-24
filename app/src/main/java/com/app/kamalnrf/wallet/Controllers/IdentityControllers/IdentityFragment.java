package com.app.kamalnrf.wallet.Controllers.IdentityControllers;

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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.kamalnrf.wallet.Controllers.PictureUtils;
import com.app.kamalnrf.wallet.Model.BankAccountModel.Identity;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WalletIdentity;
import com.app.kamalnrf.wallet.R;

import java.io.File;
import java.util.UUID;

/**
 * Created by kamalnrf on 7/5/16.
 */
public class IdentityFragment extends Fragment
{

    private static final int REQUEST_PHOTO = 2;
    private static final String ARG_CRIME_ID = "identity_id";
    private Identity mIdentity;
    private File mPhotoFile;
    private ImageView mPhotView;
    private ImageButton mPhotoButton;
    private EditText mIdentity1;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mSex;
    private EditText mBirthDate;
    private EditText mOccupation;
    private EditText mCompany;
    private EditText mDepartment;
    private EditText mJobTitle;
    private EditText mStreet;
    private EditText mCity;
    private EditText mZip;
    private EditText mProvince;
    private EditText mCountry;
    private EditText mHomePhone;
    private EditText mCellPhone;
    private EditText mBussinessPhone;
    private EditText mUserName;
    private EditText mReminderQuestion;
    private EditText mReminderAnswer;
    private EditText mEmail;
    private EditText mWebSite;
    private EditText mICQ;
    private EditText mSkype;
    private EditText mForumSignature;


    public static IdentityFragment newInstance (UUID crimeId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        IdentityFragment fragment = new IdentityFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        UUID uuid = (UUID) getArguments().getSerializable(ARG_CRIME_ID);

        mIdentity = WalletIdentity.get(getActivity()).getWalletIdentity(uuid);
        mPhotoFile = WalletIdentity.get(getActivity()).getPhotoFile(mIdentity);

        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_identity, container, false);

        mIdentity1 = (EditText) v.findViewById(R.id.crime_title);
        mIdentity1.setText(mIdentity.getIdentity());
        mIdentity1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setIdentity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mFirstName = (EditText) v.findViewById(R.id.first_name);
        mFirstName.setText(mIdentity.getFirstName());
        mFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mLastName = (EditText) v.findViewById(R.id.last_name);
        mLastName.setText(mIdentity.getLastName());
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mSex = (EditText) v.findViewById(R.id.sex);
        mSex.setText(mIdentity.getSex());
        mSex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setSex(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBirthDate = (EditText) v.findViewById(R.id.birth_date);
        mBirthDate.setText(mIdentity.getBirthDate());
        mBirthDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setBirthDate(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mOccupation = (EditText) v.findViewById(R.id.occupation);
        mOccupation.setText(mIdentity.getOccupation());
        mOccupation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setOccupation(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mCompany = (EditText) v.findViewById(R.id.company);
        mCompany.setText(mIdentity.getCompany());
        mCompany.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setCompany(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDepartment = (EditText) v.findViewById(R.id.department);
        mDepartment.setText(mIdentity.getDepartMent());
        mDepartment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setDepartMent(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mJobTitle = (EditText) v.findViewById(R.id.job_title);
        mJobTitle.setText(mIdentity.getJobTitle());
        mJobTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setJobTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mStreet = (EditText) v.findViewById(R.id.street);
        mStreet.setText(mIdentity.getStreet());
        mStreet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setStreet(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mCity = (EditText) v.findViewById(R.id.city);
        mCity.setText(mIdentity.getCity());
        mCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setCity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mZip = (EditText) v.findViewById(R.id.zip);
        mZip.setText(mIdentity.getZip());
        mZip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setZip(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mProvince = (EditText) v.findViewById(R.id.province);
        mProvince.setText(mIdentity.getProvince());
        mProvince.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setProvince(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mCountry = (EditText) v.findViewById(R.id.country);
        mCountry.setText(mIdentity.getCountry());
        mCountry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setCountry(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mHomePhone = (EditText) v.findViewById(R.id.home);
        mHomePhone.setText(mIdentity.getHomePhone());
        mHomePhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setHomePhone(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mUserName = (EditText) v.findViewById(R.id.user_name);
        mUserName.setText(mIdentity.getUserName());
        mUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setUserName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mCellPhone = (EditText) v.findViewById(R.id.cell_phone);
        mCellPhone.setText(mIdentity.getCellPhone());
        mCellPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setCellPhone(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBussinessPhone = (EditText) v.findViewById(R.id.bussiness_phone);
        mBussinessPhone.setText(mIdentity.getBussinessPhone());
        mBussinessPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setBussinessPhone(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mReminderQuestion = (EditText) v.findViewById(R.id.reminder_question);
        mReminderQuestion.setText(mIdentity.getReminderQuestion());
        mReminderQuestion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setReminderQuestion(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mReminderAnswer = (EditText) v.findViewById(R.id.reminder_answer);
        mReminderAnswer.setText(mIdentity.getReminderAnswer());
        mReminderAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setReminderAnswer(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEmail = (EditText) v.findViewById(R.id.email);
        mEmail.setText(mIdentity.getEmail());
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mWebSite = (EditText) v.findViewById(R.id.web_site);
        mWebSite.setText(mIdentity.getWebSite());
        mWebSite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setWebSite(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mICQ = (EditText) v.findViewById(R.id.icq);
        mICQ.setText(mIdentity.getICQ());
        mICQ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setICQ(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mSkype = (EditText) v.findViewById(R.id.skype);
        mSkype.setText(mIdentity.getSkype());
        mSkype.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mIdentity.setSkype(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mForumSignature = (EditText) v.findViewById(R.id.forum_signature);
        mForumSignature.setText(mIdentity.getForumSignature());
        mForumSignature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mIdentity.setForumSignature(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        PackageManager packageManager = getActivity().getPackageManager();


       /* mPhotoButton = (ImageButton) v.findViewById(R.id.crime_camera);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        boolean canTakePhoto = mPhotoFile != null &&
                captureImage.resolveActivity(packageManager) != null;
        mPhotoButton.setEnabled(canTakePhoto);

        if (canTakePhoto)
        {
            Uri uri = Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }

        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        mPhotView = (ImageView) v.findViewById(R.id.crime_photo);
        updatePhotoView(); */


        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK)
        {
            return;
        }


        else if (requestCode == REQUEST_PHOTO )
        {
            updatePhotoView();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        WalletIdentity.get(getActivity())
                .upDateIdentity(mIdentity);

    }
    private void updatePhotoView()
    {
        if (mPhotoFile == null || !mPhotoFile.exists())
        {
            mPhotoButton.setImageDrawable(null);
        }
        else
        {
            Bitmap bitmap = PictureUtils.getScaleBitMap(
                    mPhotoFile.getPath(), getActivity()
            );
            mPhotView.setImageBitmap(bitmap);
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
                UUID uuid = mIdentity.getUUID();
                WalletIdentity.get(getActivity()).deleteCrime(uuid);

                Toast.makeText(getActivity(), R.string.toast_delete_crime, Toast.LENGTH_SHORT).show();
                getActivity().finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
