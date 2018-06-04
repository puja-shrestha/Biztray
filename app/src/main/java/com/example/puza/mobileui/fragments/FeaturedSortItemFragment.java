package com.example.puza.mobileui.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.DecorativeItemRecycler;
import com.example.puza.mobileui.adapter.FeatureItemRecycler;
import com.example.puza.mobileui.models.FeaturedSortItems;
import com.example.puza.mobileui.ui.PaymentActivity;

import java.util.ArrayList;
import java.util.List;

public class FeaturedSortItemFragment extends Fragment {
    RecyclerView featureSortItemRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    FeatureItemRecycler featureItemAdapter;
    DecorativeItemRecycler decorativeItemRecycler;
    List<FeaturedSortItems> featuredSortItems;

//    ProgressBar mProgressBar;
    ToggleButton toggleButton;

    Context context;
    TextView textView;
    TextView sbutton;
    AlertDialog myDialog;
//    Button button;

    public FeaturedSortItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feature_item, container, false);

        featureSortItemRecyclerView = (RecyclerView) view.findViewById(R.id.featuredSortItemRecycler);

        toggleButton = (ToggleButton)view.findViewById(R.id.toogle_button);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeVibrateState();
            }
        });
        //mProgressBar = (ProgressBar) view.findViewById(R.id.loading);

        featuredSortItems = getFeaturedSortItems();

        featureSortItemRecyclerView.setHasFixedSize(true);


//        button = (Button)view.findViewById(R.id.continuePayment);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), PaymentActivity.class);
//                startActivity(intent);
//            }
//        });

        mLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        featureSortItemRecyclerView.setLayoutManager(mLayoutManager);
        featureItemAdapter = new FeatureItemRecycler(getActivity(), featuredSortItems);
        featureSortItemRecyclerView.setAdapter(featureItemAdapter);

        sbutton = (TextView) view.findViewById(R.id.button_sortby);
        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context, "icon clicked", Toast.LENGTH_SHORT).show();
                Alertdialog();

//                Intent intent = new Intent(getContext(), PaymentActivity.class);
//                startActivity(intent);
            }
        });

        return view;
    }

    public void Alertdialog(){

//        myDialog = new AlertDialog.Builder(getContext()).create();
//        myDialog.setTitle("Sort by");
//        myDialog.setMessage("Best Rating");
//
//        myDialog.setButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        myDialog.show();


        final CharSequence[] items = {" Best Rating "," Price up "," Price down "," New "};
        // arraylist to keep the selected items
        final ArrayList seletedItems=new ArrayList();

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Short by");
        builder.setMultiChoiceItems(items, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    // indexSelected contains the index of item (of which checkbox checked)
                    @Override
                    public void onClick(DialogInterface dialog, int indexSelected,
                                        boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            // write your code when user checked the checkbox
                            seletedItems.add(indexSelected);
                        } else if (seletedItems.contains(indexSelected)) {
                            // Else, if the item is already in the array, remove it
                            // write your code when user Uchecked the checkbox
                            seletedItems.remove(Integer.valueOf(indexSelected));
                        }
                    }
                })
                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on OK
                        //  You can write the code  to save the selected item here

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on Cancel

                    }
                });

        myDialog = builder.create();//AlertDialog dialog; create like this outside onClick
        myDialog.show();
    }

    //Toogle
    public void changeVibrateState(){

        boolean checked = toggleButton.isChecked();
        if(checked)
        {
            mLayoutManager = new LinearLayoutManager(
                    getContext(),
                    LinearLayoutManager.VERTICAL,
                    false
            );
            decorativeItemRecycler = new DecorativeItemRecycler(getActivity(), featuredSortItems);
            featureSortItemRecyclerView.setAdapter(decorativeItemRecycler);
            featureSortItemRecyclerView.setLayoutManager(mLayoutManager);

        }
        else
        {
            mLayoutManager = new LinearLayoutManager(
                    getContext(),
                    LinearLayoutManager.VERTICAL,
                    false
            );
            featureSortItemRecyclerView.setLayoutManager(mLayoutManager);
            featureItemAdapter = new FeatureItemRecycler(getActivity(), featuredSortItems);
            featureSortItemRecyclerView.setAdapter(featureItemAdapter);        }
    }



    private List<FeaturedSortItems> getFeaturedSortItems() {
        featuredSortItems = new ArrayList<FeaturedSortItems>();

        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));
        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));
        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));

        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));
        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));
        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));

        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));
        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));
        featuredSortItems.add(new FeaturedSortItems(R.drawable.two, "Decorative art", "Decoration", "Rs. 1700"));

        return featuredSortItems;
    }

}

