package com.example.activitytransitiontest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class ThirdActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_third, menu);
		return true;
	}

	public void click(View v) {
		this.finish();
	}
}
