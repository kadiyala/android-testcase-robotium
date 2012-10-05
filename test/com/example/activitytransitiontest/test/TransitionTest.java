package com.example.activitytransitiontest.test;

import com.example.activitytransitiontest.R;
import android.test.ActivityInstrumentationTestCase2;

import com.example.activitytransitiontest.MainActivity;
import com.example.activitytransitiontest.SecondActivity;
import com.example.activitytransitiontest.ThirdActivity;
import com.jayway.android.robotium.solo.Solo;

public class TransitionTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;

	public TransitionTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.solo = new Solo(this.getInstrumentation(), this.getActivity());
	}
	
	@Override
	protected void tearDown() throws Exception {
		this.solo.finishOpenedActivities();
		super.tearDown();
	}
	
	public void testTransition() throws Exception {
		this.solo.clickOnButton(this.solo.getString(R.string.firstButtonText));
		this.solo.assertCurrentActivity("Second Activity Should Run", SecondActivity.class);
		this.solo.clickOnButton(this.solo.getString(R.string.secondButtonText));
		this.solo.assertCurrentActivity("Third Activity Should Run", ThirdActivity.class);
		this.solo.clickOnButton(this.solo.getString(R.string.thirdButtonText));
		this.solo.assertCurrentActivity("Second Activity Should Run", SecondActivity.class);
		this.solo.goBack();
		this.solo.assertCurrentActivity("First Activity Should Run", MainActivity.class);
	}
}
