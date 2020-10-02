package com.example.gm;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle Nitin) {
		// TODO Auto-generated method stub
		super.onCreate(Nitin);
		setContentView(R.layout.splash);
		
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.splash_sound);
		ourSong.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
}
