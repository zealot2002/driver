package com.zzy.map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.zzy.common.constants.ParamConstants;
import com.zzy.commonlib.base.BaseActivity;

public class MapActivity extends BaseActivity {
	private static final String TAG = "MapActivity";
	private double lng,lat;
	private String title,desc;

	private MapView mapView;
	private TextView tvTitle,tvDesc;
	private FrameLayout flClose;
	private BaiduMap mBaiduMap;
/******************************************************************************************************/

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_map_activity);

		initData();
		initViews();
	}

	private void initData() {
		Bundle bundle = getIntent().getExtras();
		try {
			lng = bundle.getDouble(ParamConstants.PARAM_LNG);
			lat = bundle.getDouble(ParamConstants.PARAM_LAT);
			title = bundle.getString(ParamConstants.PARAM_TITLE);
			desc = bundle.getString(ParamConstants.PARAM_DESC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initViews() {
		//获取地图控件引用
		tvTitle = findViewById(R.id.tvTitle);
		tvDesc = findViewById(R.id.tvDesc);
		flClose = findViewById(R.id.flClose);
		tvTitle.setText(title);
		tvDesc.setText(desc);
		flClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		initMap();
	}

	private void initMap() {
		mapView = findViewById(R.id.mapView);
		mBaiduMap = mapView.getMap();
		mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
		mBaiduMap.setMyLocationEnabled(true);

		BitmapDescriptor icon = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_marka);
		LatLng point = new LatLng(lat,lng);

		OverlayOptions options = new MarkerOptions().icon(icon).position(point);
		mBaiduMap.addOverlay(options);
		// 定义地图状态
		MapStatus mMapStatus = new MapStatus.Builder().target(point).zoom(18)
				.build();
		MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory
				.newMapStatus(mMapStatus);
		// 改变地图状态
		mBaiduMap.setMapStatus(mMapStatusUpdate);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mapView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mapView.onResume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

}
