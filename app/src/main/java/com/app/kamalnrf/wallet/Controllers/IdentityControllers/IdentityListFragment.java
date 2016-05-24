package com.app.kamalnrf.wallet.Controllers.IdentityControllers;

import android.content.Intent;
import android.os.Bundle;
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

import com.app.kamalnrf.wallet.Model.BankAccountModel.Identity;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WalletIdentity;
import com.app.kamalnrf.wallet.R;

import java.util.List;

/**
 * Created by kamalnrf on 7/5/16.
 */
public class IdentityListFragment extends Fragment
{
    private RecyclerView mRecyclerView;
    private IdentityAdapter mIdentityAdapter;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Wiring recycler view
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_reycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    private class IdentityHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Identity mIdentity;
        private TextView mTitleTextView;

        public IdentityHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
        }

        //binds the title,date and check box
        public void bindIdentity(Identity identity)
        {
            mIdentity = identity;

            mTitleTextView.setText(mIdentity.getIdentity());

        }

        @Override
        public void onClick(View v)
        {
            Intent intent = IdentityPagerActivity.newIntent(getActivity(), mIdentity.getUUID());
            startActivity(intent);
        }
    }

    private class IdentityAdapter extends  RecyclerView.Adapter<IdentityHolder>
    {
        private List<Identity> mIdentities;

        public IdentityAdapter (List<Identity> identities )
        {
            mIdentities = identities ;
        }

        //This method is called to create a view
        @Override
        public IdentityHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_crime, parent, false);

            return new IdentityHolder(view);
        }


        //binds them together
        @Override
        public void onBindViewHolder(IdentityHolder holder, int position)
        {
            Identity identity = mIdentities.get(position);
            holder.bindIdentity(identity);
        }

        private void setIdentities (List<Identity> identities)
        {
            mIdentities = identities;
        }

        //RecycleView Calls this method to get the size of mCrimes
        @Override
        public int getItemCount() {
            return mIdentities.size();
        }
    }

    public void updateUI()
    {
        WalletIdentity walletIdentity = WalletIdentity.get(getActivity());
        List<Identity> identities = walletIdentity.getIdentity();

        if (mIdentityAdapter == null)
        {
            mIdentityAdapter = new IdentityAdapter(identities);
            mRecyclerView.setAdapter(mIdentityAdapter);
        }
        else
        {
            mIdentityAdapter.setIdentities(identities);
            mIdentityAdapter.notifyDataSetChanged();
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
                Identity identity = new Identity();
                WalletIdentity.get(getActivity()).addIdentity(identity);
                Intent intent = IdentityPagerActivity
                        .newIntent(getActivity(), identity.getUUID());
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
