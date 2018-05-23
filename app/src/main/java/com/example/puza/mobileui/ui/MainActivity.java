package com.example.puza.mobileui.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mobileui.R;
import com.example.puza.mobileui.fragments.CartFragment;
import com.example.puza.mobileui.fragments.HomeFragment;
import com.example.puza.mobileui.fragments.MoreFragment;
import com.example.puza.mobileui.fragments.OfferFragment;
import com.example.puza.mobileui.fragments.ProductFragment;
import com.example.puza.mobileui.helper.BottomNavigationHelper;

public class
MainActivity extends AppCompatActivity {
    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;
    FragmentTransaction transaction;
    Toolbar toolbar;
    TextView toolbarTitle;

    private DrawerLayout mDrawerLayout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbarName);

        setSupportActionBar(toolbar);
        setUpBottomNavigation();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        imageView = (ImageView)findViewById(R.id.navigationMenu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else if (mSelectedItem == homeItem.getItemId()) {
            onBackPressed();

        }
    }

    private void setUpBottomNavigation() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.removeShiftMode(mBottomNav);
        if (mBottomNav != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = mBottomNav.getMenu();
            selectFragment(menu.getItem(0));
            mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectFragment(item);
                    return true;
                }
            });
        }

    }

    private void selectFragment(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_home:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HomeFragment());
                toolbarTitle.setText("Home");
                break;
            case R.id.menu_user:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new ProductFragment());
                toolbarTitle.setText("Users");
                break;
            case R.id.menu_offer:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new OfferFragment());
                toolbarTitle.setText("Offers");
                break;
            case R.id.menu_cart:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new CartFragment());
                toolbarTitle.setText("My cart");
                break;
            case R.id.menu_more:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new MoreFragment());
                toolbarTitle.setText("More");
                break;
        }
        transaction.commit();
    }
}