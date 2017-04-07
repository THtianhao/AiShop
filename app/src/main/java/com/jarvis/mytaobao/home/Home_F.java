package com.jarvis.mytaobao.home;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jarvis.mytaobaotest.R;
import com.javis.Adapter.Adapter_GridView;
import com.javis.Adapter.Adapter_GridView_hot;
import com.javis.ab.view.AbOnItemClickListener;
import com.javis.ab.view.AbSlidingPlayView;
import com.zxing.activity.CaptureActivity;

/**
 * @author http://yecaoly.taobao.com
 */
public class Home_F extends Fragment {
	private TextView tv_top_title;
	private GridView gridView_classify;
	private GridView my_gridView_hot;
	private Adapter_GridView adapter_GridView_classify;
	private Adapter_GridView_hot adapter_GridView_hot;
	private AbSlidingPlayView viewPager;
	private ImageView iv_shao;
	private int[] pic_path_classify = { R.drawable.menu_guide_1, R.drawable.menu_guide_2, R.drawable.menu_guide_3, R.drawable.menu_guide_4, R.drawable.menu_guide_5, R.drawable.menu_guide_6, R.drawable.menu_guide_7, R.drawable.menu_guide_8 };
	private int[] pic_path_hot = { R.drawable.menu_1, R.drawable.menu_2, R.drawable.menu_3, R.drawable.menu_4, R.drawable.menu_5, R.drawable.menu_6 };
	private ArrayList<View> allListView;
	private int[] resId = { R.drawable.pager_m5, R.drawable.pager_m3, R.drawable.pager_m2, R.drawable.pager_m1, R.drawable.pager_m4};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_f, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		iv_shao=(ImageView) view.findViewById(R.id.iv_shao);
		iv_shao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getActivity(),CaptureActivity.class);
				startActivity(intent);
			}
		});
		tv_top_title=(TextView) view.findViewById(R.id.tv_top_title);
		tv_top_title.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getActivity(),WareActivity.class);
				startActivity(intent);
			}
		});
		
		gridView_classify = (GridView) view.findViewById(R.id.my_gridview);
		my_gridView_hot = (GridView) view.findViewById(R.id.my_gridview_hot);
		gridView_classify.setSelector(new ColorDrawable(Color.TRANSPARENT));
		my_gridView_hot.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter_GridView_classify = new Adapter_GridView(getActivity(), pic_path_classify);
		adapter_GridView_hot = new Adapter_GridView_hot(getActivity(), pic_path_hot);
		gridView_classify.setAdapter(adapter_GridView_classify);
		my_gridView_hot.setAdapter(adapter_GridView_hot);

		viewPager = (AbSlidingPlayView) view.findViewById(R.id.viewPager_menu);
		viewPager.setPlayType(1);
		viewPager.setSleepTime(3000);

		gridView_classify.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(getActivity(), WareActivity.class);
				startActivity(intent);
			}
		});
		my_gridView_hot.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(getActivity(), BabyActivity.class);
				startActivity(intent);
			}
		});
		
		initViewPager();
	}

	private void initViewPager() {

		if (allListView != null) {
			allListView.clear();
			allListView = null;
		}
		allListView = new ArrayList<View>();

		for (int i = 0; i < resId.length; i++) {
			View view = LayoutInflater.from(getActivity()).inflate(R.layout.pic_item, null);
			ImageView imageView = (ImageView) view.findViewById(R.id.pic_item);
			imageView.setImageResource(resId[i]);
			allListView.add(view);
		}
		
		
		viewPager.addViews(allListView);
		viewPager.startPlay();
		viewPager.setOnItemClickListener(new AbOnItemClickListener() {
			@Override
			public void onClick(int position) {
				Intent intent = new Intent(getActivity(), BabyActivity.class);
				startActivity(intent);
			}
		});
	}

}
