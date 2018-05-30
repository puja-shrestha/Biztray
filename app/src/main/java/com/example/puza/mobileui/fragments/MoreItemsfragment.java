package com.example.puza.mobileui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.CartRecycler;
import com.example.puza.mobileui.adapter.MoreItemsRecycler;
import com.example.puza.mobileui.models.CartItems;
import com.example.puza.mobileui.models.MoreItems;
import com.example.puza.mobileui.ui.PaymentActivity;

import java.util.ArrayList;
import java.util.List;

public class MoreItemsfragment extends Fragment{

    RecyclerView cartRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    MoreItemsRecycler cartAdapter;
    List<MoreItems> cartItems;
    //private TextView loading;
    ProgressBar mProgressBar;

    public MoreItemsfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_items, container, false);

        cartRecyclerView = (RecyclerView) view.findViewById(R.id.cartRecyclerView);

        mProgressBar = (ProgressBar) view.findViewById(R.id.loading);
        //mProgressBar.setVisibility(View.GONE);
//        loading=(TextView)view.findViewById(R.id.loading);


        cartItems = getCartItems();

        cartRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        cartRecyclerView.setLayoutManager(mLayoutManager);
        cartAdapter = new MoreItemsRecycler(getActivity(), cartItems);
        cartRecyclerView.setAdapter(cartAdapter);

        return view;
    }

    private List<MoreItems> getCartItems() {
        mProgressBar.setVisibility(View.INVISIBLE);
        cartRecyclerView.setVisibility(View.VISIBLE);
        cartItems = new ArrayList<MoreItems>();


        cartItems.add(new MoreItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new MoreItems(R.drawable.two, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new MoreItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));

        cartItems.add(new MoreItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new MoreItems(R.drawable.two, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new MoreItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));

        cartItems.add(new MoreItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new MoreItems(R.drawable.two, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new MoreItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));

        return cartItems;
    }
}
