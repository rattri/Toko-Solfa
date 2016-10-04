package com.solfashop.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solfashop.R;

/**
 * Created by Ratri on 9/29/2016.
 */
public class GameFragments extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle SavedInstanceState){
        View v = inflater.inflate(R.layout.content_main, container, false);
        return v;
    }
}