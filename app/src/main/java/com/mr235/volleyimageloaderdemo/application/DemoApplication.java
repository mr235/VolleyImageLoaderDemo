package com.mr235.volleyimageloaderdemo.application;

import android.app.Application;

import com.mr235.volleyimageloaderdemo.utils.VolleyUtil;

/**
 * Created by Administrator on 2016/3/10.
 */
public class DemoApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		VolleyUtil.getInstance(this).createImageCache();
	}
}
