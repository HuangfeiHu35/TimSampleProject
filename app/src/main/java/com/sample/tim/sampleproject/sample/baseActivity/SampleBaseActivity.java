package com.sample.tim.sampleproject.sample.baseActivity;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.sample.tim.sampleproject.sample.baseFragment.SampleBaseFragment;


public abstract class SampleBaseActivity extends AppCompatActivity {

    //布局文件ID
    protected abstract int getContentViewId();

    //布局中Fragment的ID
    protected abstract int getFragmentContentId();

    //添加fragment
    public void addFragment(SampleBaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    //移除fragment
    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
