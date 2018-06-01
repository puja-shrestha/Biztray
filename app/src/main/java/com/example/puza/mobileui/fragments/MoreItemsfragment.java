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
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.adapter.CartRecycler;
import com.example.puza.mobileui.adapter.MoreItemsRecycler;
import com.example.puza.mobileui.models.CartItems;
import com.example.puza.mobileui.models.MoreItems;
import com.example.puza.mobileui.ui.MainActivity;
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
    ToggleButton toggleButton;

    Context context;
    TextView textView;
    Button sbutton;
    AlertDialog myDialog;

    public MoreItemsfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_items, container, false);

        cartRecyclerView = (RecyclerView) view.findViewById(R.id.cartRecyclerView);

        toggleButton = (ToggleButton)view.findViewById(R.id.toogle_button);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeVibrateState();
            }
        });
        mProgressBar = (ProgressBar) view.findViewById(R.id.loading);

        //mProgressBar.setVisibility(View.GONE);
//        loading=(TextView)view.findViewById(R.id.loading);

//        mProgressBar.setProgress(25);



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

        sbutton = (Button) view.findViewById(R.id.button_sortby);
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
            cartRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        }
        else
        {
            mLayoutManager = new LinearLayoutManager(
                    getContext(),
                    LinearLayoutManager.VERTICAL,
                    false
            );

            cartRecyclerView.setLayoutManager(mLayoutManager);
        }
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
