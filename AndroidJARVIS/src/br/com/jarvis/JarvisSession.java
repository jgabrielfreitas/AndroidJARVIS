package br.com.jarvis;

import br.com.provider.ApplicationInfoProvider;
import br.com.provider.PhoneInfoProvider;
import android.content.Context;

public class JarvisSession {

	private Context context;
	private ApplicationInfoProvider applicationInfoProvider;
	private PhoneInfoProvider phoneInfoProvider;

	public JarvisSession(Context context) {
		this.context = context;
		this.applicationInfoProvider = new ApplicationInfoProvider(context);
		this.phoneInfoProvider = new PhoneInfoProvider(context);
	}

	public ApplicationInfoProvider getApplicationInfoProvider() {
		return applicationInfoProvider;
	}

	public PhoneInfoProvider getPhoneInfoProvider() {
		return phoneInfoProvider;
	}
	
	public Context getContext(){
		return context;
	}

}
