package com.solfashop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

import com.solfashop.fragment.BaseFragment;
import com.solfashop.fragment.HomeFragment;
import com.solfashop.fragment.OrderFragment;
import com.solfashop.fragment.PriceFragment;

/**
 * Created by Ratri on 9/30/2016.
 */
public class ActivityMain extends BaseActivity{
    Intent caller;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String id_kategori;
        baseActivity = this;
        caller = getIntent();
        if (caller != null && caller.getExtras() != null){
            currentFragment = caller.getExtras().getInt(KEY_FRAGMENT);
        } else currentFragment = FRAGMENT_HOME;

        FragmentManager manager = getSupportFragmentManager();
        switch (currentFragment){
            case FRAGMENT_HOME:
                manager.beginTransaction().replace(R.id.container, HomeFragment.newInstance("INI HOME")).commit();
                isParrentView = true;
                break;
            case FRAGMENT_ORDER:
                manager.beginTransaction().replace(R.id.container, OrderFragment.newInstance("INI ORDER")).commit();
                isParrentView = false;
                break;
            case FRAGMENT_PRICELIST:
                manager.beginTransaction().replace(R.id.container, PriceFragment.newInstance("INI PRICE")).commit();
                isParrentView = false;
                //id_kategori = caller.getExtras().getString("id");
                break;
        }

        setupToolbar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        if (!isParrentView) {
            toggle.setDrawerIndicatorEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   onBackPressed();
                }
            });
        }
        else toggle.syncState();

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

        }
        return super.onOptionsItemSelected(item);
    }

}
