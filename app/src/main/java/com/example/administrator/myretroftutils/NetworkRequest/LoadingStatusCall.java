package com.example.administrator.myretroftutils.NetworkRequest;

/**
 * Created by 贾帅帅 on 2016/7/12.
 */
public interface LoadingStatusCall {
    void showMyLoading();

    void hideMyLoading();

    void goToLogin();//登录超时

    void requestToast(String msg);
}
