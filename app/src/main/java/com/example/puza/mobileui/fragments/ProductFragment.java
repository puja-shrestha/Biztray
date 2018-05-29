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
import android.widget.ImageView;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.FeaturedRecycler;
import com.example.puza.mobileui.adapter.HomeRecycler;
import com.example.puza.mobileui.adapter.PopularRecycler;
import com.example.puza.mobileui.models.FeaturedItems;
import com.example.puza.mobileui.models.HomeItems;
import com.example.puza.mobileui.models.MostPopularItems;
import com.example.puza.mobileui.ui.LoginActivity;
import com.example.puza.mobileui.ui.MainActivity;
import com.example.puza.mobileui.ui.PaymentActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    /*---------------featured items----------------------*/
    RecyclerView featuredRecyclerView;
    private RecyclerView.LayoutManager fLayoutManager;
    FeaturedRecycler featuredAdapter;
    List<FeaturedItems> featuredItems;
    /*---------------------------------------------------*/

    /*-------------------popular Items-------------------*/
    RecyclerView popularRecyclerView;
    private RecyclerView.LayoutManager pLayoutManager;
    PopularRecycler popularAdapter;
    List<MostPopularItems> popularItems;
    /*---------------------------------------------------*/

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        /*------------------Featured Items--------------------------*/
        featuredRecyclerView = (RecyclerView) view.findViewById(R.id.featuredRecycler);

        featuredItems = getFeaturedItems();

        featuredRecyclerView.setHasFixedSize(true);

        fLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        featuredRecyclerView.setLayoutManager(fLayoutManager);
        featuredAdapter = new FeaturedRecycler(getActivity(), featuredItems);
        featuredRecyclerView.setAdapter(featuredAdapter);

        /*------------------------------------------------------------*/

        /*-------------Most popular Items-----------------------------*/

        popularRecyclerView = (RecyclerView) view.findViewById(R.id.popularRecycler);

        popularItems = getPopularItems();

        popularRecyclerView.setHasFixedSize(true);

        pLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        popularRecyclerView.setLayoutManager(pLayoutManager);
        popularAdapter = new PopularRecycler(getActivity(), popularItems);
        popularRecyclerView.setAdapter(popularAdapter);
        /*------------------------------------------------------------*/

        return view;
    }

    private List<FeaturedItems> getFeaturedItems() {
        featuredItems = new ArrayList<FeaturedItems>();


        featuredItems.add(new FeaturedItems(R.drawable.one, "Pashmina Arts", "$10.00"));
        featuredItems.add(new FeaturedItems(R.drawable.two, "Pashmina Arts", "$10.00"));
        featuredItems.add(new FeaturedItems(R.drawable.one, "Pashmina Arts", "$10.00"));
        featuredItems.add(new FeaturedItems(R.drawable.two, "Pashmina Arts", "$10.00"));
        featuredItems.add(new FeaturedItems(R.drawable.one, "Pashmina Arts", "$10.00"));
        featuredItems.add(new FeaturedItems(R.drawable.two, "Pashmina Arts", "$10.00"));

        return featuredItems;
    }

    private List<MostPopularItems> getPopularItems() {
        popularItems = new ArrayList<MostPopularItems>();


        popularItems.add(new MostPopularItems(R.drawable.one, "Pashmina Arts", "$10.00"));
        popularItems.add(new MostPopularItems(R.drawable.two, "Pashmina Arts", "$10.00"));
        popularItems.add(new MostPopularItems(R.drawable.one, "Pashmina Arts", "$10.00"));
        popularItems.add(new MostPopularItems(R.drawable.two, "Pashmina Arts", "$10.00"));
        popularItems.add(new MostPopularItems(R.drawable.one, "Pashmina Arts", "$10.00"));
        popularItems.add(new MostPopularItems(R.drawable.two, "Pashmina Arts", "$10.00"));

        return popularItems;
    }

}
