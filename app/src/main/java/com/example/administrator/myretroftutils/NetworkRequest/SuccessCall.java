package com.example.administrator.myretroftutils.NetworkRequest;

import android.util.Log;

/**
 * Created by 贾帅帅 on 2016/7/1.
 */
public abstract class SuccessCall<T extends BaseBean> implements ResponseCall<T> {
    @Override
    public void failure(String code, String msg) {
        Log.e("SuccessCall", "失败回调：" + code + ":" + msg);
    }

    @Override
    public abstract void succeed(T t);
}
