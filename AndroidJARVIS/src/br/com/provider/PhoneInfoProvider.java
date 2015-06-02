package br.com.provider;

import android.content.Context;
import android.content.res.Configuration;

public class PhoneInfoProvider {
	
	private Context context;
	private Integer screenSize;
	
	public static final int SCREEN_UNDEFINED = Configuration.SCREENLAYOUT_SIZE_UNDEFINED;
	public static final int SCREEN_NORMAL 	 = Configuration.SCREENLAYOUT_SIZE_NORMAL;
	public static final int SCREEN_XLARGE    = Configuration.SCREENLAYOUT_SIZE_XLARGE;
	public static final int SCREEN_LARGE 	 = Configuration.SCREENLAYOUT_SIZE_LARGE;
	public static final int SCREEN_SMALL 	 = Configuration.SCREENLAYOUT_SIZE_SMALL;
	
	public PhoneInfoProvider(Context context) {
		this.context = context;
		capturePhoneInformations();
	}

	private void capturePhoneInformations() {
		screenSize = captureScreenSize();
	}

	private Integer captureScreenSize() {
		
		int screenSize = getContext().getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
		Integer deficeScreen = null;
		
		switch (screenSize) {
		case Configuration.SCREENLAYOUT_SIZE_LARGE:
			deficeScreen = SCREEN_LARGE;
			break;
		case Configuration.SCREENLAYOUT_SIZE_NORMAL:
			deficeScreen = SCREEN_NORMAL;
			break;
		case Configuration.SCREENLAYOUT_SIZE_XLARGE:
			deficeScreen = SCREEN_XLARGE;
			break;
		case Configuration.SCREENLAYOUT_SIZE_SMALL:
			deficeScreen = SCREEN_SMALL;
			break;
		case Configuration.SCREENLAYOUT_SIZE_UNDEFINED:
			deficeScreen = SCREEN_UNDEFINED;
			break;
			
		default:
			break;
		}
		
		return deficeScreen;
	}
	
	protected Context getContext(){
		return context;
	}

	public Integer getScreenSize() {
		return screenSize;
	}

}
