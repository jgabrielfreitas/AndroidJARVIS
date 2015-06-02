package br.com.jarvis.utils;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class StopWatch extends Timer {
	
	private long startTime = 0;
	private long endTime   = 0;
	private long duration  = 0;
	
	public StopWatch() {
	}

	public void startCount() {
		startTime = System.currentTimeMillis();
	}

	private void stopCount(){
		endTime = System.currentTimeMillis();
	}
	
	public String getTime(){
		
		stopCount();
		
		duration = (endTime - startTime);
		
		long min = TimeUnit.MILLISECONDS.toMinutes(duration);
		long sec = TimeUnit.MILLISECONDS.toSeconds(duration);
		
		return String.format("%dm %ds", min,sec);
	}
	
	public void resetStopWatch() {
		startTime = 0;
		endTime   = 0;
		duration  = 0;
	}
	
}
