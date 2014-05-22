package com.wwforever.eclipsebuildunity3d;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity
{
	private static final String TAG = "20083271:Emulator";
	public static boolean isDisapper = false;
	public String itemType="0";
	public String diceNumber="2";
	public String yutNumber="3";
	public String backYutNumber="1";
	public String packageName="";
	public String ableButton="1";
	public String activityName="";
	public static boolean isSend=false;
	
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "call unityDice");
  }

  public synchronized void JNICall_U(String strMsg, Activity activity)
  {
		// send emulator value operator
		if (isSend == false) {
			isSend = true;
			Intent intentIsStop = new Intent();
			intentIsStop.setAction("android.intent.action.SUPER");
			intentIsStop.putExtra("diceNumber", strMsg); 
			Log.i(TAG, "receiveNumber : " + strMsg);
			sendBroadcast(intentIsStop);
		}
		
		// call disappear operator
		if (isDisapper == true) {
			isDisapper = false;
			Log.i(TAG, "back game");
			// change game activity
			ComponentName compName = new ComponentName(packageName,
					activityName);
			Log.i(TAG, "packageName : " + packageName);
			Log.i(TAG, "activityName : " + activityName);
			Intent intent = new Intent();
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			//1 -- x
			//intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			//3
			intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_J",
					"a");
			intent.setComponent(compName);
			activity.startActivity(intent);
			Log.e(TAG, "intent data string contents : " + intent.getDataString());
			Log.e(TAG, "intent data string contents : " + intent.toString());
		}
  }
  
  //send initial value to unity
  public void JNICall_V()
  {
	  Intent intentGetClassName = this.getIntent();
	  ableButton = intentGetClassName.getExtras().getString("ableButton");
	  packageName = intentGetClassName.getExtras().getString("getPackageName");
	  activityName = intentGetClassName.getExtras().getString("activity");
	  itemType = intentGetClassName.getExtras().getString("itemType");
	  diceNumber = intentGetClassName.getExtras().getString("setDiceNumber");
	  yutNumber = intentGetClassName.getExtras().getString("setYutNumber");
	  backYutNumber = intentGetClassName.getExtras().getString("setBackYutNumber");
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_K", diceNumber);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_B", ableButton);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_T", itemType);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_Y", yutNumber);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_X", backYutNumber);
	  Log.i(TAG, "diceNumber : " + diceNumber);
	  Log.i(TAG, "yutNumber : " + yutNumber);
	  Log.i(TAG, "backYutNumber : " + backYutNumber);
	  Log.i(TAG, "itemType : " + itemType);
  }
  
  //initial isSend value
  public void JNICall_F()
  {
	  isSend=false;
  }
}