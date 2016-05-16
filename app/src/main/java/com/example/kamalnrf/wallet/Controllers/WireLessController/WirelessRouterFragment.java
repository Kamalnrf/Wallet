package com.example.kamalnrf.wallet.Controllers.WireLessController;

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

import com.example.kamalnrf.wallet.Controllers.PictureUtils;
import com.example.kamalnrf.wallet.Model.BankAccountModel.WalletWirelessRouter;
import com.example.kamalnrf.wallet.Model.BankAccountModel.WirelessRouter;
import com.example.kamalnrf.wallet.R;

import java.io.File;
import java.util.UUID;

/**
 * Created by kamalnrf on 8/5/16.
 */
public class WirelessRouterFragment extends Fragment
{
    private static final String ARG_ID = "wireless_id";
    private static final int REQUEST_PHOTO = 2;
    private WirelessRouter mWirelessRouters;
    private File mPhotoFile;
    private ImageView mphotoView;
    private ImageButton mphotoButton;
    private EditText mTitleField;
    private EditText mBaseStationName;
    private EditText mBaseStationPassword;
    private EditText mServer;
    private EditText mAirPort;
    private EditText mNetWorkName;
    private EditText mWirelessNetworkSecurity;
    private EditText mWirelessNetworkPassword;
    private EditText mWirlessStoragePassword;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        UUID uuid = (UUID) getArguments().getSerializable(ARG_ID);

        mWirelessRouters = WalletWirelessRouter.get(getActivity()).getWirelessRouter(uuid);
        mPhotoFile = WalletWirelessRouter.get(getActivity()).getPhotoFile(mWirelessRouters);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_wireless, container, false);

        PackageManager packageManager = getActivity().getPackageManager();

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mWirelessRouters.getWirelessRouter());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
                mWirelessRouters.setWirelessRouter(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mBaseStationName = (EditText) v.findViewById(R.id.base_station_name);
        mBaseStationName.setText(mWirelessRouters.getBaseStationName());
        mBaseStationName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
               mWirelessRouters.setBaseStationName(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mBaseStationPassword = (EditText) v.findViewById(R.id.base_station_password);
        mBaseStationPassword.setText(mWirelessRouters.getBaseStationPassword());
        mBaseStationPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWirelessRouters.setBaseStationPassword(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mServer = (EditText) v.findViewById(R.id.server);
        mServer.setText(mWirelessRouters.getServer());
        mServer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
               mWirelessRouters.setServer(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mAirPort = (EditText) v.findViewById(R.id.airport_id);
        mAirPort.setText(mWirelessRouters.getAirPort());
        mAirPort.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
               mWirelessRouters.setAirPort(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mNetWorkName = (EditText) v.findViewById(R.id.network_name);
        mNetWorkName.setText(mWirelessRouters.getNetWorkName());
        mNetWorkName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
                //Takes the input from user and sets it as the title
                mWirelessRouters.setNetWorkName(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mWirelessNetworkSecurity = (EditText) v.findViewById(R.id.wireless_security);
        mWirelessNetworkSecurity.setText(mWirelessRouters.getWireLessSecurity());
        mWirelessNetworkSecurity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
                //Takes the input from user and sets it as the title
                mWirelessRouters.setWireLessSecurity(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mWirelessNetworkPassword = (EditText) v.findViewById(R.id.wireless_network);
        mWirelessNetworkPassword.setText(mWirelessRouters.getWirelessNetworkPassword());
        mWirelessNetworkPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
                //Takes the input from user and sets it as the title
                mWirelessRouters.setWirelessNetworkPassword(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });

        mWirlessStoragePassword = (EditText) v.findViewById(R.id.wireless_storage_password);
        mWirlessStoragePassword.setText(mWirelessRouters.getWirelessStoragePasssword());
        mWirlessStoragePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged
                    (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged
                    (CharSequence s, int start, int before, int count) {
                //Takes the input from user and sets it as the title
                mWirelessRouters.setWirelessStoragePasssword(s.toString());
            }

            @Override
            public void afterTextChanged
                    (Editable s) {

            }
        });


       /* mphotoButton = (ImageButton) v.findViewById(R.id.crime_camera);
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
        updatePhotoView(); */



        return v;
    }

        @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
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
    public void onPause()
    {
        super.onPause();

        WalletWirelessRouter.get(getActivity())
                .upDateWireless(mWirelessRouters);
    }


    //fragment argument
    public static WirelessRouterFragment newInstance (UUID crimeId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, crimeId);

        WirelessRouterFragment fragment = new WirelessRouterFragment();
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
                UUID wirelessId = mWirelessRouters.getUUID();
                WalletWirelessRouter.get(getActivity()).deleteWirless(wirelessId);

                Toast.makeText(getActivity(), R.string.toast_delete_crime, Toast.LENGTH_SHORT).show();
                getActivity().finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
