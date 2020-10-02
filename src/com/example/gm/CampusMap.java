package com.example.gm;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class CampusMap extends ActionBarActivity {
	private final LatLng LOCATION_NITGOA = new LatLng(15.412440 ,73.978173 );

	private GoogleMap map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.campusmap);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void onClick_NitGoa(View v){
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//		CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_NITGOA);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_NITGOA, 19);
		map.animateCamera(update);
	}
	
}

