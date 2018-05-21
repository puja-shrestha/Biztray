package com.example.puza.mobileui.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.CartRecycler;
import com.example.puza.mobileui.models.CartItems;
import com.example.puza.mobileui.ui.PaymentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {
    RecyclerView cartRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    CartRecycler cartAdapter;
    List<CartItems> cartItems;
    Context mContext;
    Button button;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        cartRecyclerView = (RecyclerView) view.findViewById(R.id.cartRecyclerView);

        cartItems = getCartItems();

        cartRecyclerView.setHasFixedSize(true);

        button = (Button)view.findViewById(R.id.continuePayment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PaymentFragment.class);
                startActivity(intent);
            }
        });

        mLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        cartRecyclerView.setLayoutManager(mLayoutManager);
        cartAdapter = new CartRecycler(getActivity(), cartItems);
        cartRecyclerView.setAdapter(cartAdapter);

        return view;
    }

    private List<CartItems> getCartItems() {
        cartItems = new ArrayList<CartItems>();


        cartItems.add(new CartItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new CartItems(R.drawable.two, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));
        cartItems.add(new CartItems(R.drawable.one, "Pashmina Arts, made by Nepal Hand", "$1.99", "Small", "1pic"));

        return cartItems;
    }

}
