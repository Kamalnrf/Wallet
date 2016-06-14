package com.app.kamalnrf.wallet.Controllers.BankAccountCntrollers;

//Layer level :- controller

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.app.kamalnrf.wallet.Model.BankAccountModel.Crime;
import com.app.kamalnrf.wallet.Model.BankAccountModel.CrimeLab;
import com.app.kamalnrf.wallet.R;

import java.util.List;

/**
 * Created by kamalnrf on 8/4/16.
 */
public class BankAccountListFragment extends Fragment
{
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Wiring recycler view
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_reycler_view);

        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                Intent intent = BankAccountPagetActivity
                        .newIntent(getActivity(), crime.getId());
                startActivity(intent);
            }
        });

        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
        frameLayout.setBackground(getResources().getDrawable(R.drawable.wallet_main_normal));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    //Inner class for holder to hold the views
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Crime mCrime;
        private TextView mTitleTextView;

        public CrimeHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
        }

        //binds the title,date and check box
        public void bindCrime(Crime crime)
        {
            mCrime = crime;

            mTitleTextView.setText(mCrime.getTitle());

        }

        @Override
        public void onClick(View v)
        {
            Intent intent = BankAccountPagetActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);
        }
    }

    //Recycler view will comunicate with this class when holder is needed to be created
    private class CrimeAdapter extends  RecyclerView.Adapter<CrimeHolder>
    {
        private List<Crime> mCrimes;

        public CrimeAdapter (List<Crime> crime)
        {
            mCrimes = crime;
        }

        //This method is called to create a view
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_crime, parent, false);

            return new CrimeHolder(view);
        }

        //binds them together
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position)
        {
            Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);
        }

        private void setCrimes (List<Crime> crimes)
        {
            mCrimes = crimes;
        }

        //RecycleView Calls this method to get the size of mCrimes
        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

    public void updateUI()
    {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();

        if (mAdapter == null)
        {
            mAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.setCrimes(crimes);
            mAdapter.notifyDataSetChanged();
        }

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
