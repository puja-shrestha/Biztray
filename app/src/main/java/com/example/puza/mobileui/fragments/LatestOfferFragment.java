package com.example.puza.mobileui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui._sliders.FragmentSlider;
import com.example.puza.mobileui._sliders.SliderIndicator;
import com.example.puza.mobileui._sliders.SliderPagerAdapter;
import com.example.puza.mobileui._sliders.SliderView;
import com.example.puza.mobileui.adapter.FeaturedRecycler;
import com.example.puza.mobileui.adapter.PopularRecycler;
import com.example.puza.mobileui.models.FeaturedItems;
import com.example.puza.mobileui.models.MostPopularItems;

import java.util.ArrayList;
import java.util.List;

public class LatestOfferFragment extends Fragment {

    /*-------------------popular Items-------------------*/
    RecyclerView popularRecyclerView;
    private RecyclerView.LayoutManager pLayoutManager;
    PopularRecycler popularAdapter;
    List<MostPopularItems> popularItems;
    /*---------------------------------------------------*/

    public LatestOfferFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lastest_offer, container, false);


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

