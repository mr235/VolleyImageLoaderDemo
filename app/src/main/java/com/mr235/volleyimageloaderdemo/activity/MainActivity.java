package com.mr235.volleyimageloaderdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mr235.volleyimageloaderdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		findViewById(R.id.bt_image_request).setOnClickListener(this);
		findViewById(R.id.bt_image_loader).setOnClickListener(this);
		findViewById(R.id.bt_network_imageview).setOnClickListener(this);
		findViewById(R.id.bt_recycler_view).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		Intent intent = null;
		switch (id) {
			case R.id.bt_image_request:
				intent = new Intent(this, ImageRequestActivity.class);
				startActivity(intent);
				break;
			case R.id.bt_image_loader:
				intent = new Intent(this, ImageLoaderActivity.class);
				startActivity(intent);
				break;
			case R.id.bt_network_imageview:
				intent = new Intent(this, NetworkImageViewActivity.class);
				startActivity(intent);
				break;
			case R.id.bt_recycler_view:
				intent = new Intent(this, RecyclerViewActivity.class);
				startActivity(intent);
				break;
			default:
				break;
		}
	}
}