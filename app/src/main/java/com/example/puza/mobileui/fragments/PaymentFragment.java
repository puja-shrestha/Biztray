package com.example.puza.mobileui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.CustomSwipeAdapter;

import java.util.List;

public class PaymentFragment extends Fragment {

    List<Integer> color;
    ViewPager viewPager;
    CustomSwipeAdapter adapter;


    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.payment_options, container, false);


        viewPager = (ViewPager)view.findViewById(R.id.viewPager);


        adapter = new CustomSwipeAdapter(getContext());
        viewPager.setAdapter(adapter);


        return view;
    }

}

