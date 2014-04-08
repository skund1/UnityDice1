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
	public static boolean isDisapper = false;
	public String diceNumber="";
	public String packageName="";
	public String ableButton="";
	public String activityName="";
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    
  }

  public void JNICall_U(String strMsg, Activity activity)
  {
  
	  Intent intentIsStop = new Intent();
	  intentIsStop.setAction("android.intent.action.SUPER");
	  intentIsStop.putExtra("diceNumber", strMsg); // "명칭", "실제값"
	  sendBroadcast(intentIsStop);
	  
	  if(isDisapper==true){
		  isDisapper=false;
		  
		  //change game activity
		  ComponentName compName = new ComponentName(packageName, activityName);
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_J", "a");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			intent.setComponent(compName);
			activity.startActivity(intent);
	  }
  }
  public void JNICall_V()
  {
	  Intent intentGetClassName = this.getIntent();
	  ableButton = intentGetClassName.getExtras().getString("ableButton");
	  packageName = intentGetClassName.getExtras().getString("getPackageName");
	  activityName = intentGetClassName.getExtras().getString("activity");
	  diceNumber = intentGetClassName.getExtras().getString("setDiceNumber");
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_K", diceNumber);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_B", ableButton);
  }

}