package com.aquarelah.ukuleletuner;

import com.aquarelah.ukuleletunning.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener,
		MediaPlayer.OnCompletionListener {

	private MediaPlayer mPlayer = null;

	static int[] Chords_Buttons = {
		R.id.tgbtn_G,
		R.id.tgbtn_C,
		R.id.tgbtn_E,
		R.id.tgbtn_A
		
		};
	private ImageView img;

	Button btn[] = new Button[4];
	ToggleButton tgbtn[] = new ToggleButton[4];
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		img = (ImageView)findViewById(R.id.imgVw);

		tgbtn[0] = (ToggleButton) findViewById(R.id.tgbtn_G);
		tgbtn[1] = (ToggleButton) findViewById(R.id.tgbtn_C);
		tgbtn[2] = (ToggleButton) findViewById(R.id.tgbtn_E);
		tgbtn[3] = (ToggleButton) findViewById(R.id.tgbtn_A);

		for (int i = 0; i < btn.length; i++) {
			tgbtn[i].setOnClickListener(this);
		}
	}

	public void onClick(View view) {

		boolean on;
		switch (view.getId()) {
		case R.id.tgbtn_G:
			on = tgbtn[0].isChecked();
		    if (on) {
				stopPlaying();
				uncheckAllToggleButtons(tgbtn[0]);
				mPlayer = MediaPlayer.create(this, R.raw.g_chord_ukulele);
				mPlayer.setOnCompletionListener(this);
				img.setImageResource(R.drawable.ukulele_g);
				mPlayer.setLooping(true);
				mPlayer.start();
				break;
		    } else {
		    	stopPlaying();
				uncheckAllToggleButtons(null);

		    }

		case R.id.tgbtn_C:

			on = tgbtn[1].isChecked();
		    if (on) {
				stopPlaying();
				uncheckAllToggleButtons(tgbtn[1]);
				mPlayer = MediaPlayer.create(this, R.raw.c_chord_ukulele);
				mPlayer.setOnCompletionListener(this);
				img.setImageResource(R.drawable.ukulele_c);
				mPlayer.setLooping(true);
				mPlayer.start();
				break;
		    } else {
		    	stopPlaying();
				uncheckAllToggleButtons(null);
		    }
		    
		case R.id.tgbtn_E:

			on = tgbtn[2].isChecked();
		    if (on) {
				stopPlaying();
				uncheckAllToggleButtons(tgbtn[2]);
				mPlayer = MediaPlayer.create(this, R.raw.e_chord_ukulele);
				mPlayer.setOnCompletionListener(this);
				img.setImageResource(R.drawable.ukulele_e);
				mPlayer.setLooping(true);
				mPlayer.start();
				break;
		    } else {
		    	stopPlaying();
				uncheckAllToggleButtons(null);
		    }
		    
		case R.id.tgbtn_A:

			on = tgbtn[3].isChecked();
		    if (on) {
				stopPlaying();
				uncheckAllToggleButtons(tgbtn[3]);
				mPlayer = MediaPlayer.create(this, R.raw.a_chord_ukulele);
				mPlayer.setOnCompletionListener(this);
				img.setImageResource(R.drawable.ukulele_a);
				mPlayer.setLooping(true);
				mPlayer.start();
				break;
		    } else {
		    	stopPlaying();
				uncheckAllToggleButtons(null);
		    }
		    
		        
		}
	}

	private void uncheckAllToggleButtons(ToggleButton tgBtn) {

		for(int i = 0 ; i < tgbtn.length; i++){
			if(!tgbtn[i].equals(tgBtn))
				tgbtn[i].setChecked(false);
		}
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		img.setImageResource(R.drawable.ukulele);
	}

	private void stopPlaying() {
		if (mPlayer != null) {
			mPlayer.stop();
			mPlayer.release();
			mPlayer = null;
		}
    	img.setImageResource(R.drawable.ukulele);
	}

}