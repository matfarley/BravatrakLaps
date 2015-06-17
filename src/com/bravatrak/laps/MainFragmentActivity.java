package com.bravatrak.laps;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainFragmentActivity extends ActionBarActivity {
	private static final String[] FRAGMENT_LABELS = {HomeFragment.HOME_FRAGMENT_LABEL, TeamEntryFragment.TEAM_ENTRY_FRAGMENT_LABEL};
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_fragment);
		mTitle = mDrawerTitle = getTitle();
		
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close){
			//  Called when a drawer has settled in a completely closed state
			@Override
			public void onDrawerClosed(View drawerView){
			    super.onDrawerClosed(drawerView);
			    getSupportActionBar().setTitle(mTitle);
			    supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
			}
			
			//  Called when a drawer has settled in a completely open state. 
			public void onDrawerOpened(View drawerView){
				super.onDrawerOpened(drawerView);
				getSupportActionBar().setTitle(mDrawerTitle);
				supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
			}
		};
		
		//  Set DrawerToggle as the Drawer Listener
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		mDrawerList = (ListView)findViewById(R.id.navigation_drawer_list);
		
		//Set Adapter for the List View
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item,
				FRAGMENT_LABELS));
		
		//Set the list's click listener
		mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView parent, View view, int position,
					long id) {
				selectItem(position);
			}
		});
		
		//  Use the first Fragment if app is being opened for the first time.
		if (savedInstanceState == null){
			selectItem(0);
		}
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.menu_splash, menu);
		return true;
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		//  If nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
		//  Sync the toggle state after onRestoreINstanceState has ocurred
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// Pass the event to ActionBarDrawerToggle, if it returns
	    // true, then it has handled the app icon touch event
	    if (mDrawerToggle.onOptionsItemSelected(item)) {
	    return true;
	    }
	    // Handle your other action bar items...
	     
	    return super.onOptionsItemSelected(item);
	}
	
	
	private void selectItem(int position){
		Fragment fragment = null;
		FragmentManager fm = getSupportFragmentManager();
		
		switch(position){
		case 0:
			fragment = HomeFragment.newInstance();
			break;
		case 1:
			fragment = TeamEntryFragment.newInstance();
			break;
		// Add other cases as new fragments are created
		}
		
		fm.beginTransaction()
		    .replace(R.id.fragmentContainer, fragment)
		    .commit();
		
		mDrawerList.setItemChecked(position, true);
		setTitle(FRAGMENT_LABELS[position]);
		mDrawerLayout.closeDrawer(mDrawerList);

	}
	
    @Override
	public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

}
