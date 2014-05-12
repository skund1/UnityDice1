package com.wwforever.eclipsebuildunity3d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver
{
	public String type="";
	public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "android.intent.action.SUPERSK", Toast.LENGTH_LONG).show();
		//type = intent.getExtras().getString("type");
		Log.d("20093342", "receiver");
		//Log.d("20093342", "type =" + type);
        //MainActivity a=new MainActivity();
        //if(type.equals("1")==true)
        	MainActivity.isDisapper=true;
        	MainActivity.isSend=false;
        //else if(type.equals("2")==true){
        	//Log.d("20093342", "call finish");
        	//MainActivity.isClear="1";
        	//a.finish();
        	//MainActivity fActivity=(MainActivity)MainActivity.mActivity;
        	//fActivity.finish();
        	//Log.d("20093342", "end finish");
        //}
        	
        	
    }
	/*
  public static void isStop(){
	  MainActivity.isDisapper = true;
  }
  */
}