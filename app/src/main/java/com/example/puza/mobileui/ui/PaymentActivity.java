package com.example.puza.mobileui.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.CustomSwipeAdapter;

import java.util.List;

public class PaymentActivity extends AppCompatActivity {

    List<Integer> color;
    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_options);

        viewPager = (ViewPager)findViewById(R.id.viewPager);


        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);

    }
}
