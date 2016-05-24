package com.app.kamalnrf.wallet.Controllers.WireLessController;

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

import com.app.kamalnrf.wallet.Model.BankAccountModel.WalletWirelessRouter;
import com.app.kamalnrf.wallet.Model.BankAccountModel.WirelessRouter;
import com.app.kamalnrf.wallet.R;

import java.util.List;

/**
 * Created by kamalnrf on 8/5/16.
 */
public class WirelessRouterListFragment extends Fragment
{
    private RecyclerView mCrimeRecyclerView;
    private WirelessAdapter mAdapter;

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

        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_reycler_view);

        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    //Inner class for holder to hold the views
    private class WireLessHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private WirelessRouter mWirelessRouter;
        private TextView mTitleTextView;

        public WireLessHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
        }

        //binds the title,date and check box
        public void bindCrime(WirelessRouter wirelessRouter)
        {
            mWirelessRouter = wirelessRouter;

            mTitleTextView.setText(mWirelessRouter.getWirelessRouter());

        }

        @Override
        public void onClick(View v)
        {
           Intent intent = WirelessRouterPagerActivity.newIntent(getActivity(), mWirelessRouter.getUUID());
            startActivity(intent);
        }
    }

    //Recycler view will comunicate with this class when holder is needed to be created
    private class WirelessAdapter extends  RecyclerView.Adapter<WireLessHolder>
    {
        private List<WirelessRouter> mWirelessRouters;

        public WirelessAdapter (List<WirelessRouter> wirelessRouters)
        {
            mWirelessRouters = wirelessRouters;
        }

        //This method is called to create a view
        @Override
        public WireLessHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_crime, parent, false);

            return new WireLessHolder(view);
        }

        //binds them together
        @Override
        public void onBindViewHolder(WireLessHolder holder, int position)
        {
            WirelessRouter wirelessRouter = mWirelessRouters.get(position);
            holder.bindCrime(wirelessRouter);
        }

        private void setCrimes (List<WirelessRouter> wirelessRouters)
        {
            mWirelessRouters = wirelessRouters;
        }

        //RecycleView Calls this method to get the size of mCrimes
        @Override
        public int getItemCount() {
            return mWirelessRouters.size();
        }
    }

    public void updateUI()
    {
        WalletWirelessRouter walletWirelessRouter = WalletWirelessRouter.get(getActivity());
        List<WirelessRouter> walletWirelessRouters = walletWirelessRouter.getWirelessRouter();

        if (mAdapter == null)
        {
            mAdapter = new WirelessAdapter(walletWirelessRouters);
            mCrimeRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.setCrimes(walletWirelessRouters);
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
                 WirelessRouter wirelessRouter = new WirelessRouter();
                WalletWirelessRouter.get(getActivity()).addWireless(wirelessRouter);
                Intent intent = WirelessRouterPagerActivity
                        .newIntent(getActivity(), wirelessRouter.getUUID());
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
