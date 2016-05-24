package com.app.kamalnrf.wallet.Controllers.LicenceControllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.kamalnrf.wallet.Model.BankAccountModel.Licence;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WalletLicence;
import com.app.kamalnrf.wallet.R;

import java.util.List;

/**
 * Created by kamalnrf on 24/5/16.
 */
public class LicenceListFragment extends Fragment
{
    private RecyclerView mLicenceRecyclerView;
    private LicenceAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Wiring recycler view
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mLicenceRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_reycler_view);

        mLicenceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    //Inner class for holder to hold the views
    private class LicenceHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Licence mLicence;
        private TextView mTitleTextView;

        public LicenceHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_licence_title_text_view);
        }

        //binds the title,date and check box
        public void bind(Licence licence)
        {
            mLicence = licence;

            mTitleTextView.setText(mLicence.getmTitle());

        }

        @Override
        public void onClick(View v)
        {
            Intent intent = LicencePagerActivity.newIntent(getActivity(), mLicence.getUUID());
            startActivity(intent);
        }
    }

    private class LicenceAdapter extends  RecyclerView.Adapter<LicenceHolder>
    {
        private List<Licence> mLicence;

        public LicenceAdapter (List<Licence> licences)
        {
            mLicence = licences;
        }

        //This method is called to create a view
        @Override
        public LicenceHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_licence, parent, false);

            return new LicenceHolder(view);
        }

        //binds them together
        @Override
        public void onBindViewHolder(LicenceHolder holder, int position)
        {
            Licence licence = mLicence.get(position);
            holder.bind(licence);
        }

        private void setLicence (List<Licence> licence)
        {
            mLicence = licence;
        }

        //RecycleView Calls this method to get the size of mCrimes
        @Override
        public int getItemCount() {
            return mLicence.size();
        }
    }

    public void updateUI()
    {
        WalletLicence walletLicence = WalletLicence.get(getActivity());
        List<Licence> licences = walletLicence.getLicence();

        if (mAdapter == null)
        {
            mAdapter = new LicenceAdapter(licences);
            mLicenceRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.setLicence(licences);
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.fragment_crime_list, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_item_new_crime:
                Licence licence = new Licence();
                WalletLicence.get(getActivity()).addLicence(licence);
                Intent intent = LicencePagerActivity
                        .newIntent(getActivity(), licence.getUUID());
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
