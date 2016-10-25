package com.example.administrator.myretroftutils.MVPUtils;

import android.content.Context;
import android.content.Intent;

import com.example.administrator.myretroftutils.NetworkRequest.RequestApiHelper;
import com.example.administrator.myretroftutils.Utils.SharedPreferencesUtils;


/**
 * Created by 贾帅帅 on 2016/7/22.
 */
public class BasePresenter<T> {
    public T mView;
    public RequestApiHelper requestApiHelper;
    public SharedPreferencesUtils sharedPreferencesUtils;
    public Context mContext;

    /**
     * 绑定这个activity
     *
     * @param mView
     */
    public void attach(T mView, RequestApiHelper requestApiHelper, Context context) {
        this.mView = mView;
        this.requestApiHelper = requestApiHelper;
        mContext = context;
    }

    public void attachSharedPreferencesUtils(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    /**
     * 解除绑定
     */
    public void dettach() {
        mView = null;
        requestApiHelper = null;
        sharedPreferencesUtils = null;
        mContext = null;
    }


    /**
     * 起始位置
     *
     * @param endPoint 目标位置
     */
    public void actionStart(Class<?> endPoint) {
        mContext.startActivity(new Intent(mContext, endPoint));
    }
}
