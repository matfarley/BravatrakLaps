package com.bravatrak.laps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_main, parent, false);
		
		TextView t = (TextView)v.findViewById(R.id.Main_Test_TextView);
		t.setText("Main Fragment");
		
		return v;
		
	}

}
