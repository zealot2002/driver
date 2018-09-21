package com.zzy.home.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzy.common.utils.ActivityUtils;
import com.zzy.home.R;
import com.zzy.home.base.BaseHomeTitleBarLoadingFragment;
import com.zzy.home.view.CityActivity;

/**
 * @author zzy
 * @date 2018/9/14
 */

public class SchoolFragment extends BaseHomeTitleBarLoadingFragment{


/****************************************************************************************************/
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setCity("北京");
        setSelectCityClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(getActivity(), CityActivity.class);
            }
        });

//        presenter = new PagePresenter(this);
//        presenter.getPageData(context, pageCode,true,1);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_school_fragment;
    }


    @Override
    public void onStart() {
        super.onStart();
        updateUI(null);
    }

    @Override
    public void updateUI(Object o) {
        super.updateUI(o);

    }
}
