package br.com.provider;

import android.content.Context;
import android.content.pm.PackageInfo;

public class ApplicationInfoProvider {
	
	protected Context context;
	private   String  applicationPackage;
	private   String  applicationVersionName;
	private   int     applicationVersionCode;
	
	public ApplicationInfoProvider(Context context) {
		this.context = context;
		captureApplicationInformations();
	}

	private void captureApplicationInformations() {
		PackageInfo packageInfo = new PackageInfo();
		applicationPackage 		= packageInfo.packageName;
		applicationVersionName  = packageInfo.versionName;
		applicationVersionCode  = packageInfo.versionCode;
	}

	protected Context getContext() {
		return context;
	}

	public String getApplicationPackage() {
		return applicationPackage;
	}

	public String getApplicationVersionName() {
		return applicationVersionName;
	}

	public int getApplicationVersionCode() {
		return applicationVersionCode;
	}

}
