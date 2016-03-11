package com.mr235.volleyimageloaderdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.mr235.volleyimageloaderdemo.R;
import com.mr235.volleyimageloaderdemo.utils.Pictures;
import com.mr235.volleyimageloaderdemo.utils.VolleyUtil;

public class ImageLoaderActivity extends AppCompatActivity {

	private ImageView mImageView;

	private ImageLoader mImageLoader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_loader);
		initView();
		initData();
	}

	private void initView() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mImageView = (ImageView) findViewById(R.id.iv);
	}

	private void initData() {

// Get the ImageLoader through your singleton class.
		mImageLoader = VolleyUtil.getInstance(this).getImageLoader();
		mImageLoader.get(Pictures.pictures[1], ImageLoader.getImageListener(mImageView,
				R.drawable.ic_pic_default, R.drawable.ic_pic_error));
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
