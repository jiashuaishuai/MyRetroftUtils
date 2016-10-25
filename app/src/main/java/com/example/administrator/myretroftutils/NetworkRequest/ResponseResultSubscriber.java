package com.example.administrator.myretroftutils.NetworkRequest;

import android.app.Activity;
import android.net.ConnectivityManager;


import com.example.administrator.myretroftutils.App;
import com.example.administrator.myretroftutils.Utils.Logger;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.exceptions.CompositeException;

/**
 * Created by 贾帅帅 on 2016/6/30.
 */
public class ResponseResultSubscriber<T extends BaseBean> extends Subscriber<T> {
    private ResponseCall call;
    private LoadingStatusCall loadingStatusCall;
    private String TAG = "ResponseResultSubscriber";
    private LoadingCall loadingCall;
    private ToastCall toastCall;
    private GoToLoginCall goToLoginCall;

    /**
     * @param call
     * @param loadingStatusCall 加载匡，toast，登录超时统一回调
     */
    public ResponseResultSubscriber(ResponseCall call, LoadingStatusCall loadingStatusCall) {
        this.call = call;
        this.loadingStatusCall = loadingStatusCall;
    }

    /**
     * @param call
     * @param loadingCall   加载匡
     * @param toastCall     toast
     * @param goToLoginCall 登录超时
     */
    public ResponseResultSubscriber(ResponseCall call, LoadingCall loadingCall, ToastCall toastCall, GoToLoginCall goToLoginCall) {
        this.call = call;
        this.loadingCall = loadingCall;
        this.toastCall = toastCall;
        this.goToLoginCall = goToLoginCall;
    }


    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */

    @Override
    public void onStart() {
        super.onStart();
        if (loadingStatusCall != null)
            loadingStatusCall.showMyLoading();
        if (loadingCall != null)
            loadingCall.showMyLoading();

    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
        onCancelLoading();
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        String code;
        String msg;
        if (!checkNetWork()) {
            code = "无法连接到网络";
            msg = "网络无法连接，请检查当前网络";
        } else if (e instanceof ConnectException) {//请求超时
            code = "请求超时";
            msg = "服务器请求超时，请稍后再试";
        }
        if (e instanceof CompositeException) {
            code = "无法连接到网络";
            msg = "网络无法连接，请检查当前网络";
            Logger.i(TAG, "CompositeException");
        } else if (e instanceof SocketTimeoutException) {//响应超时
            code = "响应超时";
            msg = "服务器响应超时，请稍后再试";
        } else if (e instanceof TimeoutException) {
            code = "服务器链接超时";
            msg = "当前网络不稳定，请稍后再试";
        } else if (e instanceof RetrofitErrorException) {//服务器返回数据异常
            RetrofitErrorException error = (RetrofitErrorException) e;
            code = error.getCode();
            msg = error.getMessage();
            //登录超时回调
            if (error.getCode().equals("-0001")) {
                if (loadingStatusCall != null) {
                    loadingStatusCall.requestToast(msg);
                    loadingStatusCall.goToLogin();
                    onCancelLoading();
                    return;
                }
                if (goToLoginCall != null) {
                    if (toastCall != null)
                        toastCall.requestToast(msg);
                    goToLoginCall.goToLogin();
                    onCancelLoading();
                    return;
                }
            }
            Logger.e("ResponseResultSubscriber", error.getMessage() + "--" + error.getCode());

        } else {//其他异常
            Logger.e(TAG, "服务器返回数据为空" + e.getMessage() + "-----------" + e.getLocalizedMessage());
            code = e.getLocalizedMessage();
            msg = e.getMessage();
        }
        if (loadingStatusCall != null)
            loadingStatusCall.requestToast(msg);
        if (toastCall != null)
            toastCall.requestToast(msg);
        if (call != null)
            call.failure(code, msg);

        onCancelLoading();

    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        if (call != null)
            call.succeed(t);
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    public void onCancelLoading() {
        if (loadingStatusCall != null)
            loadingStatusCall.hideMyLoading();
        if (loadingCall != null)
            loadingCall.hideMyLoading();
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    /**
     * 判断有无网络连接
     *
     * @return
     */
    public boolean checkNetWork() {
        ConnectivityManager con =
                (ConnectivityManager) App.getApplication().getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .isConnectedOrConnecting();
        boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .isConnectedOrConnecting();
        if (wifi | internet) {
            // 执行相关操作
            return true;
        } else {
            return false;
        }
    }

}
