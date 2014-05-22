package com.wwforever.eclipsebuildunity3d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver
{
	private static final String TAG = "20083271:EmulatorRe";
	public String type="";
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "receive");
        	MainActivity.isDisapper=true;
    }
}