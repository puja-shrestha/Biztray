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
import android.widget.LinearLayout;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui._sliders.FragmentSlider;
import com.example.puza.mobileui._sliders.SliderIndicator;
import com.example.puza.mobileui._sliders.SliderPagerAdapter;
import com.example.puza.mobileui._sliders.SliderView;
import com.example.puza.mobileui.adapter.FeaturedRecycler;
import com.example.puza.mobileui.adapter.HomeRecycler;
import com.example.puza.mobileui.adapter.PopularRecycler;
import com.example.puza.mobileui.models.FeaturedItems;
import com.example.puza.mobileui.models.HomeItems;
import com.example.puza.mobileui.models.MostPopularItems;

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

    //slider
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;



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

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //slider
        sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();


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


    //slider
    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }


    private List<HomeItems> getAllItemList() {
        allItems = new ArrayList<HomeItems>();


        allItems.add(new HomeItems(R.drawable.one, "Antiques"));
        allItems.add(new HomeItems(R.drawable.two, "Furniture"));
        allItems.add(new HomeItems(R.drawable.one, "Agriculture"));
        allItems.add(new HomeItems(R.drawable.two, "Gems"));
        allItems.add(new HomeItems(R.drawable.one, "Antiques"));
        allItems.add(new HomeItems(R.drawable.two, "Furniture"));
        allItems.add(new HomeItems(R.drawable.one, "Agriculture"));
        allItems.add(new HomeItems(R.drawable.two, "Gems"));

        return allItems;
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
