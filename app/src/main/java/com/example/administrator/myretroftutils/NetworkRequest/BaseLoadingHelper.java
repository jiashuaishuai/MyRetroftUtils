package com.example.administrator.myretroftutils.NetworkRequest;

/**
 * Created by 贾帅帅 on 2016/7/21.
 */
public class BaseLoadingHelper {
    public LoadingStatusCall mCall;
    public LoadingCall loadingCall;
    public ToastCall toastCall;
    public GoToLoginCall goToLoginCall;

    /**
     * 绑定这个loading
     *
     * @param call
     */
    public void callAttach(LoadingStatusCall call, LoadingCall loadingCall, ToastCall toastCall, GoToLoginCall goToLoginCall) {
        this.mCall = call;
        this.loadingCall = loadingCall;
        this.toastCall = toastCall;
        this.goToLoginCall = goToLoginCall;
    }

    /**
     * 解除绑定
     */
    public void callDettach() {
        mCall = null;
    }
}
