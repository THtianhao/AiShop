package com.jarvis.mytaobao.user;

import java.util.Random;

import com.jarvis.MyView.ScratchTextView;
import com.jarvis.mytaobaotest.R;
import com.zdp.aseo.content.AseoZdpAseo;

import android.app.Activity;
import android.os.Bundle;


public class User_life extends Activity { 


	private ScratchTextView tv_Scratch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AseoZdpAseo.initType(this, AseoZdpAseo.INSERT_TYPE);
		setContentView(R.layout.user_life);
		tv_Scratch=(ScratchTextView) findViewById(R.id.tv_Scratch);
		tv_Scratch.initScratchCard(0xFFCECED1, 3, 1f);
		tv_Scratch.setText(str_reward[getRandom()]);
	}
	
	
	private String[] str_reward={"ллݹ","ϲ5ë","","㽱","ý","Srroyɣ","ϲһȽ","ܱǸ","н","һƿ"};
	
	

	private int getRandom(){
		Random random=new Random();
		int number=random.nextInt(10);
		
		return number;
	}

}
