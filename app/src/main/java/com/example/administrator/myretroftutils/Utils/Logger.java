package com.example.administrator.myretroftutils.Utils;

import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.myretroftutils.Constants;


/**
 * Log工具，用于控制Log是否显示
 * 
 * @author daizhenliang
 */
public class Logger {

	public static void e(String tag, String msg) {
		if (Constants.IS_SHOW_LOG) {
			if(null!=msg&&!TextUtils.isEmpty(msg)) {
				Log.e(tag, msg);
			}else{
				Log.e(tag, "日志工具类得到msg为空");
			}
		}
	} 

	public static void w(String tag, String msg) {
		if (Constants.IS_SHOW_LOG) {
			Log.w(tag, msg);
		}
	}

	public static void w(String tag, String msg, Exception e) {
		if (Constants.IS_SHOW_LOG) {
			Log.w(tag, msg, e);
		}
	}

	public static void i(String tag, String msg) {
		if (Constants.IS_SHOW_LOG) {
			Log.i(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (Constants.IS_SHOW_LOG) {
			Log.d(tag, msg);
		}
	}

	public static void v(String tag, String msg) {
		if (Constants.IS_SHOW_LOG) {
			Log.v(tag, msg);
		}
	}
	
	public static void e(String tag, String msg, Throwable tr) {
		if (Constants.IS_SHOW_LOG) {
			Log.e(tag, msg, tr);
		}
	} 
}
