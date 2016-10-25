package com.example.administrator.myretroftutils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.example.administrator.myretroftutils.MVPUtils.BasePresenter;
import com.example.administrator.myretroftutils.NetworkRequest.GoToLoginCall;
import com.example.administrator.myretroftutils.NetworkRequest.LoadingCall;
import com.example.administrator.myretroftutils.NetworkRequest.LoadingStatusCall;
import com.example.administrator.myretroftutils.NetworkRequest.RequestApiHelper;
import com.example.administrator.myretroftutils.NetworkRequest.ToastCall;
import com.example.administrator.myretroftutils.Utils.LoadingDialogView;
import com.example.administrator.myretroftutils.Utils.Logger;
import com.example.administrator.myretroftutils.Utils.SharedPreferencesUtils;
import com.example.administrator.myretroftutils.Utils.ToastUtil;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class BaseActivity<V, T extends BasePresenter<V>> extends Activity implements LoadingStatusCall, LoadingCall, ToastCall, GoToLoginCall {
    private static final String TAG = "BaseActivity";
    //积累封装加载匡和登录超时，sharedPreferencesUtils获取
    public SharedPreferencesUtils sharedPreferencesUtils;
    private LoadingDialogView loadingDialogView;
    public RequestApiHelper requestApiHelper;
    public T presenter;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        sharedPreferencesUtils = SharedPreferencesUtils.getSharedPreferencesUtils(mContext);
        requestApiHelper = new RequestApiHelper();
        requestApiHelper.callAttach(this, this, this, this);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach((V) this, requestApiHelper, this);
            presenter.attachSharedPreferencesUtils(sharedPreferencesUtils);
        }
    }



    public T initPresenter() {
        return null;
    }

    /**
     * 加载框显示
     */
    @Override
    public void showMyLoading() {
        if (loadingDialogView == null)
            loadingDialogView = new LoadingDialogView(this);
        loadingDialogView.show();
    }

    /**
     * 加载框隐藏
     */
    @Override
    public void hideMyLoading() {
        if (loadingDialogView != null)
            loadingDialogView.dismiss();
        loadingDialogView = null;
    }

    /**
     * 登录超时调用，这里写登录超时跳转登录页面代码
     */
    @Override
    public void goToLogin() {
        Logger.e(TAG, "登录超时");
    }

    @Override
    public void requestToast(String msg) {

        ToastUtil.showToast(mContext, msg);
    }

    /**
     * 销毁时清除
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        requestApiHelper.callDettach();
        requestApiHelper = null;
        loadingDialogView = null;
        sharedPreferencesUtils = null;
        if (presenter != null)
            presenter.dettach();
    }
}
