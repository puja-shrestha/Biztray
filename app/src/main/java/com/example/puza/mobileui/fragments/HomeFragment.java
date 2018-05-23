package com.example.puza.mobileui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.HomeRecycler;
import com.example.puza.mobileui.models.HomeItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    HomeRecycler adapter;
    Context mContext;
    List<HomeItems> allItems;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.homeRecycler);

        allItems = getAllItemList();

        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new HomeRecycler(getActivity(), allItems);
        recyclerView.setAdapter(adapter);

        return view;
    }


    private List<HomeItems> getAllItemList() {
        allItems = new ArrayList<HomeItems>();


        allItems.add(new HomeItems(R.drawable.one, "Antiques"));
        allItems.add(new HomeItems(R.drawable.two, "Furniture"));
        allItems.add(new HomeItems(R.drawable.one, "Agriculture"));
        allItems.add(new HomeItems(R.drawable.two, "Gems"));

        return allItems;
    }
}
