package com.example.administrator.myretroftutils.NetworkRequest;


import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 贾帅帅 on 2016/6/28.
 */
public interface NetworkRequestApi {
    //理财超市
    @POST("loan/newProduct")
    Observable<TotalBean> newProduct(@Body Map<String, String> userParms);
}
