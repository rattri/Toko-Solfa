package com.solfashop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.solfashop.ActivityMain;
import com.solfashop.BaseActivity;
import com.solfashop.R;

/**
 * Created by Ratri on 9/30/2016.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener{
    TextView textHome;
    String message;
    Button btnHome, btnOrder, btnPrice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        textHome = (TextView) v.findViewById(R.id.text_home);
        btnHome = (Button) v.findViewById(R.id.btn_home);
        btnOrder = (Button) v.findViewById(R.id.btn_order);
        btnPrice = (Button) v.findViewById(R.id.btn_price);
        textHome.setText(message);

        btnHome.setOnClickListener(homeOnClick());
        btnOrder.setOnClickListener(this);
        btnPrice.setOnClickListener(new priceOnClick("ini ID", 7));

        baseActivity.setBaseFragment(this);/*WAJIB ADA*/

        setTitle("Home");
        return v;
    }

    public static HomeFragment newInstance(String message) {
        HomeFragment fragment = new HomeFragment();
        fragment.message = message;
        return fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_order:
//                action button order click
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_ORDER,"ORDER FRAGMENT");
                break;
//            case R.id.btn_price:
////                action button price click
//                break;
        }
    }
    private View.OnClickListener homeOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_HOME, "ORDER HOME");
            }
        };
    }

    class priceOnClick implements View.OnClickListener{
        String id;
        int order;

        public priceOnClick(String id, int order){
            this.id = id;
            this.order = order;
        }

        @Override
        public void onClick(View view) {
            getBaseActivity().startFragment(BaseActivity.FRAGMENT_PRICELIST, "PriceList FRAGMENT");
        }
    }


}
