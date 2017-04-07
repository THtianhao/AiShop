package com.jarvis.mytaobao.cart;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvis.mytaobao.Data.Data;
import com.jarvis.mytaobao.home.BabyActivity;
import com.jarvis.mytaobaotest.R;
import com.javis.Adapter.Adapter_ListView_cart;
import com.javis.Adapter.Adapter_ListView_cart.onCheckedChanged;
import com.javis.mytools.IBtnCallListener;


@SuppressLint("ValidFragment")
public class AllBaby_F extends Fragment implements IBtnCallListener, onCheckedChanged, OnClickListener {
    IBtnCallListener btnCallListener;
    private TextView tv_goShop, tv_cart_Allprice, tv_cart_buy_Ordel;
    private LinearLayout ll_cart;
    private ListView listView_cart;
    private CheckBox cb_cart_all;
    private Adapter_ListView_cart adapter;
    private String str_del = "(0)";
    private boolean[] is_choice;

    public AllBaby_F(String del) {
        str_del = del;
    }

    public AllBaby_F() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        is_choice = new boolean[Data.arrayList_cart.size()];
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.cart_all_f, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv_goShop = (TextView) view.findViewById(R.id.tv_goShop);
        tv_cart_Allprice = (TextView) view.findViewById(R.id.tv_cart_Allprice);
        tv_cart_buy_Ordel = (TextView) view.findViewById(R.id.tv_cart_buy_or_del);
        tv_cart_buy_Ordel.setText(str_del);
        cb_cart_all = (CheckBox) view.findViewById(R.id.cb_cart_all);

        cb_cart_all.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {


                int isChoice_all = 0;
                if (arg1) {

                    for (int i = 0; i < Data.arrayList_cart.size(); i++) {

                        ((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).setChecked(true);
                    }
                } else {

                    for (int i = 0; i < Data.arrayList_cart.size(); i++) {

                        if (((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).isChecked()) {

                            isChoice_all += 1;
                        }
                    }

                    if (isChoice_all == Data.arrayList_cart.size()) {

                        for (int i = 0; i < Data.arrayList_cart.size(); i++) {

                            ((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).setChecked(false);
                        }
                    }
                }
            }
        });


        ll_cart = (LinearLayout) view.findViewById(R.id.ll_cart);
        listView_cart = (ListView) view.findViewById(R.id.listView_cart);

        if (Data.arrayList_cart != null && Data.arrayList_cart.size() != 0) {
            adapter = new Adapter_ListView_cart(getActivity(), Data.arrayList_cart);
            adapter.setOnCheckedChanged(this);
            listView_cart.setAdapter(adapter);
            ll_cart.setVisibility(View.GONE);
        } else {
            ll_cart.setVisibility(View.VISIBLE);
        }

        listView_cart.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent = new Intent(getActivity(), BabyActivity.class);
                startActivity(intent);
            }
        });


        tv_cart_buy_Ordel.setOnClickListener(this);
        tv_goShop.setOnClickListener(this);
    }


    @Override
    public void onAttach(Activity activity) {
        btnCallListener = (IBtnCallListener) activity;

        super.onAttach(activity);
    }

    @Override
    public void transferMsg() {

        System.out.println("");
    }

    @Override
    public void getChoiceData(int position, boolean isChoice) {
        if (isChoice) {
            if (Data.arrayList_cart.size() != 0) {
                Data.Allprice_cart += Float.valueOf(Data.arrayList_cart.get(position).get("num").toString()) * 49;
            }
        } else {
            if (Data.arrayList_cart.size() != 0) {
                Data.Allprice_cart -= Float.valueOf(Data.arrayList_cart.get(position).get("num").toString()) * 49;
            }
        }
        int num_choice = 0;
        for (int i = 0; i < Data.arrayList_cart.size(); i++) {
            if (null != listView_cart.getChildAt(i) && ((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).isChecked()) {// б״̬+1
                num_choice += 1;
                is_choice[i] = true;
            }
        }
        if (num_choice == Data.arrayList_cart.size()) {
            cb_cart_all.setChecked(true);
        } else {
            cb_cart_all.setChecked(false);
        }

        tv_cart_Allprice.setText("ϼƣ" + Data.Allprice_cart + "");

        System.out.println("--->" + position);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_goShop:
                btnCallListener.transferMsg();
                break;
            case R.id.tv_cart_buy_or_del:
                boolean[] is_choice_copy = is_choice;
                if (tv_cart_buy_Ordel.getText().toString().equals("ɾ")) {

                    if (Data.arrayList_cart.size() != 0) {
                        for (int i = is_choice_copy.length - 1; i >= 0; i--) {
                            if (is_choice_copy[i]) {
                                ((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).setChecked(false);
                                Data.arrayList_cart.remove(i);
                                is_choice_copy = deleteByIndex(is_choice, i);
                            }
                        }
                    }


                    if (Data.arrayList_cart.size() == 0) {
                        ll_cart.setVisibility(View.VISIBLE);
                    }

                    adapter.notifyDataSetChanged();
                    is_choice = new boolean[Data.arrayList_cart.size()];
                    System.out.println("ĳ---->" + is_choice.length);
                } else {

                    Toast.makeText(getActivity(), "޷", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }

    }



    public static boolean[] deleteByIndex(boolean[] array, int index) {
        boolean[] newArray = new boolean[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        return newArray;
    }

}
