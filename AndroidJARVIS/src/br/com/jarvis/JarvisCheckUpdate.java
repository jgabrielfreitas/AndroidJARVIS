package br.com.jarvis;

import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.AppsRequest;
import com.gc.android.market.api.model.Market.AppsResponse;
import com.gc.android.market.api.model.Market.ResponseContext;

import android.provider.Settings.Secure;
import android.util.Log;

//class not working yet
public class JarvisCheckUpdate {

	private JarvisSession jarvisSession;
	private String user;
	private String password;

	// NEED PUT IT TO WORK!
	public String check() {
		String jsonResponse = null;
		
		MarketSession session = new MarketSession();
		session.login(getUser(), getPassword());
		session.getContext().setAndroidId(Secure.getString(getJarvisSession().getContext().getContentResolver(),Secure.ANDROID_ID));
		String query = getJarvisSession().getApplicationInfoProvider().getApplicationPackage();
		AppsRequest appsRequest = AppsRequest.newBuilder()
		                                	 .setQuery(query)
		                                	 .setStartIndex(0).setEntriesCount(10)
		                                	 .setWithExtendedInfo(true)
		                                	 .build();
		
		session.append(appsRequest, new Callback<AppsResponse>() {
	         public void onResult(ResponseContext context, AppsResponse response) {
	                  Log.d("JARVIS_UPDATE", "toString: " + response.toString());
	                  Log.d("JARVIS_UPDATE", "All fields" + response.getAllFields());
	         }
		});
		session.flush();

		return jsonResponse;
	}

	public void setJarvisSession(JarvisSession jarvisSession) {
		this.jarvisSession = jarvisSession;
	}

	public JarvisSession getJarvisSession() {
		return jarvisSession;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
