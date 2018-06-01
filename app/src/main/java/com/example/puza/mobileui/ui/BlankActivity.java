package com.example.puza.mobileui.ui;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.fragments.MoreItemsfragment;

public class BlankActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

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
                            MoreItemsfragment fragment = new MoreItemsfragment();
                            android.support.v4.app.FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_container, fragment);
                            transaction.commit();

//                Intent intent = new Intent(context, BlankActivity.class);
//                context.startActivity(intent);
            }
        }).start();
    }
}
