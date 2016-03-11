package com.mr235.volleyimageloaderdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.mr235.volleyimageloaderdemo.R;
import com.mr235.volleyimageloaderdemo.adapter.RecyclerViewAdapter;
import com.mr235.volleyimageloaderdemo.utils.Pictures;

public class RecyclerViewActivity extends AppCompatActivity {

	private RecyclerView mRv;
	private LinearLayoutManager mLayoutManager;
	private RecyclerViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler_view);
		initView();
		initData();
	}

	private void initView() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mRv = (RecyclerView) findViewById(R.id.rv);
	}

	private void initData() {
// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(this);
		mRv.setLayoutManager(mLayoutManager);

		// specify an adapter (see also next example)
		mAdapter = new RecyclerViewAdapter(Pictures.thumbnails, this);
		mRv.setAdapter(mAdapter);
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
