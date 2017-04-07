package com.javis.ab.view;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


@SuppressLint("UseSparseArrays")
@SuppressWarnings("unused")
public class AbViewPagerAdapter extends PagerAdapter{
	

	private Context mContext;
	

	private ArrayList<View> mListViews = null;
	

	private HashMap <Integer,View> mViews = null;



	public AbViewPagerAdapter(Context context,ArrayList<View> mListViews) {
		this.mContext = context;
		this.mListViews = mListViews;
		this.mViews = new HashMap <Integer,View>();
	}


	@Override
	public int getCount() {
		return mListViews.size();
	}


	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
	}


	@Override
	public Object instantiateItem(View container, int position) {
		View v = mListViews.get(position);
		((ViewPager) container).addView(v);
		return v;
	}


	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView((View)object);
	}
	

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
	

}
