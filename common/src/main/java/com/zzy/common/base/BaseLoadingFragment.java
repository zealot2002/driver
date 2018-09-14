package com.zzy.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.zzy.common.R;
import com.zzy.common.widget.LoadingHelper;
import com.zzy.commonlib.base.BaseActivity;
import com.zzy.commonlib.base.BaseFragment;
import com.zzy.commonlib.base.BaseLoadingView;

/**
 * zzy
 */

abstract public class BaseLoadingFragment extends BaseFragment implements BaseLoadingView {
    private LoadingHelper loadingDialog;
    private Context context;
    private View root,contentView;
    private FrameLayout flLoadingRoot;
    private RelativeLayout rlDisconnect;
/***************************************************************************************************/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.base_loading_fragment, container, false);
        initViews();
        return root;
    }
    protected void initViews(){
        flLoadingRoot = root.findViewById(R.id.flLoadingRoot);
        rlDisconnect = root.findViewById(R.id.rlDisconnect);
        rlDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reload(false);
            }
        });
        hideAll();

    }
    private void hideAll(){
        for(int i=0;i<flLoadingRoot.getChildCount();i++){
            flLoadingRoot.getChildAt(i).setVisibility(View.GONE);
        }
    }

    public void showLoading(String s) {
        if(loadingDialog!=null){
            loadingDialog.showLoading(s);
        }
    }

    @Override
    public void showLoading() {
        showLoading("请稍候");
    }

    public void closeLoading() {
        if(loadingDialog!=null){
            loadingDialog.closeLoading();
        }
    }

    @Override
    public void showDisconnect() {
        hideAll();
        rlDisconnect.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadingError() {
        showDisconnect();
    }
    //子类复写此方法
    @Override
    public void reload(boolean b) {}

    //子类复写此方法

    @CallSuper
    @Override
    public void updateUI(Object o) {
        if(contentView==null){
            contentView = getActivity().getLayoutInflater().inflate(getLayoutId(),null);
            flLoadingRoot.addView(contentView);
        }
        contentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        closeLoading();
        loadingDialog = null;
    }
    protected abstract int getLayoutId();
}
