//package com.example.puza.mobileui.adapter;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.puza.mobileui.R;
//
//import java.util.List;
//
//public class MoreItemsRecycler extends RecyclerView.Adapter<MoreItemsRecycler.MyViewHolder> {
//
//    private List<MoreItems> itemList;
//    Activity context;
//    ImageView deleteIcon;
//    AlertDialog myDialog;
//
//    TextView textView;
//
//    public MoreItemsRecycler(Activity context, List<MoreItems> itemList) {
//        this.itemList = itemList;
//        this.context = context;
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        private TextView name, price, quantity, size;
//        private ImageView image;
//
//
//        public MyViewHolder(View view) {
//            super(view);
//
//            name = (TextView) view.findViewById(R.id.name);
//            quantity = (TextView) view.findViewById(R.id.quantity);
//            size = (TextView) view.findViewById(R.id.size);
//            price = (TextView) view.findViewById(R.id.price);
//            image = (ImageView) view.findViewById(R.id.image);
//
//            //delete icon click
//            deleteIcon = (ImageView)view.findViewById(R.id.deleteIcon);
//            deleteIcon.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    //Toast.makeText(context, "icon clicked", Toast.LENGTH_SHORT).show();
//                    Alertdialog();
//                }
//            });
//        }
//    }
//
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
//
//    @Override
//    public MoreItemsRecycler.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.more_items, parent, false);
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MoreItemsRecycler.MyViewHolder holder, int position) {
//
//        final MoreItems items = itemList.get(position);
//        holder.name.setText(items.getName());
//        holder.price.setText(items.getPrice());
//        holder.quantity.setText(items.getQuantity());
//        holder.size.setText(items.getSize());
//        holder.image.setImageResource(items.getImage());
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.itemList.size();
//    }
//}
