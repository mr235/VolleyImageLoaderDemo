package com.mr235.volleyimageloaderdemo.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.mr235.volleyimageloaderdemo.R;
import com.mr235.volleyimageloaderdemo.utils.Pictures;
import com.mr235.volleyimageloaderdemo.utils.VolleyUtil;

public class ImageRequestActivity extends AppCompatActivity {

	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_request);
		initView();
		initData();
	}

	private void initView() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mImageView = (ImageView) findViewById(R.id.iv);
	}

	private void initData() {
		String url = Pictures.pictures[0];

		ImageRequest request = new ImageRequest(url,
				new Response.Listener<Bitmap>() {
					@Override
					public void onResponse(Bitmap bitmap) {
						mImageView.setImageBitmap(bitmap);
					}
				}, 0, 0, ImageView.ScaleType.CENTER_INSIDE, null,
				new Response.ErrorListener() {
					public void onErrorResponse(VolleyError error) {
						mImageView.setImageResource(R.drawable.ic_pic_error);
					}
				});
		VolleyUtil.getInstance(this).addToRequestQueue(request);
	}

}
