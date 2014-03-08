package com.bravatrak.laps;

import android.support.v4.app.Fragment;

public class MainFragmentActivity extends SingleFragmentActivity {

	@Override
	public Fragment createFragment() {
		return new MainFragment();
	}

}
