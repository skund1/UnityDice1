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
	public static String isClear = "0";
	public String itemType="0";
	public String diceNumber="2";
	public String yutNumber="3";
	public String backYutNumber="1";
	public String packageName="";
	public String ableButton="1";
	public String activityName="";
	public static MainActivity mActivity;
	public static boolean isSend=false;
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    mActivity= MainActivity.this;
  }

  public void JNICall_U(String strMsg, Activity activity)
  {
	  if(isSend==false){
	  isSend=true;
	  Intent intentIsStop = new Intent();
	  intentIsStop.setAction("android.intent.action.SUPER");
	  intentIsStop.putExtra("diceNumber", strMsg); // "명칭", "실제값"
	  sendBroadcast(intentIsStop);
	  }
	  
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
	  itemType = intentGetClassName.getExtras().getString("itemType");
	  diceNumber = intentGetClassName.getExtras().getString("setDiceNumber");
	  yutNumber = intentGetClassName.getExtras().getString("setYutNumber");
	  backYutNumber = intentGetClassName.getExtras().getString("setBackYutNumber");
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_K", diceNumber);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_B", ableButton);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_T", itemType);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_Y", yutNumber);
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_X", backYutNumber);
  }
  
  public void JNICall_F()
  {
	  UnityPlayer.UnitySendMessage("PluginEclipseManager", "JNICall_C", isClear);
  }
  
}