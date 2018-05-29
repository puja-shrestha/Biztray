package com.example.puza.mobileui.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.fragments.ShopItemsFragment;
import com.example.puza.mobileui.models.MostPopularItems;

import java.util.List;

public class PopularRecycler extends RecyclerView.Adapter<PopularRecycler.MyViewHolder> {

    private List<MostPopularItems> itemList;
    Activity context;


    public PopularRecycler(Activity context, List<MostPopularItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, price;
        private ImageView image;
        private CardView cardView;


        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);
            image = (ImageView) view.findViewById(R.id.image);

            cardView = (CardView) view.findViewById(R.id.dateRecycler);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_products, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final MostPopularItems items = itemList.get(position);
        holder.name.setText(items.getName());
        holder.price.setText(items.getPrice());
        holder.image.setImageResource(items.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transport("card");
            }
        });
    }

    @Override
    public int getItemCount() {

        return this.itemList.size();
    }

    private void transport(String fragmentName){
        Fragment fragment = null;
        FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();

        switch (fragmentName) {
            case "card":
                fragment = new ShopItemsFragment();
                break;
        }

        if (fragment != null){
            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).addToBackStack(null).commit();
        }
    }
}
