package com.zzy.home.view.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzy.common.utils.StatusBarUtils;
import com.zzy.commonlib.base.BaseFragment;
import com.zzy.home.R;
import com.zzy.home.base.BaseHomeTitleBarLoadingFragment;

/**
 * @author zzy
 * @date 2018/9/14
 */

public class MineFragment extends BaseFragment {
    private View rootView;

/****************************************************************************************************/
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_mine_fragment, container, false);
        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        presenter = new PagePresenter(this);
//        presenter.getPageData(context, pageCode,true,1);
    }

}
