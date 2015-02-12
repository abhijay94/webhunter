package com.Abhijay.webhunter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.*;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.Abhijay.webhunter.R;

public class AdvancedSettingsActivity extends Activity {

	// mPreferences variables
	private static final int API = android.os.Build.VERSION.SDK_INT;
	private SharedPreferences mPreferences;
	private SharedPreferences.Editor mEditPrefs;
	private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cbIncognitoCookies,
			cbSearchSuggestions, cbClearHistoryExit, cbClearCookiesExit;
	private Context mContext;
	private boolean mSystemBrowser;
	private Handler messageHandler;
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advanced_settings);
		Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Walkway_SemiBold.ttf");
		t1 = (TextView) findViewById(R.id.textView2);
		t2 = (TextView) findViewById(R.id.textView3);
		t3 = (TextView) findViewById(R.id.textView21);
		t4 = (TextView) findViewById(R.id.textView22);
		t5 = (TextView) findViewById(R.id.textView23);
		t6 = (TextView) findViewById(R.id.textView24);
		t7 = (TextView) findViewById(R.id.textView25);
		t8 = (TextView) findViewById(R.id.textView26);
		t9 = (TextView) findViewById(R.id.textView27);
		t10 = (TextView) findViewById(R.id.textView28);
		t11 = (TextView) findViewById(R.id.textView29);
		t12 = (TextView) findViewById(R.id.textView30);
		t13 = (TextView) findViewById(R.id.textView31);
		t14 = (TextView) findViewById(R.id.textView4);
		t15 = (TextView) findViewById(R.id.textView5);
		t16 = (TextView) findViewById(R.id.textView6);
		t17 = (TextView) findViewById(R.id.textView7);
		t18 = (TextView) findViewById(R.id.textView8);
		t19 = (TextView) findViewById(R.id.textView9);
		t20 = (TextView) findViewById(R.id.textView10);
		
		t1.setTypeface(face);
		t2.setTypeface(face);
		t3.setTypeface(face);
		t4.setTypeface(face);
		t5.setTypeface(face);
		t6.setTypeface(face);
		t7.setTypeface(face);
		t8.setTypeface(face);
		t9.setTypeface(face);
		t10.setTypeface(face);
		t11.setTypeface(face);
		t12.setTypeface(face);
		t13.setTypeface(face);
		t14.setTypeface(face);
		t15.setTypeface(face);
		t16.setTypeface(face);
		t17.setTypeface(face);
		t18.setTypeface(face);
		t19.setTypeface(face);
		t20.setTypeface(face);
		
		ActionBar actionBar = getActionBar();
		if (actionBar != null) {
			actionBar.setHomeButtonEnabled(true);
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		mPreferences = getSharedPreferences(PrefConstants.PREFERENCES, 0);
		if (mPreferences.getBoolean(PrefConstants.HIDE_STATUS_BAR, false)) {
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}

		// TODO WARNING: SharedPreferences.edit() without a corresponding
		// commit() or apply() call
		mEditPrefs = mPreferences.edit();

		mSystemBrowser = mPreferences.getBoolean(PrefConstants.SYSTEM_BROWSER_PRESENT, false);
		mContext = this;
		initialize();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		finish();
		return true;
	}

	private void initialize() {

		RelativeLayout r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, rIncognitoCookies, rClearCache, rSearchSuggestions, rClearHistoryExit, rClearCookiesExit;

		r1 = (RelativeLayout) findViewById(R.id.r1);
		r2 = (RelativeLayout) findViewById(R.id.r2);
		rClearHistoryExit = (RelativeLayout) findViewById(R.id.rClearHistoryExit);
		rClearCookiesExit = (RelativeLayout) findViewById(R.id.rClearCookiesExit);
		r3 = (RelativeLayout) findViewById(R.id.r3);
		r4 = (RelativeLayout) findViewById(R.id.r4);
		r5 = (RelativeLayout) findViewById(R.id.r5);
		r6 = (RelativeLayout) findViewById(R.id.r6);
		r7 = (RelativeLayout) findViewById(R.id.r7);
		r8 = (RelativeLayout) findViewById(R.id.rClearHistory);
		r10 = (RelativeLayout) findViewById(R.id.r10);
		r11 = (RelativeLayout) findViewById(R.id.r11);
		r12 = (RelativeLayout) findViewById(R.id.r12);
		r13 = (RelativeLayout) findViewById(R.id.r13);
		r14 = (RelativeLayout) findViewById(R.id.r14);
		r15 = (RelativeLayout) findViewById(R.id.r15);
		rIncognitoCookies = (RelativeLayout) findViewById(R.id.rIncognitoCookies);
		rClearCache = (RelativeLayout) findViewById(R.id.rClearCache);
		rSearchSuggestions = (RelativeLayout) findViewById(R.id.rGoogleSuggestions);

		cb1 = (CheckBox) findViewById(R.id.cb1);
		cb2 = (CheckBox) findViewById(R.id.cb2);
		cbClearHistoryExit = (CheckBox) findViewById(R.id.cbClearHistoryExit);
		cbClearCookiesExit = (CheckBox) findViewById(R.id.cbClearCookiesExit);
		cb3 = (CheckBox) findViewById(R.id.cb3);
		cb4 = (CheckBox) findViewById(R.id.cb4);
		cb5 = (CheckBox) findViewById(R.id.cb5);
		cb6 = (CheckBox) findViewById(R.id.cb6);
		cb7 = (CheckBox) findViewById(R.id.cb7);
		cb8 = (CheckBox) findViewById(R.id.cb8);
		cb9 = (CheckBox) findViewById(R.id.cb9);
		cb10 = (CheckBox) findViewById(R.id.cb10);
		cb11 = (CheckBox) findViewById(R.id.cb11);
		cbIncognitoCookies = (CheckBox) findViewById(R.id.cbIncognitoCookies);
		cbSearchSuggestions = (CheckBox) findViewById(R.id.cbGoogleSuggestions);

		cb1.setChecked(mPreferences.getBoolean(PrefConstants.SAVE_PASSWORDS, true));
		cb2.setChecked(mPreferences.getBoolean(PrefConstants.CLEAR_CACHE_EXIT, false));
		cbClearHistoryExit.setChecked(mPreferences.getBoolean(
				PrefConstants.CLEAR_HISTORY_EXIT, false));
		cbClearCookiesExit.setChecked(mPreferences.getBoolean(
				PrefConstants.CLEAR_COOKIES_EXIT, false));
		cb3.setChecked(mPreferences.getBoolean(PrefConstants.JAVASCRIPT, true));
		cb4.setChecked(mPreferences.getBoolean(PrefConstants.TEXT_REFLOW, false));
		cb4.setEnabled(API < 19);
		if (API >= 19) {
			mEditPrefs.putBoolean(PrefConstants.TEXT_REFLOW, false);
			mEditPrefs.commit();
		}
		cb5.setChecked(mPreferences.getBoolean(PrefConstants.BLOCK_IMAGES, false));
		cb6.setChecked(mPreferences.getBoolean(PrefConstants.POPUPS, true));
		cb7.setChecked(mPreferences.getBoolean(PrefConstants.COOKIES, true));
		cb8.setChecked(mPreferences.getBoolean(PrefConstants.USE_WIDE_VIEWPORT, true));
		cb9.setChecked(mPreferences.getBoolean(PrefConstants.OVERVIEW_MODE, true));
		cb10.setChecked(mPreferences.getBoolean(PrefConstants.RESTORE_LOST_TABS, true));
		cb11.setChecked(mPreferences.getBoolean(PrefConstants.HIDE_STATUS_BAR, false));
		cbIncognitoCookies.setChecked(mPreferences.getBoolean(
				PrefConstants.INCOGNITO_COOKIES, false));
		cbSearchSuggestions.setChecked(mPreferences.getBoolean(
				PrefConstants.GOOGLE_SEARCH_SUGGESTIONS, true));

		r1(r1);
		r2(r2);
		rClearHistoryExit(rClearHistoryExit);
		rClearCookiesExit(rClearCookiesExit);
		r3(r3);
		r4(r4);
		r5(r5);
		r6(r6);
		r7(r7);
		r8(r8);
		r10(r10);
		r11(r11);
		r12(r12);
		r13(r13);
		r14(r14);
		r15(r15);
		rIncognitoCookies(rIncognitoCookies);
		rClearCache(rClearCache);
		rSearchSuggestions(rSearchSuggestions);
		cb1(cb1);
		cb2(cb2);
		cbClearHistoryExit(cbClearHistoryExit);
		cbClearCookiesExit(cbClearCookiesExit);
		cb3(cb3);
		cb4(cb4);
		cb5(cb5);
		cb6(cb6);
		cb7(cb7);
		cb8(cb8);
		cb9(cb9);
		cb10(cb10);
		cb11(cb11);
		cbIncognitoCookies(cbIncognitoCookies);
		cbSearchSuggestions(cbSearchSuggestions);

		TextView syncHistory = (TextView) findViewById(R.id.isBrowserAvailable);

		RelativeLayout layoutSyncHistory = (RelativeLayout) findViewById(R.id.rBrowserHistory);
		final CheckBox cbSyncHistory = (CheckBox) findViewById(R.id.cbBrowserHistory);
		layoutSyncHistory.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cbSyncHistory.setChecked(!cbSyncHistory.isChecked());
			}

		});
		cbSyncHistory.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.SYNC_HISTORY, isChecked).apply();
			}

		});

		if (!mSystemBrowser) {
			cbSyncHistory.setChecked(false);
			cbSyncHistory.setEnabled(false);
			syncHistory.setText(getResources().getString(R.string.stock_browser_unavailable));
		} else {
			cbSyncHistory.setEnabled(true);
			cbSyncHistory.setChecked(mPreferences
					.getBoolean(PrefConstants.SYNC_HISTORY, true));
			syncHistory.setText(getResources().getString(R.string.stock_browser_available));
		}

		messageHandler = new MessageHandler(mContext);
	}

	private static class MessageHandler extends Handler {

		Context mHandlerContext;

		public MessageHandler(Context context) {
			this.mHandlerContext = context;
		}

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case 1:
					Utils.showToast(mHandlerContext,
							mHandlerContext.getResources()
									.getString(R.string.message_clear_history));
					break;
				case 2:
					Utils.showToast(
							mHandlerContext,
							mHandlerContext.getResources().getString(
									R.string.message_cookies_cleared));
					break;
			}
			super.handleMessage(msg);
		}
	}

	private void cb1(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.SAVE_PASSWORDS, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb2(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.CLEAR_CACHE_EXIT, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cbClearHistoryExit(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.CLEAR_HISTORY_EXIT, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cbClearCookiesExit(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.CLEAR_COOKIES_EXIT, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb3(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.JAVASCRIPT, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb4(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.TEXT_REFLOW, isChecked);
				mEditPrefs.commit();
			}
		});
	}

	private void cb5(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.BLOCK_IMAGES, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb6(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.POPUPS, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb7(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.COOKIES, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb8(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.USE_WIDE_VIEWPORT, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb9(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.OVERVIEW_MODE, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb10(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.RESTORE_LOST_TABS, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cb11(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.HIDE_STATUS_BAR, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cbIncognitoCookies(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.INCOGNITO_COOKIES, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void cbSearchSuggestions(CheckBox view) {
		view.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditPrefs.putBoolean(PrefConstants.GOOGLE_SEARCH_SUGGESTIONS, isChecked);
				mEditPrefs.commit();
			}

		});
	}

	private void r1(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb1.setChecked(!cb1.isChecked());
			}

		});
	}

	private void r2(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb2.setChecked(!cb2.isChecked());
			}

		});
	}

	private void rClearHistoryExit(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cbClearHistoryExit.setChecked(!cbClearHistoryExit.isChecked());
			}

		});
	}

	private void rClearCookiesExit(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cbClearCookiesExit.setChecked(!cbClearCookiesExit.isChecked());
			}

		});
	}

	private void r3(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb3.setChecked(!cb3.isChecked());
			}

		});
	}

	private void r4(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (API < 19) {
					cb4.setChecked(!cb4.isChecked());
				} else {
					Utils.createInformativeDialog(mContext,
							getResources().getString(R.string.title_warning), getResources()
									.getString(R.string.dialog_reflow_warning));
				}
			}

		});
	}

	private void r5(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb5.setChecked(!cb5.isChecked());
			}

		});
	}

	private void r6(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb6.setChecked(!cb6.isChecked());
			}

		});
	}

	private void r7(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb7.setChecked(!cb7.isChecked());
			}

		});
	}

	private void r8(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(AdvancedSettingsActivity.this); // dialog
				builder.setTitle(getResources().getString(R.string.title_clear_history));
				builder.setMessage(getResources().getString(R.string.dialog_history))
						.setPositiveButton(getResources().getString(R.string.action_yes),
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0, int arg1) {
										Thread clear = new Thread(new Runnable() {

											@Override
											public void run() {
												clearHistory();
											}

										});
										clear.start();
									}

								})
						.setNegativeButton(getResources().getString(R.string.action_no),
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0, int arg1) {
										// TODO Auto-generated method stub

									}

								}).show();
			}

		});
	}

	private void r11(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb8.setChecked(!cb8.isChecked());
			}

		});

	}

	private void r12(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cb9.setChecked(!cb9.isChecked());
			}

		});
	}

	private void r13(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cb10.setChecked(!cb10.isChecked());
			}

		});
	}

	private void r14(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cb11.setChecked(!cb11.isChecked());
			}

		});
	}

	private void r15(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(AdvancedSettingsActivity.this); // dialog
				builder.setTitle(getResources().getString(R.string.title_clear_cookies));
				builder.setMessage(getResources().getString(R.string.dialog_cookies))
						.setPositiveButton(getResources().getString(R.string.action_yes),
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0, int arg1) {
										Thread clear = new Thread(new Runnable() {

											@Override
											public void run() {
												clearCookies();
											}

										});
										clear.start();
									}

								})
						.setNegativeButton(getResources().getString(R.string.action_no),
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0, int arg1) {

									}

								}).show();
			}

		});
	}

	private void rIncognitoCookies(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cbIncognitoCookies.setChecked(!cbIncognitoCookies.isChecked());
			}

		});

	}

	private void rSearchSuggestions(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				cbSearchSuggestions.setChecked(!cbSearchSuggestions.isChecked());
			}

		});
	}

	private void rClearCache(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clearCache();
			}

		});

	}

	public void clearCache() {
		WebView webView = new WebView(this);
		webView.clearCache(true);
		webView.destroy();
		Utils.showToast(mContext, getResources().getString(R.string.message_cache_cleared));
	}

	@SuppressWarnings("deprecation")
	public void clearHistory() {
		deleteDatabase(HistoryDatabaseHandler.DATABASE_NAME);
		WebViewDatabase m = WebViewDatabase.getInstance(this);
		m.clearFormData();
		m.clearHttpAuthUsernamePassword();
		if (API < 18) {
			m.clearUsernamePassword();
			WebIconDatabase.getInstance().removeAllIcons();
		}
		if (mSystemBrowser) {
			try {
				Browser.clearHistory(getContentResolver());
			} catch (Exception ignored) {
			}
		}
		SettingsController.setClearHistory(true);
		Utils.trimCache(this);
		messageHandler.sendEmptyMessage(1);
	}

	public void clearCookies() {
		CookieManager c = CookieManager.getInstance();
		CookieSyncManager.createInstance(this);
		c.removeAllCookie();
		messageHandler.sendEmptyMessage(2);
	}

	private void r10(RelativeLayout view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder picker = new AlertDialog.Builder(AdvancedSettingsActivity.this);
				picker.setTitle(getResources().getString(R.string.title_text_size));

				int n = mPreferences.getInt(PrefConstants.TEXT_SIZE, 3);

				picker.setSingleChoiceItems(R.array.text_size, n - 1,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								mEditPrefs.putInt(PrefConstants.TEXT_SIZE, which + 1);
								mEditPrefs.commit();

							}
						});
				picker.setNeutralButton(getResources().getString(R.string.action_ok),
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {

							}
						});
				picker.show();
			}

		});
	}

	public void importFromStockBrowser() {
		BookmarkManager manager = new BookmarkManager(this);
		manager.importBookmarksFromBrowser();
	}
}
