package com.example.puza.mobileui.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.fragments.FeaturedSortItemFragment;
import com.example.puza.mobileui.models.HomeItems;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeRecycler extends RecyclerView.Adapter<HomeRecycler.MyViewHolder> {

    private List<HomeItems> itemList;
    Activity context;
    ProgressDialog  progressDialog;


    public HomeRecycler(Activity context, List<HomeItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private CircleImageView image;




        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            //progressBar = (ProgressBar)  view.findViewById(R.id.progressBar);

            image = (CircleImageView) view.findViewById(R.id.image);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("Loading..."); // Setting Message
                    progressDialog.setTitle("Please wait"); // Setting Title
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog.show(); // Display Progress Dialog
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();

                            FeaturedSortItemFragment fragment = new FeaturedSortItemFragment();
                            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_container, fragment);
                            transaction.commit();
                        }
                    }).start();
//                    Intent intent = new Intent(context, BlankActivity.class);
//                    context.startActivity(intent);

//                    Intent intent = new Intent(context, MoreItemsfragment.class);
//                    context.startActivity(intent);


//                    Toast.makeTextprogressDialog = new ProgressDialog(MainActivity.this);}
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_home, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final HomeItems items = itemList.get(position);
        holder.name.setText(items.getName());
        holder.image.setImageResource(items.getImage());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


}
