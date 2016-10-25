package com.example.administrator.myretroftutils.NetworkRequest;

/**
 * Created by 贾帅帅 on 2016/6/30.
 */
public interface ResponseCall<T extends BaseBean> {
    /**
     * 网络请求成功，返回json
     *
     * @param t
     */
    void succeed(T t);

    /**
     * 网络请求失败
     */
    //code  message
    void failure(String code, String msg);

}
