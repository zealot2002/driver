package com.zzy.welcome;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.zzy.common.constants.ScmConstants;
import com.zzy.commonlib.log.MyLog;
import com.zzy.core.serverCenter.SCM;
import com.zzy.core.serverCenter.ScCallback;


public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "WelcomeActivity";
    private final int SHOW_TIME = 3000; //开屏页时间
    private static Handler handler;
    /*******************************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_main);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                entryMain();
            }

        }, SHOW_TIME);
    }

    private void entryMain() {
        try {
//            Bundle bundle = new Bundle();
//            bundle.putString(ParamConstants.PARAM_TITLE,"北京海淀驾校");
//            bundle.putString(ParamConstants.PARAM_DESC,"北京市昌平区回龙观西大街104号");
//            bundle.putDouble(ParamConstants.PARAM_LAT,39.915071);
//            bundle.putDouble(ParamConstants.PARAM_LNG,116.403907);

            SCM.getInstance().req(WelcomeActivity.this, ScmConstants.API_ENTRY_HOME,new ScCallback() {
                @Override
                public void onCallback(boolean b, Bundle data, String tag) {
                    if(b){
                        finish();
                    }else {
                        MyLog.e(TAG,"return:"+data);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
