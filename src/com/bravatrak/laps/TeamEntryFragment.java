package com.bravatrak.laps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TeamEntryFragment extends Fragment {
	public static final String TEAM_ENTRY_FRAGMENT_LABEL = "Add Team Member";


	public static Fragment newInstance()
	{
		TeamEntryFragment fragment = new TeamEntryFragment();
		
		// Add Args
		
		return fragment;
	}

	
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_team_entry, parent, false);
		
		return v;
		
	}

}
