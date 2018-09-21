package com.zzy.home.view;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;

import com.zzy.common.base.BaseTitleBarActivity;
import com.zzy.common.constants.EventConstants;
import com.zzy.common.constants.ParamConstants;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.utils.MyToast;
import com.zzy.common.utils.StatusBarUtils;
import com.zzy.commonlib.base.BaseActivity;
import com.zzy.commonlib.utils.ActivityManager;
import com.zzy.core.serverCenter.SCM;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.home.R;
import com.zzy.home.base.BaseHomeActivity;
import com.zzy.home.view.fragment.CommunityFragment;
import com.zzy.home.view.fragment.ExamFragment;
import com.zzy.home.view.fragment.MineFragment;
import com.zzy.home.view.fragment.SchoolFragment;

public class CityActivity extends BaseTitleBarActivity {


/***********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("城市");
        setOnBackEventListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setupViews();
    }

    private void setupViews() {
        View contentView = View.inflate(this,R.layout.home_city_activity,null);
        getContainer().addView(contentView);
        sendBroadca();
    }

    private void sendBroadca() {
        Intent intent = new Intent();
        intent.setAction(EventConstants.EVENT_ORDER_SUCCESS);
        sendBroadcast(intent);
    }

}
