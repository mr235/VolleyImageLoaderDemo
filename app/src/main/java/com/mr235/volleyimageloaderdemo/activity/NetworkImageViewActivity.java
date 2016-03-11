package com.mr235.volleyimageloaderdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mr235.volleyimageloaderdemo.R;
import com.mr235.volleyimageloaderdemo.utils.Pictures;
import com.mr235.volleyimageloaderdemo.utils.VolleyUtil;

public class NetworkImageViewActivity extends AppCompatActivity {

	private NetworkImageView mNetworkImageView;

	private ImageLoader mImageLoader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network_image_view);
		initView();
		initData();
	}

	private void initView() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mNetworkImageView = (NetworkImageView) findViewById(R.id.iv);
	}

	private void initData() {

// Get the ImageLoader through your singleton class.
		mImageLoader = VolleyUtil.getInstance(this).getImageLoader();
		mNetworkImageView.setImageUrl(Pictures.pictures[3], mImageLoader);
		mNetworkImageView.setErrorImageResId(R.drawable.ic_pic_error);
		mNetworkImageView.setDefaultImageResId(R.drawable.ic_pic_default);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
