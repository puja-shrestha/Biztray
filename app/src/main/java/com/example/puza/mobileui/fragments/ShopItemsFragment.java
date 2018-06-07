package com.example.puza.mobileui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puza.mobileui.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopItemsFragment extends Fragment{

    RatingBar ratingBar;
    TextView value;

    public ShopItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shop_item_layout, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);

        //container that hold the values and integrate them with the spinner
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.unit));
        myAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


        //rating Bar
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        value = (TextView) view.findViewById(R.id.value);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("value is"+ rating);
            }
        });

        return view;
    }

}
