package com.jarvis.mytaobao.home;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.jarvis.mytaobao.Data.Data;
import com.jarvis.mytaobao.cart.Cart_F;
import com.jarvis.mytaobao.discover.Discover_F;
import com.jarvis.mytaobao.tao.Tao_F;
import com.jarvis.mytaobao.user.User_F;
import com.jarvis.mytaobaotest.R;
import com.javis.mytools.IBtnCallListener;


public class Main_FA extends FragmentActivity implements OnClickListener, IBtnCallListener {

	private ImageView[] bt_menu = new ImageView[3];
	private int[] bt_menu_id = { R.id.iv_menu_0, R.id.iv_menu_3, R.id.iv_menu_4 };

	private int[] select_on = { R.drawable.guide_home_on, R.drawable.guide_tfaccount_on, R.drawable.guide_discover_on, R.drawable.guide_cart_on, R.drawable.guide_account_on };
	private int[] select_off = { R.drawable.bt_menu_0_select, R.drawable.bt_menu_1_select, R.drawable.bt_menu_2_select, R.drawable.bt_menu_3_select, R.drawable.bt_menu_4_select };



	private Home_F home_F;

	private Tao_F tao_F;

	private Discover_F discover_F;

	private Cart_F cart_F;


	private User_F user_F;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_fa);
		getSaveData();
		initView();
	}


	private void getSaveData() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		SharedPreferences sp = getSharedPreferences("SAVE_CART", Context.MODE_PRIVATE);
		int size = sp.getInt("ArrayCart_size", 0);
		for (int i = 0; i < size; i++) {
			hashMap.put("type", sp.getString("ArrayCart_type_" + i, ""));
			hashMap.put("color", sp.getString("ArrayCart_color_" + i, ""));
			hashMap.put("num", sp.getString("ArrayCart_num_" + i, ""));
			Data.arrayList_cart.add(hashMap);
		}

	}

	private void initView() {
		for (int i = 0; i < bt_menu.length; i++) {
			bt_menu[i] = (ImageView) findViewById(bt_menu_id[i]);
			bt_menu[i].setOnClickListener(this);
		}

		if (home_F == null) {
			home_F = new Home_F();
			addFragment(home_F);

		} else {
			showFragment(home_F);
		}
		bt_menu[0].setImageResource(select_on[0]);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_menu_0:
			if (home_F == null) {
				home_F = new Home_F();
				addFragment(home_F);
				showFragment(home_F);
			} else {
				if (home_F.isHidden()) {
					showFragment(home_F);
				}
			}

			break;
//		case R.id.iv_menu_1:
//			if (tao_F == null) {
//				tao_F = new Tao_F();
//				if (!tao_F.isHidden()) {
//					addFragment(tao_F);
//					showFragment(tao_F);
//				}
//			} else {
//				if (tao_F.isHidden()) {
//					showFragment(tao_F);
//				}
//			}
//
//			break;
//		case R.id.iv_menu_2:
//			if (discover_F == null) {
//				discover_F = new Discover_F();
//				if (!discover_F.isHidden()) {
//					addFragment(discover_F);
//					showFragment(discover_F);
//				}
//			} else {
//				if (discover_F.isHidden()) {
//					showFragment(discover_F);
//				}
//			}
//
//			break;
		case R.id.iv_menu_3:
			if (cart_F != null) {
				removeFragment(cart_F);
				cart_F = null;
			}
			cart_F = new Cart_F();
			addFragment(cart_F);
			showFragment(cart_F);

			break;
		case R.id.iv_menu_4:
			if (user_F == null) {
				user_F = new User_F();
				if (!user_F.isHidden()) {
					addFragment(user_F);
					showFragment(user_F);
				}
			} else {
				if (user_F.isHidden()) {
					showFragment(user_F);
				}
			}

			break;
		}

		for (int i = 0; i < bt_menu.length; i++) {
			bt_menu[i].setImageResource(select_off[i]);
			if (v.getId() == bt_menu_id[i]) {
				bt_menu[i].setImageResource(select_on[i]);
			}
		}
	}


	public void addFragment(Fragment fragment) {
		FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
		ft.add(R.id.show_layout, fragment);
		ft.commit();
	}


	public void removeFragment(Fragment fragment) {
		FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
		ft.remove(fragment);
		ft.commit();
	}


	public void showFragment(Fragment fragment) {
		FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
		ft.setCustomAnimations(R.anim.cu_push_right_in, R.anim.cu_push_left_out);

		if (home_F != null) {
			ft.hide(home_F);
		}
		if (tao_F != null) {
			ft.hide(tao_F);
		}
		if (discover_F != null) {
			ft.hide(discover_F);
		}
		if (cart_F != null) {
			ft.hide(cart_F);
		}
		if (user_F != null) {
			ft.hide(user_F);
		}

		ft.show(fragment);
		ft.commitAllowingStateLoss();

	}


	@Override
	public void onBackPressed() 
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}


	@SuppressWarnings("unused")
	private IBtnCallListener btnCallListener;

	@Override
	public void onAttachFragment(Fragment fragment) {
		try {
			btnCallListener = (IBtnCallListener) fragment;
		} catch (Exception e) {
		}

		super.onAttachFragment(fragment);
	}


	@Override
	public void transferMsg() {
		if (home_F == null) {
			home_F = new Home_F();
			addFragment(home_F);
			showFragment(home_F);
		} else {
			showFragment(home_F);
		}
		bt_menu[3].setImageResource(select_off[3]);
		bt_menu[0].setImageResource(select_on[0]);

	}

}
