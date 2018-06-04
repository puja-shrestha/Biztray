package com.example.puza.mobileui.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.models.FeaturedSortItems;

import java.util.List;

public class DecorativeItemRecycler extends RecyclerView.Adapter<DecorativeItemRecycler.MyViewHolder> {

    private List<FeaturedSortItems> itemList;
    Activity context;
//    ImageView deleteIcon;
    AlertDialog myDialog;

    public DecorativeItemRecycler(Activity context, List<FeaturedSortItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView heading, subHeading, price;
        private ImageView image;


        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            heading = (TextView) view.findViewById(R.id.heading);
            subHeading = (TextView) view.findViewById(R.id.subHeading);
            price = (TextView) view.findViewById(R.id.price);

            //delete icon click
//            deleteIcon = (ImageView)view.findViewById(R.id.deleteIcon);
//            deleteIcon.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    //Toast.makeText(context, "icon clicked", Toast.LENGTH_SHORT).show();
//                    Alertdialog();
//                }
//            });
        }
    }

//    public void Alertdialog(){
//
//        myDialog = new AlertDialog.Builder(context).create();
//        myDialog.setTitle("Alert");
//        myDialog.setMessage("Are you sure?");
//        myDialog.setButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        myDialog.show();
//    }


    @Override
    public DecorativeItemRecycler.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.decorative_items, parent, false);
        return new DecorativeItemRecycler.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DecorativeItemRecycler.MyViewHolder holder, int position) {

        final FeaturedSortItems items = itemList.get(position);
        holder.heading.setText(items.getHeading());
        holder.subHeading.setText(items.getSubHeading());
        holder.price.setText(items.getPrice());
        holder.image.setImageResource(items.getImage());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


}

