package com.sample.tim.sampleproject.sample.baseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.sample.tim.sampleproject.R;
import com.sample.tim.sampleproject.sample.baseFragment.SampleBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tangyangkai on 16/5/4.
 */
public abstract class SampleAppActivity extends SampleBaseActivity {

    @BindView(R.id.base_toolbar)
    Toolbar baseToolbar;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_right)
    ImageView ivToolbarRight;
    @BindView(R.id.tv_toolbar_right)
    TextView tvToolbarRight;

    //获取第一个fragment
    protected abstract SampleBaseFragment getFirstFragment();

    //获取Intent
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);

        baseToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });

        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        //避免重复添加Fragment
//        if (null == getSupportFragmentManager().getFragments()) {
        SampleBaseFragment firstFragment = getFirstFragment();
        if (null != firstFragment) {
            addFragment(firstFragment);
        }
//        }

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_base;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }


    public Toolbar getBaseToolbar() {
        return baseToolbar;
    }


    public void setToolbarTitle(int title) {
        setTitleDefault();
        tvToolbarTitle.setText(title);
    }

    private void setTitleDefault() {
        tvToolbarTitle.setCompoundDrawablesWithIntrinsicBounds(null,
                null, null, null);
        tvToolbarTitle.setVisibility(View.VISIBLE);
        tvToolbarRight.setVisibility(View.GONE);
        ivToolbarRight.setVisibility(View.GONE);
    }

    public void setToolbarTitle(String title) {
        setTitleDefault();
        tvToolbarTitle.setText(title);
    }


    public void setIvToolbarRightImage(int image) {
        ivToolbarRight.setVisibility(View.VISIBLE);
        tvToolbarRight.setVisibility(View.GONE);
        ivToolbarRight.setImageResource(image);
    }

    public void setTvToolbarRight(int rightStr) {
        tvToolbarRight.setVisibility(View.VISIBLE);
        ivToolbarRight.setVisibility(View.GONE);
        tvToolbarRight.setText(rightStr);
    }

    public void setTvToolbarRight(String rightStr) {
        tvToolbarRight.setVisibility(View.VISIBLE);
        ivToolbarRight.setVisibility(View.GONE);
        tvToolbarRight.setText(rightStr);
    }

    public TextView getTvToolbarRight() {
        return tvToolbarRight;
    }

    public TextView getTvToolbarTitle() {
        return tvToolbarTitle;
    }

    public ImageView getIvToolbarRight() {
        return ivToolbarRight;
    }
}

