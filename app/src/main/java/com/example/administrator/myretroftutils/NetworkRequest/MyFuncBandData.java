package com.example.administrator.myretroftutils.NetworkRequest;

import android.text.TextUtils;

import com.example.administrator.myretroftutils.Utils.Logger;
import com.google.gson.Gson;

import org.apaches.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by 贾帅帅 on 2016/6/30.
 */
public class MyFuncBandData<T extends BaseBean> implements Func1<TotalBean, Observable<T>> {
    private static final String TAG = "MyFuncBandData";
    private Class<T> classbean;
    private T bean;
    private String data;
    private String json;

    public MyFuncBandData(Class<T> classbean) {
        this.classbean = classbean;
    }

    /**
     * 这里根据自己公司的json结构进行解析数据
     *
     * @param totalBean
     * @return
     */
    @Override
    public Observable<T> call(TotalBean totalBean) {
        Logger.i(TAG,"到这里。。。。。");
        data = decryptCode(totalBean.data);//解密json串
        Logger.e(TAG, data.toString());
        try {
            JSONObject object = new JSONObject(data);
            if (object.has("data")) {
                JSONObject object1 = object.getJSONObject("data");//剔除最外层data
                json = object1.toString();
            } else {
                json = data;
            }


        } catch (JSONException e) {
            return Observable.error(e);
        }
        if (json != null && !TextUtils.isEmpty(json)) {
            bean = new Gson().fromJson(json, classbean);
            if (bean.getCode().equals("0000")) {
                return Observable.just(bean);
            } else {
                return Observable.error(new RetrofitErrorException(bean.getMsg(), bean.getCode()));
            }
        } else {
            return Observable.error(new NullPointerException("Class MyFuncBandData:response (json) is null!"));
        }
    }

    /**
     * 用来解码  服务器获取到的密文
     *
     * @param ret
     * @return
     */
    public static String decryptCode(String ret) {
        Base64 base642 = new Base64();
        byte[] res = base642.decode(ret.getBytes());
        String srt2;
        try {
            //UTF-8    GB2312
            srt2 = new String(res, "UTF-8");
            return srt2;
        } catch (UnsupportedEncodingException e) {
            Logger.i("baseFragment", "解码失败");
            e.printStackTrace();
            return "";
        }
    }
}
