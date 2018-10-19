package com.sample.tim.sampleproject.sample.baseFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.tim.sampleproject.sample.baseActivity.SampleAppActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by tangyangkai on 16/5/4.
 */
public abstract class SampleBaseFragment extends Fragment {

    protected SampleAppActivity mActivity;
    private Unbinder unbinder;

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取布局文件ID
    protected abstract int getLayoutId();

    //获取宿主Activity
    protected SampleAppActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (SampleAppActivity) activity;
    }

    //添加fragment
    protected void addFragment(SampleBaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    //移除fragment
    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        setToolbarDefault();
        initView(view, savedInstanceState);
        return view;
    }

    private void setToolbarDefault() {
        // TODO: 2018/10/16  设置baseToolbar里面的显示和点击事件
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}