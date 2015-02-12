package com.Abhijay.webhunter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.Abhijay.webhunter.R;

/*
 *NOTE: This activity must not be removed in order to comply with the Mozilla Public License v. 2.0 
 *under which this code is licensed. Unless you plan on providing other attribution in the app to 
 *the original source in another visible way, it is advised against the removal of this Activity.
 */
public class LicenseActivity extends Activity implements View.OnClickListener {
	TextView l1,l2,l3,l4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.license_activity);
		Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Walkway_SemiBold.ttf");
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		l1 = (TextView) findViewById(R.id.textView1);
		l2 = (TextView) findViewById(R.id.textView2);
		l3 = (TextView) findViewById(R.id.textView3);
		l4 = (TextView) findViewById(R.id.textView4);
		l1.setTypeface(face);
		l2.setTypeface(face);
		l3.setTypeface(face);
		l4.setTypeface(face);
		findViewById(R.id.browserLicense).setOnClickListener(this);
		findViewById(R.id.licenseAOSP).setOnClickListener(this);
		findViewById(R.id.licenseHosts).setOnClickListener(this);
		findViewById(R.id.licenseOrbot).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.browserLicense:
				actionView("http://www.mozilla.org/MPL/2.0/");
				break;
			case R.id.licenseAOSP:
				actionView("http://www.apache.org/licenses/LICENSE-2.0");
				break;
			case R.id.licenseHosts:
				actionView("http://hosts-file.net/");
				break;
			case R.id.licenseOrbot:
				actionView("http://www.gnu.org/licenses/lgpl.html");
				break;
		}
	}

	private void actionView(String url) {
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url), this, MainActivity.class));
		finish();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		finish();
		return super.onOptionsItemSelected(item);
	}
}
