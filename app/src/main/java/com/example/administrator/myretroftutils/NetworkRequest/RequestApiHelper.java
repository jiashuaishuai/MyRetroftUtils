package com.example.administrator.myretroftutils.NetworkRequest;


import com.example.administrator.myretroftutils.Bean.MarketNewProductBean1;

import java.util.Map;


/**
 * Created by 贾帅帅 on 2016/7/13.
 */
public class RequestApiHelper extends BaseLoadingHelper {


    //理财超市2.3
    public void newProduct(Map<String, String> params, ResponseCall<MarketNewProductBean1> call) {
        RetrofitRequestManger retrofitRequestManger = RetrofitRequestManger.getInstance();
        retrofitRequestManger
                .requestConfig(retrofitRequestManger.initializeRequestApi().newProduct(params),
                        MarketNewProductBean1.class, call, mCall);
    }


}
