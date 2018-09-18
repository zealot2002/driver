package com.zzy.welcome;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.zzy.common.constants.ScmConstants;
import com.zzy.common.constants.SpConstants;
import com.zzy.core.serverCenter.SCM;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.flysp.core.spHelper.SPHelper;


public class WelcomeActivity extends AppCompatActivity {
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
                entryNext();
            }

        }, SHOW_TIME);
    }

    private void entryNext() {
        try {
            int qbType = SPHelper.getInt(SpConstants.QUESTION_BANK,0);
            String scmAction = ScmConstants.API_ENTRY_HOME;
            if(qbType == 0){
                scmAction = ScmConstants.API_ENTRY_QUESTION_BANK;
            }

            SCM.getInstance().req(WelcomeActivity.this,scmAction,new ScCallback() {
                @Override
                public void onCallback(boolean b, Bundle data, String tag) {
                    finish();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
