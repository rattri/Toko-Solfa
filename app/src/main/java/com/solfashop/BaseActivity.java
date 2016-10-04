package com.solfashop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.solfashop.fragment.BaseFragment;

/**
 * Created by Ratri on 9/30/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static final int FRAGMENT_HOME = 0;
    public static final int FRAGMENT_ORDER = 1;
    public static final int FRAGMENT_PRICELIST = 2;
    public static final String KEY_FRAGMENT = "solfa.fragment";
    protected int currentFragment = FRAGMENT_HOME;
    public static BaseActivity baseActivity;
    public BaseFragment fragment;
    public Toolbar toolbar;
    public NavigationView navigationView;
    DrawerLayout drawer;
    public boolean isParrentView = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    protected void setupNavabar() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);

    }

    public static BaseActivity getBaseActivity() {
        return baseActivity;
    }

    public void startFragment(int TYPE, String judul) {
        Intent i = new Intent(this, ActivityMain.class);
        i.putExtra(KEY_FRAGMENT, TYPE);
        i.putExtra("judul", judul);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))drawer.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void setBaseFragment(BaseFragment fragment){
        this.fragment = fragment;
    }
}
