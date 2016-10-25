package com.example.administrator.myretroftutils.NetworkRequest;

import android.text.TextUtils;

/**
 * Created by 贾帅帅 on 2016/6/28.
 */
public class BaseBean {
    public String code;
    public String msg;
    public String message;
    public String ret_code;
    public String ret_msg;

    /**
     * private,不能直接取msg，只能通过get来获取，
     */
    public String getCode() {
        if (!TextUtils.isEmpty(code))
            return code;
        if (!TextUtils.isEmpty(ret_code))
            return ret_code;
        return "code定义错误";
    }

    public String getMsg() {
        if (!TextUtils.isEmpty(msg))
            return msg;
        if (!TextUtils.isEmpty(message))
            return message;
        if (!TextUtils.isEmpty(ret_msg))
            return ret_msg;
        return "msg定义错误";
    }
}
